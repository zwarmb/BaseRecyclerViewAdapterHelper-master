package com.example.yida.demo3.ui.main;

import com.example.yida.demo3.NetWorkManager;
import com.example.yida.demo3.bean.BaseResponseBean;
import com.example.yida.demo3.bean.RestBean;

import io.reactivex.Observable;

/**
 * Created by yida on 2018/10/24.
 */
public class MainModel {

    public Observable<BaseResponseBean<RestBean>> getList() {
        return NetWorkManager.getRequest().getRest();
    }

}
