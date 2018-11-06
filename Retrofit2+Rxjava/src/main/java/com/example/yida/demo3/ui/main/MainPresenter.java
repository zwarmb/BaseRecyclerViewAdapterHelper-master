package com.example.yida.demo3.ui.main;

import com.example.yida.demo3.scheduler.BaseSchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by yida on 2018/10/24.
 */
public class MainPresenter {

    private MainModel mModel;

    private MainContract.View mView;

    private BaseSchedulerProvider mBaseSchedulerProvider;

    private CompositeDisposable mCompositeDisposable;

    public MainPresenter(MainModel model, MainContract.View view, BaseSchedulerProvider baseSchedulerProvider) {
        mModel = model;
        mView = view;
        mBaseSchedulerProvider = baseSchedulerProvider;
    }

    public void despost() {
        mCompositeDisposable.dispose();
    }

    public void getList() {
        Disposable disposable = mModel.getList()
                .compose(mBaseSchedulerProvider.applySchedulers())
                .subscribeWith(new );
    }
}
