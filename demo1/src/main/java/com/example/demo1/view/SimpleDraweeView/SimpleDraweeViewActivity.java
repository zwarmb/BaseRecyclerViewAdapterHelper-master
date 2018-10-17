package com.example.demo1.view.SimpleDraweeView;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.demo1.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by yida on 2018/6/22.
 */

public class SimpleDraweeViewActivity extends AppCompatActivity {

    private SimpleDraweeView mSimpleDraweeView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_simpledraweeview);

        initView();
    }

    private void initView() {
        mSimpleDraweeView = findViewById(R.id.sdv_image);

        // 记得要加联网权限
        Uri imageUri = Uri.parse("https://img-blog.csdn.net/20151015101828750");
        mSimpleDraweeView.setImageURI(imageUri);

    }
}
