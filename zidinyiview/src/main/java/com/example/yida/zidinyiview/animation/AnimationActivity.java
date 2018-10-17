package com.example.yida.zidinyiview.animation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.yida.zidinyiview.R;

/**
 * Created by yida on 2018/9/11.
 */

public class AnimationActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        mImageView = findViewById(R.id.imageView);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha_anim);
        mImageView.startAnimation(animation);
    }
}
