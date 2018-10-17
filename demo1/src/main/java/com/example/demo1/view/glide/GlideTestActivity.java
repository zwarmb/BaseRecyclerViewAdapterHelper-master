package com.example.demo1.view.glide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.demo1.R;

/**
 * Created by yida on 2018/6/27.
 */

public class GlideTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glide_activity);
        initView();

    }

    private void initView() {
        String url = "http://guolin.tech/book.png";

        ImageView imageView = findViewById(R.id.iv_g_1);

//        Glide.with(getApplicationContext())
//                .load(url)
//                .apply(new RequestOptions().circleCrop())
//                .into(imageView);

    }
}
