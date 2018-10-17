package com.example.yida.kaiyanapp.rx

/**
 * Created by yida on 2018/8/30.
 */
object SchedulerUtils {

    fun <T> ioToMain(): IoMainScheduler<T> {
        return IoMainScheduler()
    }
}