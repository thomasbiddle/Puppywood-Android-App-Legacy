package com.thomasbiddle.puppywood;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/*
 * This class works with GridView (Used in GalleryActivity) to display the GridView. 
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
    		R.drawable.pic1, 
    		R.drawable.pic2, 
    		R.drawable.pic3,
    		R.drawable.pic4, 
    		R.drawable.pic5,
    		R.drawable.pic6, 
    		R.drawable.pic7, 
    		R.drawable.pic8,
    		R.drawable.pic9, 
    		R.drawable.pic10,
    		R.drawable.pic11, 
    		R.drawable.pic12, 
    		R.drawable.pic13,
    		R.drawable.pic14, 
    		R.drawable.pic15,
    		R.drawable.pic16, 
    		R.drawable.pic17, 
    		R.drawable.pic18,
    		R.drawable.pic19,
    		R.drawable.pic20,
    		R.drawable.pic21, 
    		R.drawable.pic22, 
    		R.drawable.pic23,
    		R.drawable.pic24, 
    		R.drawable.pic25,
    		R.drawable.pic26, 
    		R.drawable.pic27, 
    		R.drawable.pic28,
    		R.drawable.pic29, 
    		R.drawable.pic30,
    		R.drawable.pic31, 
    		R.drawable.pic32, 
    		R.drawable.pic33,
    		R.drawable.pic34, 
    		R.drawable.pic35,
    		R.drawable.pic36, 
    		R.drawable.pic37, 
    		R.drawable.pic38,
    		R.drawable.pic39,
    		R.drawable.pic40
    };
}