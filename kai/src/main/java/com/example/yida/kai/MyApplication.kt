package com.example.yida.kai

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import com.example.yida.kai.utils.DisplayManager
import com.squareup.leakcanary.RefWatcher
import kotlin.properties.Delegates

/**
 * Created by yida on 2018/8/29.
 */
class MyApplication: Application() {

    private var refWatcher: RefWatcher? = null

    companion object {
        private val TAG = "MyApplication"

        var context: Context by Delegates.notNull()
        private set

        fun getRefWatcher(context: Context): com.squareup.leakcanary.RefWatcher? {
            val myApplication = context.applicationContext as MyApplication
            return myApplication.refWatcher
        }
    }

    init {
        context = applicationContext
    }

    override fun onCreate() {
        super.onCreate()
//        context = applicationContext

        initConfig()
        DisplayManager.init(this)
        registerActivityLifecycleCallbacks(mActivityLifecycleCallbacks)
    }

    /**
     * 初始化配置
     */
    private fun initConfig() {
        val formatStrategy = com.orhanobut.logger.PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)      // 隐藏线程信息, 默认:显示
                .methodCount(0)             // 决定打印多少行(每一行代表一个方法, 默认:2)
                .methodOffset(7)            // (Optional) Hides internal method calls up to offset. Default 5 (可选)隐藏内部方法来调用抵消,默认5
                .tag("kaiyan")              // 标签高亮
                .build()

        com.orhanobut.logger.Logger.addLogAdapter(object : com.orhanobut.logger.AndroidLogAdapter(formatStrategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
    }



    private val mActivityLifecycleCallbacks = object : ActivityLifecycleCallbacks {
        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            Log.d(TAG, "onCreated: " + activity.componentName.className)
        }

        override fun onActivityStarted(activity: Activity) {
            Log.d(TAG, "onStart: " + activity.componentName.className)
        }

        override fun onActivityResumed(activity: Activity) {

        }

        override fun onActivityPaused(activity: Activity) {

        }

        override fun onActivityStopped(activity: Activity) {

        }

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

        }

        override fun onActivityDestroyed(activity: Activity) {
            Log.d(TAG, "onDestroy: " + activity.componentName.className)
        }
    }

}