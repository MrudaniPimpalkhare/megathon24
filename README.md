<h1>Pose Detection App</h1>

<p>Welcome to PoseSnap, your ultimate tool for achieving a perfect posture and a healthier you! Our cutting-edge Posture Detect AI technology brings advanced pose analysis right to your fingertips. With PoseSnap, you can effortlessly assess your body posture from any image in your gallery, gain valuable insights about body angles, and visualize your progress towards a confident and aligned stance.</p>

<a href="https://play.google.com/store/apps/details?id=com.ibrahimcanerdogan.posedetectionapp"><img width="90" height="90" src="https://img.icons8.com/?size=512&id=L1ws9zn2uD01&format=png"/></a>

<p>The ML Kit Pose Detection API is a lightweight versatile solution for app developers to detect the pose of a subject's body in real time from a continuous video or static image. A pose describes the body's position at one moment in time with a set of skeletal landmark points. The landmarks correspond to different body parts such as the shoulders and hips. The relative positions of landmarks can be used to distinguish one pose from another.</p>

<p>ML Kit Pose Detection produces a full-body 33 point skeletal match that includes facial landmarks (ears, eyes, mouth, and nose) and points on the hands and feet. Figure 1 below shows the landmarks looking through the camera at the user, so it's a mirror image. The user's right side appears on the left of the image:</p>

<img src="https://github.com/icanerdogan/PoseDetectionApp-MLKit/assets/52867508/c1466a8f-ca78-4fc0-869c-253134d9ca5b">

<p>ML Kit Pose Detection doesn't require specialized equipment or ML expertise in order to achieve great results. With this technology developers can create one of a kind experiences for their users with only a few lines of code.</p>

<p>The user's face must be present in order to detect a pose. Pose detection works best when the subject’s entire body is visible in the frame, but it also detects a partial body pose. In that case the landmarks that are not recognized are assigned coordinates outside of the image.</p>

<h2> Key capabilities </h2>
<ul>
<li>Cross-platform support Enjoy the same experience on both Android and iOS.</li>
<li>Full body tracking The model returns 33 key skeletal landmark points, including the positions of the hands and feet.</li>
<li>InFrameLikelihood score For each landmark, a measure that indicates the probability that the landmark is within the image frame. The score has a range of 0.0 to 1.0, where 1.0 indicates high confidence.</li>
<li>Two optimized SDKs The base SDK runs in real time on modern phones like the Pixel 4 and iPhone X. It returns results at the rate of ~30 and ~45 fps respectively. However, the precision of the landmark coordinates may vary. The accurate SDK returns results at a slower framerate, but produces more accurate coordinate values.</li>
<li>Z Coordinate for depth analysis This value can help determine whether parts of the users body are in front or behind the users' hips. For more information, see the Z Coordinate section below.</li>
</ul>

<h2> Pose Detection App Preview </h2>

Main Screen        |  Posture Screen       |  Angle Screen
:-------------------------:|:-------------------------:|:-------------------------:
![](https://github.com/icanerdogan/PoseDetectionApp-MLKit/assets/52867508/0eb424c5-e2fe-4663-a466-6ea3759d2b11)  |  ![](https://github.com/icanerdogan/PoseDetectionApp-MLKit/assets/52867508/c50996a5-ef32-4048-95ce-90d7952d27aa) | ![](https://github.com/icanerdogan/PoseDetectionApp-MLKit/assets/52867508/2550b77f-e15b-466c-bd5f-f4fee496ed78)

<h2> LICENSE </h2>

````
MIT License

Copyright (c) 2023 İbrahim Can Erdoğan

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
