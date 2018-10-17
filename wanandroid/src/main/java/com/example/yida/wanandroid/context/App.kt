package com.example.yida.wanandroid.context

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDexApplication
import com.example.yida.wanandroid.utils.CommonUtil
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.BuildConfig
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import com.tencent.bugly.Bugly
import com.tencent.bugly.crashreport.CrashReport
import kotlin.properties.Delegates

/**
 * Created by yida on 2018/10/8.
 */
class App : MultiDexApplication() {

    private var refWatcher: RefWatcher? = null


    companion object {
        private val TAG = "App"

        var context: Context by Delegates.notNull()
        private set

        lateinit var instance: Application

        fun getRefWatcher(context: Context): RefWatcher? {
            val app = context.applicationContext as App
            return app.refWatcher
        }
    }


    override fun onCreate() {
        super.onCreate()
        instance = this
        context = applicationContext
        refWatcher = setupLeakCanary()
        initConfig()
        initBugly()
    }

    /**
     * 初始化bugly
     */
    private fun initBugly() {
        // 获取当前包名
        val packageName = applicationContext.packageName
        // 获取当前进程名
        val processName = CommonUtil.getProcessName(android.os.Process.myPid())
        // 设置是否为上报进程
        val strategy = CrashReport.UserStrategy(applicationContext)
        strategy.isUploadProcess = false || processName == packageName
        Bugly.init(applicationContext, Constant.BUGLY_ID, BuildConfig.DEBUG, strategy)

    }

    /**
     * 初始化配置
     */
    private fun initConfig() {
        val formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // 隐藏线程信息 默认: 显示
                .methodCount(0)         // 决定打印多少行( 每一行代表一个方法 ) 默认 : 2
                .methodOffset(7)        //  (Optional) Hides internal method calls up to offset. Default 5    ( 可选 )隐藏内部方法调用来抵消  默认: 5
                .tag("yida")
                .build()
        Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })

    }

    private fun setupLeakCanary(): RefWatcher {
        return if (LeakCanary.isInAnalyzerProcess(this)) {
            RefWatcher.DISABLED
        } else LeakCanary.install(this)
    }

}