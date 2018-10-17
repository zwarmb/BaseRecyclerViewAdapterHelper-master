package com.example.bilibilidemo1.di;

import com.example.bilibilidemo1.base.BasePresenter;
import com.example.bilibilidemo1.base.BaseView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by yida on 2018/2/7.
 */

public class RxPresenter<T extends BaseView> implements BasePresenter<T> {
    protected CompositeDisposable mCompositeDisposable;
    protected T mView;

    protected void unSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }

    protected void addSubscribe(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }


    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
