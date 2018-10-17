package com.example.yida.wanandroid.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.yida.wanandroid.context.App

/**
 * Created by yida on 2018/10/8.
 */
class Preference<T>(val name: String, private val default: T) {

    companion object {
        private val file_name = "wan_android_file"

        private val prefs: SharedPreferences by lazy {
            App.context.getSharedPreferences(file_name, Context.MODE_PRIVATE)
        }
    }


    fun clearPreFerence() {
        prefs.edit().clear().apply()
    }

    fun clearPreference(key: String) {
        prefs.edit().remove(key).apply()
    }

    fun contains(key: String): Boolean {
        return prefs.contains(key)
    }
}