package com.example.yida.kaiyanapp.mvp.home

import com.example.yida.kaiyanapp.bean.HomeBean
import com.example.yida.kaiyanapp.net.RetrofitManager
import com.example.yida.kaiyanapp.rx.SchedulerUtils
import io.reactivex.Observable

/**
 * Created by yida on 2018/8/30.
 */
class HomeModel{

    /**
     * 获取首页 Banner 数据
     */
    fun requestHomeData(num:Int): Observable<HomeBean> {
        return RetrofitManager.service.getFirstHomeData(num)
                .compose(SchedulerUtils.ioToMain())
    }

    /**
     * 加载更多
     */
    fun loadMoreData(url:String): Observable<HomeBean> {

        return RetrofitManager.service.getMoreHomeData(url)
                .compose(SchedulerUtils.ioToMain())
    }



}