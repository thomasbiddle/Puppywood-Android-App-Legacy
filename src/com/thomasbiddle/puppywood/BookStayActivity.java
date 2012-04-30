package com.thomasbiddle.puppywood;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class BookStayActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookstay);
	}
	public void existingAccount(View v) {
		Intent intent = new Intent().setClass(this, OldCustomerActivity.class);
		startActivity(intent);
		finish();
	}
	public void newAccount (View v) {
		Intent intent = new Intent().setClass(this, NewCustomerActivity.class);
		startActivity(intent);
		finish();
	}
}
