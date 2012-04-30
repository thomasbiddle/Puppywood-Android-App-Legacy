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
import android.widget.Spinner;
import android.widget.Toast;

public class NewCustomerActivity extends Activity {
	
	public static final String USER_INFO = "UserInfoFile"; // This file will the store the user's information for later use.
	
	/** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newcustomer);
        SharedPreferences userInfo = getSharedPreferences(USER_INFO, 0); // Restore our earlier saved info.
        EditText et;
        
        et = (EditText) findViewById(R.id.EditTextName);
        et.setText(userInfo.getString("name",""));
        et = (EditText) findViewById(R.id.EditTextEmail);
        et.setText(userInfo.getString("email",""));
        et = (EditText) findViewById(R.id.EditTextAddress);
        et.setText(userInfo.getString("address",""));
        et = (EditText) findViewById(R.id.EditTextPhone); 
        et.setText(userInfo.getString("phone",""));
		et = (EditText) findViewById(R.id.EditTextPetName); 
		et.setText(userInfo.getString("petname",""));
		et = (EditText) findViewById(R.id.EditTextPetBreed); 
		et.setText(userInfo.getString("petbreed",""));
		et = (EditText) findViewById(R.id.EditTextVetName); 
		et.setText(userInfo.getString("vetname",""));
		et = (EditText) findViewById(R.id.EditTextVetPhone); 
		et.setText(userInfo.getString("vetphone",""));
		et = (EditText) findViewById(R.id.EditTextMedication); 
		et.setText(userInfo.getString("petmed",""));
		et = (EditText) findViewById(R.id.EditTextFeeding); 
		et.setText(userInfo.getString("petfeeding",""));
		et = (EditText) findViewById(R.id.EditTextOther); 
		et.setText(userInfo.getString("other",""));
    }
	
	public void onSubmitNew(View v) {
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
	
	private class TrySendForm extends AsyncTask< Void, Integer, Boolean > {
	   	ProgressDialog dialog;
	   	protected void onPreExecute() {
	       	dialog = ProgressDialog.show(NewCustomerActivity.this, "", 
	                   "Just a second!", true);
	       	dialog.show();
	   	}
	       protected Boolean doInBackground(Void...v) { // ToDo: Why in the hell does this need to be written this way?

				/* Retrieve Values */
	    	   SharedPreferences userInfo = getSharedPreferences(USER_INFO, 0); // Save info for later
	   		SharedPreferences.Editor userInfoEditor = userInfo.edit();
	   		EditText et;
	   		Spinner sp;
	   		RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroom);
	   		RadioButton rb;
	   		int index = rg.getCheckedRadioButtonId();
	   		
	   		et = (EditText) findViewById(R.id.EditTextName);
	   		String nameValue = et.getText().toString();
	   		userInfoEditor.putString("name", nameValue);
	   		et = (EditText) findViewById(R.id.EditTextEmail); 
	   		String emailValue = et.getText().toString();
	   		userInfoEditor.putString("email", emailValue);
	   		et = (EditText) findViewById(R.id.EditTextAddress); 
	   		String addressValue = et.getText().toString();
	   		userInfoEditor.putString("address", addressValue);
	   		et = (EditText) findViewById(R.id.EditTextPhone); 
	   		String phoneValue = et.getText().toString();
	   		userInfoEditor.putString("phone", phoneValue);
	   		et = (EditText) findViewById(R.id.EditTextPetName); 
	   		String petsnameValue = et.getText().toString();
	   		userInfoEditor.putString("petname", petsnameValue);
	   		et = (EditText) findViewById(R.id.EditTextPetBreed); 
	   		String petsbreedValue = et.getText().toString();
	   		userInfoEditor.putString("petbreed", petsbreedValue);
	   		sp = (Spinner) findViewById(R.id.SpinnerPetGender); 
	   		String petsgenderValue = sp.getSelectedItem().toString();
	   		sp = (Spinner) findViewById(R.id.SpinnerPetFixedStatus); 
	   		String fixedStatusValue = sp.getSelectedItem().toString();
	   		et = (EditText) findViewById(R.id.EditTextVetName); 
	   		String vetNameValue = et.getText().toString();
	   		userInfoEditor.putString("vetname", vetNameValue);
	   		et = (EditText) findViewById(R.id.EditTextVetPhone); 
	   		String vetPhoneValue = et.getText().toString();
	   		userInfoEditor.putString("vetphone", vetPhoneValue);
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
	   	    	String info = "name=" + URLEncoder.encode(nameValue) + 
							"&email=" + URLEncoder.encode(emailValue) + 
							"&address=" + URLEncoder.encode(addressValue) +
							"&number=" + URLEncoder.encode(phoneValue) +
							"&petbreed=" + URLEncoder.encode(petsbreedValue) +
							"&gender=" + URLEncoder.encode(petsgenderValue) +
							"&petname=" + URLEncoder.encode(petsnameValue) +
							"&fixedstatus=" + URLEncoder.encode(fixedStatusValue) +
							"&vetname=" + URLEncoder.encode(vetNameValue) +
							"&vetphone=" + URLEncoder.encode(vetPhoneValue) +
							"&arrivaldate=" + URLEncoder.encode(arrivalDateValue) +
							"&departdate=" + URLEncoder.encode(departDateValue) +
							"&meds=" + URLEncoder.encode(medicationValue) +
							"&feeding=" + URLEncoder.encode(feedingValue) +
							"&grooming=" + URLEncoder.encode(groomingValue) +
							"&other=" + URLEncoder.encode(otherValue);
	       	    HttpPost httppost = new HttpPost("http://thomasbiddle.com/puppywood/puppywoodMailNew.php?" + info);
	   	    	
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
		        	Toast.makeText(NewCustomerActivity.this, "Thanks, we'll be in touch!", Toast.LENGTH_SHORT).show();
		        	finish();
	       	}
	       	else {
	       		Toast.makeText(NewCustomerActivity.this, "Looks like there was an error, do you have an internet connection?", Toast.LENGTH_SHORT).show();
	       	}
	       }
	   }
}
