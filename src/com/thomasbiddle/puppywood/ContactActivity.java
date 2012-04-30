package com.thomasbiddle.puppywood;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ContactActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);
    }
	public void linkEmailClicked(View v)
    {
        Intent it = new Intent(android.content.Intent.ACTION_SEND);
        String recipient = "puppywoodinfo@yahoo.com";
        it.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{recipient});
        it.putExtra(android.content.Intent.EXTRA_SUBJECT, "Getting in Touch!");
        it.setType("text/plain");
        startActivity(it);
    }
    public void linkAddressClicked(View v)
    {
    	Context context = getApplicationContext();
    	Toast toast = Toast.makeText(context, "Please wait while the address loads...", Toast.LENGTH_LONG);
    	toast.show();
    	String uri = "geo:0,0?q=8175 Hetz Drive Cincinnati Ohio";
    	startActivity(new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri)));
    }
    public void linkDialNumber(View v)
    {
    	try{
    	Intent it = new Intent(Intent.ACTION_CALL);
    	it.setData(Uri.parse("tel:5134892275"));
    	startActivity(it);
    	} catch (Exception e) {
    		Toast toast = Toast.makeText(getApplicationContext(), "Call Failed", Toast.LENGTH_LONG);
    		toast.show();
    	}
    }
}
