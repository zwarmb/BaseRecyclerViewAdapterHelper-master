package com.example.yida.demo3.scheduler;

import com.example.yida.demo3.bean.BaseResponseBean;

import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by yida on 2018/10/25.
 */
public class CommonSubscriber<T> extends ResourceSubscriber<BaseResponseBean<T>> {


    @Override
    public void onNext(BaseResponseBean<T> tBaseResponseBean) {

    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {

    }
}
