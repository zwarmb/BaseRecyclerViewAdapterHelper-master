package com.example.viewpagerdemo1.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Administrator on 2018/1/5.
 */

public class GalleryTransformer implements ViewPager.PageTransformer {
    private final float MAX_ALPHA = 0.5f;
    private static final float MAX_SCALE = 0.9f;

    @Override
    public void transformPage(View page, float position) {
        if (position < -1 || position > 1){
            // 左右各第二张为不可见的图片区域
            page.setAlpha(MAX_ALPHA);
            page.setScaleX(MAX_SCALE);
            page.setScaleY(MAX_SCALE);
        }else {
            // 透明效果
            if (position <= 0){
                // pos[-1,0]区域
                page.setAlpha(MAX_ALPHA + MAX_ALPHA * (position + 1));
            }else {
                // pos[0,1]区域
                page.setAlpha(MAX_ALPHA + MAX_ALPHA * (1 - position));
            }
            // 滑动缩放
            float scale = Math.max(MAX_SCALE, 1 - Math.abs(position));
            page.setScaleX(scale);
            page.setScaleY(scale);
        }
    }
}
