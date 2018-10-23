package com.example.yida.demo3.picture.glide;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.ViewPropertyAnimation;
import com.example.yida.demo3.R;

import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * Created by yida on 2018/9/29.
 */

public class GlideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        initView();
    }


    /**
     * 网络图片加载不出来可能是没有设置联网的权限
     */
    private void initView() {
        String url = "http://img1.dzwww.com:8080/tupian_pl/20150813/16/7858995348613407436.jpg";
        String url1 = "https://upload-images.jianshu.io/upload_images/595349-38406b7143d16e38.png";
        ImageView imageView = findViewById(R.id.image1);
        ImageView imageView1 = findViewById(R.id.image2);
        Glide.with(this)
                .load(url)
                .thumbnail(0.3f)
                .crossFade()  // 开启显示动画
//                .override(100, 150) // 裁剪原图到宽高 200 px 大小
//                .centerCrop() // 将图片按比例缩放到足以填充 imageview 的尺寸, 可能会导致图片显示不完整
//                .fitCenter()  // 把图片缩放到小于等于 imageview 的尺寸, 这样图片显示完整, 但是 imageview 可能不会被填充

                .skipMemoryCache(true) // 磁盘缓存
                .diskCacheStrategy(DiskCacheStrategy.NONE) // 内存缓存

                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.f)
                .animate(mAnimator)
                .into(imageView);


        Glide.with(this)
                .load(url1)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.drawable.ic_launcher_background)
                .crossFade(2000)
                // 这个是设置高斯模糊, 需要引用扩展库,  radius :  设置模糊度( 在 0 到 25 之间 ),  sampling : 图片的缩放比例, 默认为 1
                .bitmapTransform(new BlurTransformation(getApplicationContext(), 12, 1))
                .skipMemoryCache(true) // 磁盘缓存
                .diskCacheStrategy(DiskCacheStrategy.NONE) // 内存缓存
                // 自定义的图片圆角
                .transform(new GlideCircleTransform(getApplicationContext()))
                .into(imageView1);
    }


    ViewPropertyAnimation.Animator mAnimator = new ViewPropertyAnimation.Animator() {
        @Override
        public void animate(View view) {
            view.setAlpha(0f);

            ObjectAnimator animator = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f);
            animator.setDuration( 5000 );
            animator.start();
        }
    };
}
