package com.example.bilibilidemo1.utils;

/**
 * Created by yida on 2018/2/5.
 */

public class FragmentResultEvent {

    public final int requestCode;
    public final int resultCode;


    public FragmentResultEvent(int requestCode, int resultCode) {
        this.requestCode = requestCode;
        this.resultCode = resultCode;
    }
}
