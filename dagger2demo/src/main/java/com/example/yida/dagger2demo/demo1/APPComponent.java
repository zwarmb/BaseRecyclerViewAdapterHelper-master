package com.example.yida.dagger2demo.demo1;

import android.content.Context;

import dagger.Component;

/**
 * Created by yida on 2018/7/31.
 */
@Component(modules = APPModule.class)
public interface APPComponent {

    // 向下层提供context
    Context getContext();

}
