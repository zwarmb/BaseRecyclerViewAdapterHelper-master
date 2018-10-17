package com.example.yida.kaiyanapp.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.example.yida.kaiyanapp.view.MultipleStatusView

/**
 * Created by yida on 2018/8/29.
 */

abstract class BaseActivity: AppCompatActivity() {


    protected var mLayoutStatusView: MultipleStatusView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layoutId())
        initData()
        initView()
        start()
        initListener()
    }


    private fun initListener() {
        mLayoutStatusView?.setOnClickListener(mRetryClickListener)
    }

    open val mRetryClickListener: View.OnClickListener = View.OnClickListener {
        start()
    }

    /**
     * 初始化view
     */
    abstract fun initView()

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 抽象方法, 子类实现
     * 加载布局
     */
    abstract fun layoutId(): Int

    /**
     * 开始请求
     */
    abstract fun start()

    /**
     * 打开软键盘
     */
    fun openKeyBord(mEditText: EditText, mContent: Context) {
        val imm = mContent.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN)
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
    }

    fun closeKeyBord(mEditText: EditText, mContent: Context) {
        val imm = mContent.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(mEditText.windowToken, 0)
    }

    override fun onDestroy() {
        super.onDestroy()

    }
}
