package com.example.viewpagerdemo1;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.viewpagerdemo1.utils.DensityUtil;

/**
 * Created by Administrator on 2018/1/4.
 */

public class ViewPagerDemo1Adapter extends PagerAdapter{
    private int[] images;
    private Context mContext;

    public ViewPagerDemo1Adapter(int[] images, Context context) {
        this.images = images;
        mContext = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        final ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(DensityUtil.dip2px(mContext, 200), DensityUtil.dip2px(mContext, 400)));
        imageView.setImageResource(images[position]);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Log.e("1111", position + "i");
            }
        });
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
