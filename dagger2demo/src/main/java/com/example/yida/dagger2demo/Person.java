package com.example.yida.dagger2demo;

import android.content.Context;
import android.util.Log;

/**
 * Created by yida on 2018/7/31.
 */

public class Person {

    private String trg = "Person";


    private Context mContext;

    public Person() {
        LogUtils("这是一个person实例");
    }

    public Person(Context context) {
        mContext = context;
        LogUtils("携带一个参数的额person实例");
    }

    public void LogUtils(String s) {

        Log.e(trg, s);

    }
}
