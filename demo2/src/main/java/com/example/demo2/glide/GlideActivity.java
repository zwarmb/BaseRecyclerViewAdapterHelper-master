package com.example.demo2.glide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.demo2.R;

/**
 * Created by yida on 2018/9/28.
 */

public class GlideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        initView();

    }

    /**
     * 初始化view
     */
    private void initView() {
        ImageView imageView = findViewById(R.id.image1);
        String url = "http://img1.dzwww.com:8080/tupian_pl/20150813/16/7858995348613407436.jpg";

//        Glide.with(getApplicationContext())
//                .load(url)
//                .into(imageView);



    }


}
