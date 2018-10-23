package com.example.yida.demo3.picture.glide.fresco;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.yida.demo3.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by yida on 2018/9/30.
 */

public class FrescoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco);


        initView();
    }

    private void initView() {
        String url = "http://img1.dzwww.com:8080/tupian_pl/20150813/16/7858995348613407436.jpg";
        String url1 = "https://upload-images.jianshu.io/upload_images/595349-38406b7143d16e38.png";


        SimpleDraweeView view = findViewById(R.id.image3);
        view.setImageURI(url);

    }
}
