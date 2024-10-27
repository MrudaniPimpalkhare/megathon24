//package com.ibrahimcanerdogan.posedetectionapp
//
//import androidx.camera.core.ImageAnalysis
//import androidx.camera.core.ImageProxy
//import com.google.mlkit.vision.common.InputImage
//import com.google.mlkit.vision.pose.PoseDetection
//import com.google.mlkit.vision.pose.accurate.AccuratePoseDetectorOptions
//
//
//
//class PoseImageAnalyzer(
//    private val viewModel: PoseViewModel,
//    private val onFeedback: (String) -> Unit
//) : ImageAnalysis.Analyzer {
//
//    private val poseDetector = PoseDetection.getClient(
//        AccuratePoseDetectorOptions.Builder()
//            .setDetectorMode(AccuratePoseDetectorOptions.STREAM_MODE)
//            .build()
//    )
//
//    @androidx.camera.core.ExperimentalGetImage
//    override fun analyze(imageProxy: ImageProxy) {
//        val mediaImage = imageProxy.image
//        if (mediaImage != null) {
//            val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)
//
//            poseDetector.process(image)
//                .addOnSuccessListener { pose ->
//                    // Process the pose and get feedback
//                    val feedback = viewModel.processPose(pose)
//                    onFeedback(feedback)
//                }
//                .addOnFailureListener { e ->
//                    onFeedback("Pose detection failed: ${e.localizedMessage}")
//                }
//                .addOnCompleteListener {
//                    imageProxy.close()
//                }
//        } else {
//            imageProxy.close()
//        }
//    }
//}


package com.ibrahimcanerdogan.posedetectionapp

import android.graphics.Bitmap
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.pose.Pose
import com.google.mlkit.vision.pose.PoseDetection
import com.google.mlkit.vision.pose.accurate.AccuratePoseDetectorOptions
import android.content.Context

class PoseImageAnalyzer(
    private val context: Context,
    val viewModel: PoseViewModel,
    val onFeedback: (String) -> Unit

) : ImageAnalysis.Analyzer {

    private val poseDetector = PoseDetection.getClient(
        AccuratePoseDetectorOptions.Builder()
            .setDetectorMode(AccuratePoseDetectorOptions.STREAM_MODE)
            .build()
    )

    @androidx.camera.core.ExperimentalGetImage
    override fun analyze(imageProxy: ImageProxy) {
        val mediaImage = imageProxy.image
        if (mediaImage != null) {
            val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)

            // Convert media image to bitmap for processing
            val bitmap = imageToBitmap(mediaImage)

            poseDetector.process(image)
                .addOnSuccessListener { detectedPose ->
                    // Process the pose and get feedback


                    val feedback = viewModel.processPose(context, bitmap, detectedPose)
                    if (feedback.isNotEmpty()) {
                        onFeedback(feedback.toString())
                    }
                }
                .addOnFailureListener { e ->
                    onFeedback("Pose detection failed: ${e.localizedMessage}")
                }
                .addOnCompleteListener {
                    imageProxy.close()
                }
        } else {
            imageProxy.close()
        }
    }

    private fun imageToBitmap(image: android.media.Image): Bitmap {
        val planes = image.planes
        val yBuffer = planes[0].buffer
        val uBuffer = planes[1].buffer
        val vBuffer = planes[2].buffer

        val ySize = yBuffer.remaining()
        val uSize = uBuffer.remaining()
        val vSize  = vBuffer.remaining()

        val nv21 = ByteArray(ySize + uSize + vSize)

        yBuffer.get(nv21, 0, ySize)
        vBuffer.get(nv21, ySize, vSize)
        uBuffer.get(nv21, ySize + vSize, uSize)

        val yuvImage = android.graphics.YuvImage(nv21, android.graphics.ImageFormat.NV21, image.width, image.height, null)
        val out = java.io.ByteArrayOutputStream()
        yuvImage.compressToJpeg(android.graphics.Rect(0, 0, yuvImage.width, yuvImage.height), 100, out)
        val imageBytes = out.toByteArray()
        return android.graphics.BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
    }
}