package com.example.yida.wanandroid.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.yida.wanandroid.context.Constant
import com.example.yida.wanandroid.event.NetworkChangeEvent
import com.example.yida.wanandroid.utils.NetWorkUtils
import com.example.yida.wanandroid.utils.Preference
import org.greenrobot.eventbus.EventBus

/**
 * Created by yida on 2018/10/26.
 */
class NetworkChangeReceiver : BroadcastReceiver() {

    /**
     * 缓存上一次的网络状态
     */
    private var hasNetwork: Boolean by Preference(Constant.HAS_NETWORK_KEY, true)

    override fun onReceive(context: Context, intent: Intent) {
        val isConnected = NetWorkUtils.isNetworkConnected(context)
        if (isConnected) {
            if (isConnected != hasNetwork) {
                EventBus.getDefault().post(NetworkChangeEvent(isConnected))
            }
        } else {
            EventBus.getDefault().post(NetworkChangeEvent(isConnected))
        }
    }
}