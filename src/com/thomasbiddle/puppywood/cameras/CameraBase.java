package com.thomasbiddle.puppywood.cameras;

import com.thomasbiddle.puppywood.mjpeg.MjpegInputStream;
import com.thomasbiddle.puppywood.mjpeg.MjpegView;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class CameraBase extends Activity {
	protected MjpegView mv;
	protected String URL = cameraUrl();
	
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
	
	public void onPause() {
		super.onPause();
		mv.stopPlayback();
	}
	
	protected String cameraUrl() {
		return "";
	}
}