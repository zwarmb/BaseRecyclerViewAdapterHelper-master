package com.example.yida.wanandroid.http

import com.example.yida.wanandroid.BuildConfig
import com.example.yida.wanandroid.context.App
import com.example.yida.wanandroid.context.Constant
import com.example.yida.wanandroid.utils.NetWorkUtils
import com.example.yida.wanandroid.utils.Preference
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File

/**
 * Created by yida on 2018/11/27.
 */
object RetrofitHelper {

    private var retrofit: Retrofit? = null
//    val service: ApiService by lazy {  }


    private var token: String by Preference("token", "")

    private fun getRetrofit(): Retrofit? {
        if (retrofit == null) {
            synchronized(RetrofitHelper::class.java) {
                if (retrofit == null) {
                    retrofit = Retrofit.Builder()
                            .baseUrl(Constant.BASE_URL)
                            .client(getOkHttpClient())
                            .addConverterFactory(MoshiConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build()
                }
            }
        }
        return retrofit
    }


    private fun getOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient().newBuilder()
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }

        val cacheFile = File(App.context.cacheDir, "cache")
        val cache = Cache(cacheFile, 1024 * 1024 * 50) // 50M缓存大小

        builder.run {
            addInterceptor(httpLoggingInterceptor)
            addInterceptor(addHttpInterceptor())
            addInterceptor(addCacheInterceptor())
            addInterceptor({
                val request = it.request()
                val response = it.proceed(request)
                val requestUrl = request.url().toString()
                val domain = request.url().host()
                if ((requestUrl.contains(HttpConstant.SAVE_USER_LOGIN_KEY)
                                || requestUrl.contains(HttpConstant.SAVE_USER_REGISTER_KEY))
                        && !response.headers(HttpConstant.SET_COOKIE_KEY).isEmpty()) {
                    val cookies = response.headers(HttpConstant.SET_COOKIE_KEY)
                    val cookie = HttpConstant.encodeCookie(cookies)
                    saveCookie(requestUrl, domain, cookie)
                }
            })

        }
    }


    /**
     * add header
     */
    private fun addHttpInterceptor(): Interceptor {
        return Interceptor { chain ->
            val builder = chain.request().newBuilder()
            val request = builder.addHeader("Content-type", "application/json; charset=utf-8").build()
            chain.proceed(request)
        }
    }

    /**
     * 设置公共参数
     */
    private fun addQueryParameterInterceptor(): Interceptor {
        return Interceptor { chain ->
            val originalRequest = chain.request()
            val request: Request
            val modifiedUrl = originalRequest.url().newBuilder()
                    .addQueryParameter("phoneSystem", "")
                    .addQueryParameter("phoneModel", "")
                    .build()
            request = originalRequest.newBuilder().url(modifiedUrl).build()
            chain.proceed(request)
        }
    }

    /**
     * 设置头
     */
    private fun addHeaderInterceptor(): Interceptor {
        return Interceptor { chain ->
            val originalRequest = chain.request()
            val requestBuilder = originalRequest.newBuilder()
                    .header("token", token)
                    .method(originalRequest.method(), originalRequest.body())
            val request = requestBuilder.build()
            chain.proceed(request)
        }
    }

    /**
     * 设置缓存
     */
    private fun addCacheInterceptor(): Interceptor {
        return Interceptor {
            chain ->
            var request = chain.request()
            if (!NetWorkUtils.isNetworkAvailable(App.context)) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build()
            }
            val response = chain.proceed(request)
            if (NetWorkUtils.isNetworkAvailable(App.context)) {
                val maxAge = 0
                // 有网络时, 设置缓存超时时长 0 个小时, 意思就是不读取缓存数据, 只对get有用, post没有缓冲
                response.newBuilder()
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .removeHeader("Retrofit") // 清除头信息, 因为服务区如果不支持, 会返回一些干扰信息, 不清除下面无法生效
                        .build()
            } else {
                // 无网络时, 设置超时为4周  只对get有用, post没有缓冲
                val maxStale = 60 * 60 * 24 * 28
                response.newBuilder()
                        .header("Cache-Contral", "public, only-if-cached, max-stale=" + maxStale)
                        .removeHeader("nyn")
                        .build()
            }
            response
        }
    }

    private fun saveCookie(url: String?, domain: String?, cookies: String) {
        url ?: return
        var spUrl: String by Preference(url, cookies)
        @Suppress("UNUSED_VALUE")
        spUrl = cookies
        domain?: return
        var spDomain: String by Preference(domain, cookies)
        @Suppress("UNUSED_VALUE")
        spDomain = cookies
    }
}