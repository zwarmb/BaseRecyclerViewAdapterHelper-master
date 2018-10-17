package com.example.tupianbianxiangqingye;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Administrator on 2018/1/8.
 */

public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.9f;
    private static final float MIN_ALPHA = 0.5f;

    @Override
    public void transformPage(View page, float position) {
        int pageWidth = page.getWidth();
        int pageHeight = page.getHeight();

        if (position < -1 || position > 1) {
            // 左右看不到的第二张图片区域
            page.setAlpha(0);
            page.setScaleX(MIN_SCALE);
            page.setScaleY(MIN_SCALE);
        }else {
            // 滑动缩放
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float vertMargin = pageHeight * (1 - scaleFactor) / 2;
            float horzMargin = pageWidth * (1 - scaleFactor) / 2;
            if (position < 0){
                page.setTranslationX(horzMargin - vertMargin / 2);
            }else {
                page.setTranslationX(-horzMargin + vertMargin / 2);
            }

            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
            page.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA));
        }
    }
}
