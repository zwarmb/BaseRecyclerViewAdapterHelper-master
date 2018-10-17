package com.example.demo1.view.viewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yida on 2018/7/24.
 */

public class ViewPagerAdapter extends PagerAdapter {
    private Context mContext;
    private List<ImageView> mImageViewList = new ArrayList<>();
    private List<Integer> mIntegerList;

    public ViewPagerAdapter(Context context, List<Integer> integerList) {
        mContext = context;
        mIntegerList = integerList;
    }

    @Override
    public int getCount() {
        return mIntegerList != null ? mIntegerList.size() : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ImageView imageView = (ImageView) object;
        container.removeView(imageView);
        mImageViewList.add(imageView);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView iv = null;
        if (mImageViewList.isEmpty()) {
            iv = new ImageView(mContext);
            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            iv = mImageViewList.remove(0);
        }

        iv.setImageResource(mIntegerList.get(position));
        container.addView(iv);
        return iv;
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }
}
