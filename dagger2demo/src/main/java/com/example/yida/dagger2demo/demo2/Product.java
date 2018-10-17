package com.example.yida.dagger2demo.demo2;

import com.blankj.utilcode.util.LogUtils;

import javax.inject.Inject;

/**
 * Created by yida on 2018/7/31.
 */

public class Product {

    @Inject
    public Product() {
        LogUtils.e("实例化");



    }


}
