package com.example.yida.demo3;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by yida on 2018/9/30.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化 fresco
        Fresco.initialize(this);

        NetWorkManager.getInstance().init();
    }
}
