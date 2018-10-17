package com.example.yida.kaiyanapp.mvp.mine

import android.os.Bundle
import com.example.yida.kaiyanapp.R
import com.example.yida.kaiyanapp.base.BaseFragment

/**
 * Created by yida on 2018/8/31.
 */
class MineFragment: BaseFragment() {
    private var mTitle: String? = null

    companion object {
        fun getInstance(title: String): MineFragment {
            val fragment = MineFragment()       // 不要少了括号, 就不是指向方法了
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title

            return fragment
        }
    }


    override fun getLayoutId(): Int = R.layout.fragment_mine

    override fun initView() {
    }

    override fun lazyLoad() {
    }
}