package com.example.yida.demo3;

import com.example.yida.demo3.net.RequestApi;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yida on 2018/10/23.
 */
public class NetWorkManager {

    private static NetWorkManager mInstance;
    private static Retrofit sRetrofit;
    private static volatile RequestApi sRequest = null;

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
                .baseUrl(RequestApi.HOST)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static RequestApi getRequest() {
        if (sRequest == null) {
            synchronized (RequestApi.class) {
                sRequest = sRetrofit.create(RequestApi.class);
            }
        }
        return sRequest;
    }

}
