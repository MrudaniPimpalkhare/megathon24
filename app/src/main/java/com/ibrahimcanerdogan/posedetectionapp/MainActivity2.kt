package com.ibrahimcanerdogan.posedetectionapp

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ibrahimcanerdogan.posedetectionapp.databinding.ActivityMain2Binding
import com.ibrahimcanerdogan.posedetectionapp.utils.AlertDialog
import com.ibrahimcanerdogan.posedetectionapp.utils.AngleInstance
import com.ibrahimcanerdogan.posedetectionapp.utils.BitmapInstance
import com.ibrahimcanerdogan.posedetectionapp.utils.ImageUtils

class MainActivity2 : AppCompatActivity() {

    private val binding by lazy { ActivityMain2Binding.inflate(layoutInflater) }
    private var poseImage : Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.imageViewPose.setImageResource(0)
        poseImage = BitmapInstance.getInstance()?.getBitmap()
        binding.imageViewPose.setImageBitmap(poseImage)

        buttonClicks()
    }

    private fun buttonClicks() {
        binding.buttonBack.setOnClickListener {
            binding.imageViewPose.setImageResource(0)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.buttonDownload.setOnClickListener {
            ImageUtils.saveImage(BitmapInstance.getInstance()?.getBitmap()!!, this)
        }
        binding.buttonInfo.setOnClickListener {
            AlertDialog.informationDialog(
                this,
                "Angle Information",
                AngleInstance.getInstance()?.getAngle()
            )
        }
    }
}