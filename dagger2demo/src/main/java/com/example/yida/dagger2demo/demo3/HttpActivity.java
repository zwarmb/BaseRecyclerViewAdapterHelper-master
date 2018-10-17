package com.example.yida.dagger2demo.demo3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.yida.dagger2demo.R;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

/**
 * Created by yida on 2018/7/31.
 */

public class HttpActivity extends AppCompatActivity {

    @Inject
    OkHttpClient mOkHttpClient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DaggerHttpActivityCompnent.create().inject(this);
    }
}
