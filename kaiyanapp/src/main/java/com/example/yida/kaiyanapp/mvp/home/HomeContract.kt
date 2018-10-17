package com.example.yida.kaiyanapp.mvp.home

import com.example.yida.kaiyanapp.base.IBaseView
import com.example.yida.kaiyanapp.base.IPresenter
import com.example.yida.kaiyanapp.bean.HomeBean

/**
 * Created by yida on 2018/8/30.
 */
interface HomeContract {

    interface View: IBaseView {
        /**
         * 显示错误信息
         */
        fun showError(msg: String, code: Int)

        /**
         * 设置第一次请求的数据
         */
        fun setHomeBean(homeBean: HomeBean)

        /**
         * 设置加载更多的数据
         */
        fun setMoreData(itemList: ArrayList<HomeBean.Issue.Item>)
    }

    interface Presenter: IPresenter<View> {
        /**
         * 获取首页精选信息
         */
        fun requestHomeData(num: Int)

        /**
         * 加载更多数据
         */
        fun loadMoreData()
    }
}