package com.thomasbiddle.puppywood.mjpeg;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MjpegSample extends Activity {
	private MjpegView mv;
	private String URL = "http://puppywood.mypets.ws/mjpg/quad/video.mjpg";
	
	public void startCam() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                             WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        mv = new MjpegView(this);
        setContentView(mv);        
        
        mv.setSource(MjpegInputStream.read(URL));
        mv.setDisplayMode(MjpegView.SIZE_BEST_FIT);
        mv.showFps(true);
	}
    /** Called when the activity is first created. */
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.webcam);
        startCam();
	}
	public void startCam1(View v) {
		URL = "http://puppywood.mypets.ws/mjpg/quad/video.mjpg";
		startCam();
	}
	
	public void onPause() {
		super.onPause();
		mv.stopPlayback();
	}
}
