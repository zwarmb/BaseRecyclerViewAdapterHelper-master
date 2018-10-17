package com.example.yida.kaiyanapp.base

/**
 * Created by yida on 2018/8/30.
 */
interface IPresenter<in V: IBaseView> {

    fun attachView(mRootView: V)

    fun detachView()

}