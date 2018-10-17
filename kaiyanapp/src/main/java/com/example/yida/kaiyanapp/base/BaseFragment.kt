package com.example.yida.kaiyanapp.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yida.kaiyanapp.MyApplication
import com.example.yida.kaiyanapp.view.MultipleStatusView

/**
 * Created by yida on 2018/8/30.
 */
abstract class BaseFragment: Fragment() {

    /**
     * 视图是否加载完毕
     */
    private var isViewPrepars = false

    /**
     * 数据是否加载过了
     */
    private var HasLoadData = false

    /**
     * 多种状态的 view 的切换
     */
    protected var mLayoutStatusView: MultipleStatusView? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(getLayoutId(), null)
//        return inflater.inflate(getLayoutId(),null)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            lazyLoadDataIfPrepared()
        }
    }

    private fun lazyLoadDataIfPrepared() {
        if (userVisibleHint && isViewPrepars && !HasLoadData) {
            lazyLoad()
            HasLoadData = true
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isViewPrepars = true
        initView()
        lazyLoadDataIfPrepared()
        // 多种状态切换的view 重试点击事件
        mLayoutStatusView?.setOnRetryClickListener(mRetryClickListener)
    }

    open val mRetryClickListener: View.OnClickListener = View.OnClickListener {
        lazyLoad()
    }

    /**
     * 加载布局
     */
    @LayoutRes
    abstract fun getLayoutId():Int

    /**
     * 初始化 ViewI
     */
    abstract fun initView()

    /**
     * 懒加载
     */
    abstract fun lazyLoad()

    override fun onDestroy() {
        super.onDestroy()
        activity?.let { MyApplication.getRefWatcher(it)?.watch(activity) }
    }
}