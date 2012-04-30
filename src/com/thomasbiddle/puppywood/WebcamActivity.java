package com.thomasbiddle.puppywood;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;


/*
 * 
 * 
 * This class doesn't really have anything - Just code I was playing
 * around with!
 * 
 * 
 */

public class WebcamActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webcam);
    }
    
    public void goToCamera(View v) {
    	Spinner sp = (Spinner) findViewById(R.id.Spinner_Webcam);
    	String currentWebcam = sp.getSelectedItem().toString();
    	Toast t = Toast.makeText(getApplicationContext(), currentWebcam, Toast.LENGTH_SHORT);
    	t.show();
    	if (currentWebcam.equalsIgnoreCase("Quad Camera 1")) {
    		Intent intent = new Intent().setClass(this, com.thomasbiddle.puppywood.mjpeg.CameraQuad1.class);
    		startActivity(intent);
    	}
    	else if(currentWebcam.equalsIgnoreCase("Quad Camera 2")) {
    		Intent intent = new Intent().setClass(this, com.thomasbiddle.puppywood.mjpeg.CameraQuad2.class);
        	startActivity(intent);
    	}
		else if(currentWebcam.equalsIgnoreCase("Camera 1")) {
			Intent intent = new Intent().setClass(this, com.thomasbiddle.puppywood.mjpeg.Camera1.class);
	    	startActivity(intent);
		}
		else if(currentWebcam.equalsIgnoreCase("Camera 2")) {
			Intent intent = new Intent().setClass(this, com.thomasbiddle.puppywood.mjpeg.Camera2.class);
	    	startActivity(intent);
		}
		else if(currentWebcam.equalsIgnoreCase("Camera 3")) {
			Intent intent = new Intent().setClass(this, com.thomasbiddle.puppywood.mjpeg.Camera3.class);
	    	startActivity(intent);
		}
		else if(currentWebcam.equalsIgnoreCase("Camera 4")) {
			Intent intent = new Intent().setClass(this, com.thomasbiddle.puppywood.mjpeg.Camera4.class);
	    	startActivity(intent);
		}
		else if(currentWebcam.equalsIgnoreCase("Camera 5")) {
			Intent intent = new Intent().setClass(this, com.thomasbiddle.puppywood.mjpeg.Camera5.class);
	    	startActivity(intent);
		}
		else if(currentWebcam.equalsIgnoreCase("Camera 6")) {
			Intent intent = new Intent().setClass(this, com.thomasbiddle.puppywood.mjpeg.Camera6.class);
	    	startActivity(intent);
		}
		else if(currentWebcam.equalsIgnoreCase("Camera 7")) {
			Intent intent = new Intent().setClass(this, com.thomasbiddle.puppywood.mjpeg.Camera7.class);
	    	startActivity(intent);
		}
		else if(currentWebcam.equalsIgnoreCase("Camera 8")) {
			Intent intent = new Intent().setClass(this, com.thomasbiddle.puppywood.mjpeg.Camera8.class);
	    	startActivity(intent);
		}
    }
    
    public void startCam1(View v) {
    	Intent intent = new Intent().setClass(this, com.thomasbiddle.puppywood.mjpeg.Camera1.class);
    	startActivity(intent);
    }
    
    public void startCam2(View v) {
    	Intent intent = new Intent().setClass(this, com.thomasbiddle.puppywood.mjpeg.Camera2.class);
    	startActivity(intent);
    }
    
    public void startCam3(View v) {
    	Intent intent = new Intent().setClass(this, com.thomasbiddle.puppywood.mjpeg.Camera3.class);
    	startActivity(intent);
    }
    
    public void startCam4(View v) {
    	Intent intent = new Intent().setClass(this, com.thomasbiddle.puppywood.mjpeg.Camera4.class);
    	startActivity(intent);
    }
    
    public void startCam5(View v) {
    	Intent intent = new Intent().setClass(this, com.thomasbiddle.puppywood.mjpeg.Camera5.class);
    	startActivity(intent);
    }
    
    public void startCam6(View v) {
    	Intent intent = new Intent().setClass(this, com.thomasbiddle.puppywood.mjpeg.Camera6.class);
    	startActivity(intent);
    }
    
    public void startQuad1(View v) {
    	Intent intent = new Intent().setClass(this, com.thomasbiddle.puppywood.mjpeg.CameraQuad1.class);
    	startActivity(intent);
    }
    
    public void startQuad2(View v) {
    	Intent intent = new Intent().setClass(this, com.thomasbiddle.puppywood.mjpeg.CameraQuad2.class);
    	startActivity(intent);
    }
   
}
