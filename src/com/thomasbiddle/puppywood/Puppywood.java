package com.thomasbiddle.puppywood;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;


public class Puppywood extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void viewGallery(View v)
    {
    	Intent intent = new Intent().setClass(Puppywood.this, GalleryActivity.class);
    	startActivity(intent);  	
    }
    public void viewWebcams(View v) {
    	Intent intent = new Intent().setClass(this, WebcamActivity.class);
    	startActivity(intent);
    }
    public void visitWebsite(View v)
    {
    	Intent i = new Intent(Intent.ACTION_VIEW);
    	i.setData(Uri.parse("http://www.puppywood.com/"));
    	startActivity(i);
    }
    public void bookStay(View v)
    {
    	Intent intent = new Intent().setClass(Puppywood.this, BookStayActivity.class);
    	startActivity(intent);
    }
    public void contactUs(View v)
    {
    	Intent intent = new Intent().setClass(Puppywood.this, ContactActivity.class);
    	startActivity(intent);
    }
    public void fbClick(View v) {
    	Intent intent = new Intent(Intent.ACTION_VIEW);
    	intent.setClassName("com.facebook.katana", "com.facebook.katana.ProfileTabHostActivity");
    	intent.putExtra("extra_user_id", 1249590128);
    	this.startActivity(intent);
    }
    public void twitterClick(View v) {
    	
    }
}