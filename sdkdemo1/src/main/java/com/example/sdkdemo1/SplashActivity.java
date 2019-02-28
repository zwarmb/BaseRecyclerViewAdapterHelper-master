package com.example.sdkdemo1;

import android.content.Intent;

import com.moge.sdk.leyou.MogeSplashActivity;

/**
 * Created by yida on 2018/12/29.
 */
public class SplashActivity extends MogeSplashActivity {
    @Override
    public void onFinish() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
