package com.urancompany.exhibitions.ui.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.urancompany.exhibitions.R;

public class CustomPagerAdapter extends PagerAdapter {

    private Context mContext;
    private String[] mImageArray;

    CustomPagerAdapter(Context context, String[] images) {
        this.mContext = context;
        this.mImageArray = images;
    }

    @Override
    public int getCount() {
        return mImageArray.length;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.pager_item, container, false);

        assert view != null;
        ImageView imageView = view.findViewById(R.id.image);

        Picasso.get()
                .load(mImageArray[position])
                .placeholder(imageView.getDrawable())
                .networkPolicy(NetworkPolicy.NO_STORE)
                .into(imageView);

        container.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }
}
