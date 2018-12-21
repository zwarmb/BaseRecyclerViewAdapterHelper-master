package com.example.yida.wanandroid.utils

import android.app.ActivityManager
import android.content.Context
import android.content.pm.PackageManager
import java.security.MessageDigest

/**
 * Created by yida on 2018/11/15.
 */
class AppUtils private constructor() {
    init {
        throw Error("Do not need instantiate")
    }

    companion object {
        private val DEBUG = true
        private val TAG = "AppUtils"

        /**
         * 得到软件的版本号
         */
        fun getVerCode(context: Context): Int {
            var verCode = -1
            try {
                val packageName = context.packageName
                verCode = context.packageManager.getPackageInfo(packageName, 0).versionCode
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }
            return verCode
        }

        /**
         * 获取应用运行的最大内存
         */
        val maxMemory: Long
            get() = Runtime.getRuntime().maxMemory() / 1024


        /**
         * 得到软件显示的版本信息
         */
        fun getVerName(context: Context): String {
            var  verName = ""
            try {
                val packageName = context.packageName
                verName = context.packageManager.getPackageInfo(packageName, 0).versionName
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }
            return verName
        }

        /**
         * 获取应用签名
         */
        fun getSign(context: Context, pkgName: String): String? {
            return try {
                val pis = context.packageManager.getPackageInfo(pkgName, PackageManager.GET_SIGNATURES)
                hexDigest(pis.signatures[0].toByteArray())
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
                null
            }

        }

        /**
         * 将签名字符串转换成需要的32位签名
         */
        private fun hexDigest(paramArrayOfByte: ByteArray): String {
            val hexDigits = charArrayOf(48.toChar(), 49.toChar(), 50.toChar(), 51.toChar(), 52.toChar(), 53.toChar(), 54.toChar(), 55.toChar(), 56.toChar(), 57.toChar(), 97.toChar(), 98.toChar(), 99.toChar(), 100.toChar(), 101.toChar(), 102.toChar())
            try {
                val localMessageDigest = MessageDigest.getInstance("MD5")
                localMessageDigest.update(paramArrayOfByte)
                val arrayOfByte = localMessageDigest.digest()
                val arrayOfChar = CharArray(32)
                var i = 0
                var j = 0
                while (true) {
                    if (i >= 16) {
                        return String(arrayOfChar)
                    }
                    val k = arrayOfByte[i].toInt()
                    arrayOfChar[j] = hexDigits[0xF and k.ushr(4)]
                    arrayOfChar[++j] = hexDigits[k and 0xF]
                    i++
                    j++
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return ""
        }

        /**
         * 获取设备的可用内存大小
         */
        fun getDeviceUsableMemory(context: Context): Int {
            val am = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            val mi = ActivityManager.MemoryInfo()
            am.getMemoryInfo(mi)
            // 返回当前系统的可用内存
            return (mi.availMem / (1024 * 1024)).toInt()
        }

        /**
         * 获取手机系统的SDK版本
         */
        val sdkVersion: Int
        get() = android.os.Build.VERSION.SDK_INT
    }
}