package com.thomasbiddle.puppywood;

import java.io.IOException;
import java.net.URLEncoder;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class OldCustomerActivity extends Activity {
	
	/** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oldcustomer);
        
        SharedPreferences userInfo = getSharedPreferences(NewCustomerActivity.USER_INFO, 0); // Restore our earlier saved info.
        EditText et;
        
        et = (EditText) findViewById(R.id.EditTextName);
        et.setText(userInfo.getString("name",""));
        et = (EditText) findViewById(R.id.EditTextEmail);
        et.setText(userInfo.getString("email",""));
		et = (EditText) findViewById(R.id.EditTextPetName); 
		et.setText(userInfo.getString("petname",""));
		et = (EditText) findViewById(R.id.EditTextMedication); 
		et.setText(userInfo.getString("petmed",""));
		et = (EditText) findViewById(R.id.EditTextFeeding); 
		et.setText(userInfo.getString("petfeeding",""));
		et = (EditText) findViewById(R.id.EditTextOther); 
		et.setText(userInfo.getString("other",""));
    }
	public void onSubmitOld(View v) {
		RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroom);
		int index = rg.getCheckedRadioButtonId();
		if (index < 0) {
	    	Context context = getApplicationContext();
	    	Toast toast = Toast.makeText(context, "Don't forget to select a grooming option :)", Toast.LENGTH_SHORT);
	    	toast.show();
	    	return;
		}
		else new TrySendForm().execute();
	}

   public void sendForm(View v) {
   	new TrySendForm().execute();
   }
   
   private class TrySendForm extends AsyncTask< Void, Integer, Boolean > {
   	ProgressDialog dialog;
   	protected void onPreExecute() {
       	dialog = ProgressDialog.show(OldCustomerActivity.this, "", 
                   "Just a second!", true);
       	dialog.show();
   	}
       protected Boolean doInBackground(Void...v) { // ToDo: Why in the hell does this need to be written this way?

			/* Retrieve Values */
		SharedPreferences userInfo = getSharedPreferences(NewCustomerActivity.USER_INFO, 0); // Save info for later
		SharedPreferences.Editor userInfoEditor = userInfo.edit();
		EditText et;
		RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroom);
		RadioButton rb;
		int index = rg.getCheckedRadioButtonId();
		
		et = (EditText) findViewById(R.id.EditTextName);
		String nameValue = et.getText().toString();
		userInfoEditor.putString("name", nameValue);
		et = (EditText) findViewById(R.id.EditTextEmail); 
		String emailValue = et.getText().toString();
		userInfoEditor.putString("email", emailValue);
		et = (EditText) findViewById(R.id.EditTextPetName); 
		String petsnameValue = et.getText().toString();
		userInfoEditor.putString("petname", petsnameValue);
		et = (EditText) findViewById(R.id.EditTextArrivalDate); 
		String arrivalDateValue = et.getText().toString();
		et = (EditText) findViewById(R.id.EditTextDepartureDate); 
		String departDateValue = et.getText().toString();
		et = (EditText) findViewById(R.id.EditTextMedication); 	
		String medicationValue = et.getText().toString();
		userInfoEditor.putString("petmed", medicationValue);
		et = (EditText) findViewById(R.id.EditTextFeeding); 
		String feedingValue = et.getText().toString();
		userInfoEditor.putString("petfeeding", feedingValue);
		rb = (RadioButton) findViewById(index);
		String groomingValue = rb.getText().toString();
		et = (EditText) findViewById(R.id.EditTextOther); 
		String otherValue = et.getText().toString();
		userInfoEditor.putString("other", otherValue);
			/* End Retrieve Values */ 
		userInfoEditor.commit();
      
   	    try {
   	    	// Execute HTTP Post Request    	    	
   	    	DefaultHttpClient httpclient = new DefaultHttpClient();
   	    	String info = "name=" + URLEncoder.encode(nameValue, "UTF-8") + 
						"&email=" + URLEncoder.encode(emailValue, "UTF-8") + 
						"&petname=" + URLEncoder.encode(petsnameValue, "UTF-8") +
						"&arrivaldate=" + URLEncoder.encode(arrivalDateValue, "UTF-8") +
						"&departdate=" + URLEncoder.encode(departDateValue, "UTF-8") +
						"&meds=" + URLEncoder.encode(medicationValue, "UTF-8") +
						"&feeding=" + URLEncoder.encode(feedingValue, "UTF-8") +
						"&grooming=" + URLEncoder.encode(groomingValue, "UTF-8") +
						"&other=" + URLEncoder.encode(otherValue, "UTF-8");
       	    HttpPost httppost = new HttpPost("http://thomasbiddle.com/puppywood/puppywoodMailExisting.php?" + info);
   	    	
	            httpclient.execute(httppost);
	            return true;
           
	        } catch (ClientProtocolException e1) {
	        	return false;
	        } catch (IOException e) {
	        	return false;
	        }
       }
       protected void onPostExecute(Boolean result) {
       	if (result) {
	        	dialog.dismiss();
	        	Toast.makeText(OldCustomerActivity.this, "Thanks, we'll be in touch!", Toast.LENGTH_SHORT).show();
	        	finish();
       	}
       	else {
       		Toast.makeText(OldCustomerActivity.this, "Looks like there was an error, do you have an internet connection?", Toast.LENGTH_SHORT).show();
       	}
       }
   }
   
}
