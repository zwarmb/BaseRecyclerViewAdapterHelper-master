package com.example.yida.kaiyanapp.mvp.home

import android.os.Bundle
import com.example.yida.kaiyanapp.R
import com.example.yida.kaiyanapp.base.BaseFragment
import com.example.yida.kaiyanapp.bean.HomeBean

/**
 * Created by yida on 2018/8/30.
 */
class HomeFragment: BaseFragment(), HomeContract.View {


    override fun setHomeBean(homeBean: HomeBean) {
    }

    override fun setMoreData(itemList: ArrayList<HomeBean.Issue.Item>) {
    }

    private val mPresenter by lazy {  }

    private var mTitle: String? = null


    companion object {
        fun getInstance(title: String): HomeFragment {
            val fragment = HomeFragment()       // 不要少了括号, 就不是指向方法了
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title

            return fragment
        }
    }

    override fun showLoading() {
    }

    override fun dismissLoading() {
    }

    override fun showError(msg: String, code: Int) {
    }

    override fun getLayoutId(): Int = R.layout.fragemnt_home

    override fun initView() {
    }

    override fun lazyLoad() {
    }
}