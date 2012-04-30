package com.thomasbiddle.puppywood;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;



public class GalleryActivity extends Activity {
		/* Called when the activity is first created. */ 
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.gallery);
	
	    Gallery gallery = (Gallery) findViewById(R.id.gallery);
	    gallery.setAdapter(new ImageAdapter(this));
	/*
	 * Commenting this out because I hate error triangles :D
	    gallery.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView parent, View v, int position, long id) {
	            Toast.makeText(GalleryActivity.this, "" + position, Toast.LENGTH_SHORT).show();
	        }
	    });
	    */
	}
    public class ImageAdapter extends BaseAdapter {
        int mGalleryItemBackground;
        private Context mContext;

        private Integer[] mImageIds = {
                R.drawable.pic1,
                R.drawable.pic2,
                R.drawable.pic3,
                R.drawable.pic4,
                R.drawable.pic5,
                R.drawable.pic6,
                R.drawable.pic7
        };

        public ImageAdapter(Context c) {
            mContext = c;
            //TypedArray attr = mContext.obtainStyledAttributes(R.styleable.Gallery);
            //mGalleryItemBackground = attr.getResourceId(
                   // R.styleable.Gallery_android_galleryItemBackground, 0);
           // attr.recycle();
        }

        public int getCount() {
            return mImageIds.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(mContext);

            imageView.setImageResource(mImageIds[position]);
            imageView.setLayoutParams(new Gallery.LayoutParams(150, 100));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setBackgroundResource(mGalleryItemBackground);

            return imageView;
        }
    }
	    
}







/*
 * Old Code while I play around
 
public class GalleryActivity extends Activity{
	boolean inImage = false; // Bool for if the user is viewing a large image.
	/** Called when the activity is first created. 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupGallery();
    }
    public void setupGallery() {
    	setContentView(R.layout.grid);
    	GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                setContentView(R.layout.image);
                Context context = getApplicationContext();
                ImageView imageView = new ImageView(context);
                imageView = (ImageView) findViewById(R.id.imageView1);
                String picID = "pic" + (position+1);
                inImage = true;
                imageView.setImageResource(getResources().getIdentifier(picID, "drawable","com.tjbiddle.puppywood"));
            }
        });
    }
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		/* If the user presses the back button and we are looking at a large image 
	    if (keyCode == KeyEvent.KEYCODE_BACK && inImage) {
	        	setupGallery();
	        	inImage = false;
	        	return true;
	    }
	    /* Otherwise, use the normal back button functionality 
	    else {
	    	return super.onKeyDown(keyCode, event);
	    }
	}	
}
*/