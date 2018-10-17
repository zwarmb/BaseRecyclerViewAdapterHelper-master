package com.example.yida.dagger2demo;

import android.util.Log;

/**
 * Created by yida on 2018/7/31.
 */

public class LogUtils {

    String mString;

    public LogUtils() {
    }

    public LogUtils(String s) {
        mString = s;
        Log.e("tag", s);
    }

}
