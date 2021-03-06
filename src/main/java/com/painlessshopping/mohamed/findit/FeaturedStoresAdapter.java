package com.painlessshopping.mohamed.findit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Adapter to help control the view of the cart
 */

public class FeaturedStoresAdapter extends BaseAdapter {
    private Context mContext;

    public FeaturedStoresAdapter(Context c) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(264, 164));
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mLinks[position]));
                mContext.startActivity(browserIntent);

            }
        });
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.bb_logo, R.drawable.cc_logo, R.drawable.st_logo, R.drawable.ch_logo, R.drawable.ro_logo, R.drawable.ps_logo, R.drawable.eg_logo, R.drawable.mt_logo, R.drawable.sc_logo, R.drawable.rc_logo, R.drawable.lo_logo, R.drawable.ms_logo, R.drawable.hm_logo
    };

    private String[] mLinks = {
            "http://www.bestbuy.ca",
            "http://www.canadacomputers.com",
            "http://www.staples.ca",
            "https://www.chapters.indigo.ca/en-ca/",
            "http://www.roots.com/ca/en/homepage",
            "http://www.petsmart.ca/",
            "https://www.ebgames.ca/",
            "http://www.mastermindtoys.com/",
            "https://www.sportchek.ca/",
            "http://www.rcsuperstore.com/",
            "https://www.loblaws.ca/",
            "https://www.marks.com/en/home-page.html",
	        "http://www2.hm.com/en_ca/index.html"
    };
}
