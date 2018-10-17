package com.example.yida.kaiyanapp.bean

import com.flyco.tablayout.listener.CustomTabEntity

/**
 * Created by yida on 2018/8/31.
 */
class TabEntity(var title: String, private var selectedIcon: Int, private var unSelectedIcon: Int) : CustomTabEntity {
    override fun getTabUnselectedIcon(): Int {
        return unSelectedIcon
    }

    override fun getTabSelectedIcon(): Int {
        return selectedIcon
    }

    override fun getTabTitle(): String {
        return title
    }
}