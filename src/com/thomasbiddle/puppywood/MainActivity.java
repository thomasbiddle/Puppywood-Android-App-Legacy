package com.thomasbiddle.puppywood;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.common.io.Closeables;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_feed);
        
        new LoadTweets().execute();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity, menu);
        return true;
    }
    
    private class LoadTweets extends AsyncTask<Void, Void, ArrayList<Tweet>> {
    	
    	private Gson mGson = new Gson();

		// Since I always am confused by this ... syntax - This SO question explains it well:
		// http://stackoverflow.com/a/6343250/1125714
		@Override
		protected ArrayList<Tweet> doInBackground(Void... params) {
			HttpURLConnection connection = null;
			BufferedInputStream results = null;
			Type typeOfT = new TypeToken<ArrayList<Tweet>>(){}.getType();
			try{
				String connectionURL = "http://thomasbiddle.com/puppywood/new_app/puppywood_tweets.php";
				connection = (HttpURLConnection)new URL(connectionURL).openConnection();
				results = new BufferedInputStream(connection.getInputStream());
				return mGson.fromJson(new InputStreamReader(results, "UTF-8"), typeOfT);
			}
			catch(MalformedURLException e){
				// ignore, return null
			}
			catch(IOException e){
				// ignore, return null
			}
			finally{
				Closeables.closeQuietly(results);
			}
			return null;
		}
		
	     protected void onPostExecute(ArrayList<Tweet> results) { 
            for (int i = 0; i < results.size(); i++) {
            	TextView tv = new TextView(getApplicationContext());
            	String tweet = results.get(i).text;
            	tv.setText(tweet);
                ViewGroup layout = (ViewGroup) findViewById(R.id.linearLayoutMainFeed);
                layout.addView(tv);
            }
	     }
    }
    
	public static class Tweet
	{
		public String  created_at;
		public long    id;
		public String  text;
		public String  source;
		public boolean truncated;
		public long    retweet_count;
	}

}