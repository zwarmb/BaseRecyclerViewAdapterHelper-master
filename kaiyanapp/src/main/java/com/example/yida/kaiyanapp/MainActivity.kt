package com.example.yida.kaiyanapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.view.KeyEvent
import com.example.yida.kaiyanapp.base.BaseActivity
import com.example.yida.kaiyanapp.bean.TabEntity
import com.example.yida.kaiyanapp.mvp.discovery.DiscoveryFragment
import com.example.yida.kaiyanapp.mvp.home.HomeFragment
import com.example.yida.kaiyanapp.mvp.hot.HotFragment
import com.example.yida.kaiyanapp.mvp.mine.MineFragment
import com.example.yida.kaiyanapp.utils.showToast
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val mTitles = arrayOf("每日精选", "发现", "热门", "我的")

    // 未被选中的图标
    private val mIconUnSelectIds = intArrayOf(R.mipmap.ic_home_normal, R.mipmap.ic_discovery_normal, R.mipmap.ic_hot_normal, R.mipmap.ic_mine_normal)
    // 被选中的图标
    private val mIconSelectIds = intArrayOf(R.mipmap.ic_home_selected, R.mipmap.ic_discovery_selected, R.mipmap.ic_hot_selected, R.mipmap.ic_mine_selected)

    private val mTabEntities = ArrayList<CustomTabEntity>()

    private var mHomeFragment: HomeFragment? = null
    private var mDiscoveryFragment: DiscoveryFragment? = null
    private var mHotFragment: HotFragment? = null
    private var mMineFragment: MineFragment? = null

    // 默认为0
    private var mIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            mIndex = savedInstanceState.getInt("currTabIndex")
        }
        super.onCreate(savedInstanceState)
        initTab()
        tab_layout.currentTab = mIndex
        switchFragment(mIndex)
    }

    /**
     * 切换Fragment
     */
    private fun switchFragment(position: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        hideFragment(transaction)
        when (position) {
            0 -> mHomeFragment?.let {
                transaction.show(it)
            } ?: HomeFragment.getInstance(mTitles[position]).let {
                mHomeFragment = it
                transaction.add(R.id.fl_container, it, "home")
            }
            1 -> mDiscoveryFragment?.let {
                transaction.show(it)
            } ?: DiscoveryFragment.getInstance(mTitles[position]).let {
                mDiscoveryFragment = it
                transaction.add(R.id.fl_container, it, "discovery")
            }
            2 -> mHotFragment?.let {
                transaction.show(it)
            } ?: HotFragment.getInstance(mTitles[position]).let {
                mHotFragment = it
                transaction.add(R.id.fl_container, it, "hot")
            }
            3 -> mMineFragment?.let {
                transaction.show(it)
            } ?: MineFragment.getInstance(mTitles[position]).let {
                mMineFragment = it
                transaction.add(R.id.fl_container, it, "mine")
            }

            else -> {}
        }

        mIndex = position
        tab_layout.currentTab = mIndex
        transaction.commitAllowingStateLoss()
    }


    /**
     * 隐藏所有的Fragment
     */
    private fun hideFragment(transaction: FragmentTransaction?) {
        if (transaction != null) {
            mHomeFragment?.let { transaction.hide(it) }
            mDiscoveryFragment?.let { transaction.hide(it) }
            mHotFragment?.let { transaction.hide(it) }
            mMineFragment?.let { transaction.hide(it) }
        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onSaveInstanceState(outState: Bundle?) {
//        super.onSaveInstanceState(outState)

        // 记录Fragment的位置, 防止崩溃 Activity被系统回收时, Fragment错乱
        if (tab_layout != null) {
            outState!!.putInt("currTabIndex", mIndex)
        }
    }

    private fun initTab() {
        (0 until mTitles.size).mapTo(mTabEntities) {TabEntity(mTitles[it], mIconSelectIds[it], mIconUnSelectIds[it])}

        tab_layout.setTabData(mTabEntities)
        tab_layout.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                // 切换Fragment
                switchFragment(position)
            }

            override fun onTabReselect(position: Int) {
            }
        })

    }


    override fun initView() {
    }

    override fun initData() {
    }

    override fun layoutId(): Int = R.layout.activity_main

    override fun start() {
    }

    private var mExitTime: Long = 0

    /**
     * 重写返回键
     */
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis().minus(mExitTime) <= 2000) {
                finish()
            } else {
                mExitTime = System.currentTimeMillis()
                showToast("再按一次退出程序")
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
