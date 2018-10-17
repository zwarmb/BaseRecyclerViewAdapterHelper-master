package com.example.bilibilidemo1.base;

/**
 * Created by yida on 2018/2/6.
 */

public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void detachView();
    void subscribe();
    void unsubscribe();
}
