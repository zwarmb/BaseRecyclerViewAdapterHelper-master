package com.example.yida.dagger2demo.demo3;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by yida on 2018/7/31.
 */
@Module
public class HttpActivityModule {

    private int cacheSize;

    public HttpActivityModule(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    @Provides
//    @Singleton
    OkHttpClient providesOkHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient();
//        okHttpClient.cache()
        return okHttpClient;

//        return new OkHttpClient(); // 实例化
    }

}
