package com.example.yida.demo3;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yida on 2018/10/23.
 */
public class NetWorkManager {

    private static NetWorkManager mInstance;
    private static Retrofit sRetrofit;
    private static volatile Request sRequest = null;

    public static NetWorkManager getInstance() {
        if (mInstance == null) {
            synchronized (NetWorkManager.class) {
                if (mInstance == null) {
                    mInstance = new NetWorkManager();
                }
            }
        }
        return mInstance;
    }


    public void init() {

        OkHttpClient client = new OkHttpClient.Builder().build();

        sRetrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(com.example.yida.demo3.net.Request.HOST)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static Request getRequest() {
        if (sRequest == null) {
            synchronized (Request.class) {
                sRequest = sRetrofit.create(Request.class);
            }
        }
        return sRequest;
    }

}
