package com.example.yida.kaiyanapp.mvp.home

import com.example.yida.kaiyanapp.base.BasePresenter
import com.example.yida.kaiyanapp.bean.HomeBean
import com.example.yida.kaiyanapp.net.RetrofitManager
import com.example.yida.kaiyanapp.net.exception.ExceptionHandle
import com.example.yida.kaiyanapp.rx.SchedulerUtils

/**
 * Created by yida on 2018/8/30.
 */
class HomePresenter : BasePresenter<HomeContract.View>(), HomeContract.Presenter {

    private var bannerHomeBeans: HomeBean? = null

    private var nextPageUrl: String? = null     //加载首页的banner, 数据+一页数据合并后, nextPageUrl 没 add

    override fun requestHomeData(num: Int) {

        checkViewAttached()
        mRootView?.showLoading()
        val disposable = RetrofitManager.service.getFirstHomeData(num)
                .compose(SchedulerUtils.ioToMain())
                .flatMap({ homeBean ->

                    //过滤掉 Banner2(包含广告,等不需要的 Type), 具体查看接口分析
                    val bannerItemList = homeBean.issueList[0].itemList

                    bannerItemList.filter { item ->
                        item.type == "banner2" || item.type == "horizontalScrollCard"
                    }.forEach { item ->
                        //移除 item
                        bannerItemList.remove(item)
                    }

                    bannerHomeBeans = homeBean //记录第一页是当做 banner 数据


                    //根据 nextPageUrl 请求下一页数据
//                    homeModel.loadMoreData(homeBean.nextPageUrl)
                    RetrofitManager.service.getMoreHomeData(homeBean.nextPageUrl)
                            .compose(SchedulerUtils.ioToMain())
                })
                .subscribe({ homeBean ->
                    mRootView?.apply {
                        dismissLoading()

                        nextPageUrl = homeBean.nextPageUrl
                        // 过滤掉 Banner2( 包含广告, 等不需要的 type ), 具体查看接口分析
                        val newBannerItemLise = homeBean.issueList[0].itemList

                        newBannerItemLise.filter { item ->
                            item.type == "banner2" || item.type == "horizontalScrollCard"
                        }.forEach { t: HomeBean.Issue.Item? ->
                            // 移除item
                            newBannerItemLise.remove(t)
                        }
                        // 重新赋值Banner 的长度
                        bannerHomeBeans!!.issueList[0].itemList.addAll(newBannerItemLise)
                        setHomeBean(bannerHomeBeans!!)
                    }

                }, { t ->
                    mRootView?.apply {
                        dismissLoading()
                        showError(ExceptionHandle.handleException(t), ExceptionHandle.errorCode)
                    }
                })
        addSubscripttion(disposable)
    }

    /**
     * 加载更多
     */
    override fun loadMoreData() {
        val disposable = nextPageUrl?.let {
            RetrofitManager.service.getMoreHomeData(it)
                    .compose(SchedulerUtils.ioToMain())
                    .subscribe({ t ->
                        mRootView?.apply {
                            // 过滤掉 Banner2(包含广告, 等不需要的 type), 具体查看接口分析
                            val newItemList = t.issueList[0].itemList

                            newItemList.filter { item ->
                                item.type == "banner2" || item.type == "horizontalScrollCard"
                            }.forEach { t: HomeBean.Issue.Item? ->
                                // 移除item
                                newItemList.remove(t)
                            }

                            nextPageUrl = t.nextPageUrl
                            setMoreData(newItemList)
                        }
                    }, { t ->
                        mRootView?.apply {
                            showError(ExceptionHandle.handleException(t), ExceptionHandle.errorCode)
                        }
                    })
        }

        if (disposable != null) {
            addSubscripttion(disposable)
        }
    }
}