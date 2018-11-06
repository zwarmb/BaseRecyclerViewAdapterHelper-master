package com.example.yida.demo3.net;

import com.example.yida.demo3.bean.BaseResponseBean;
import com.example.yida.demo3.bean.RestBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by yida on 2018/10/23.
 */
public interface RequestApi {

    // 天上需要访问的服务器地址
    public static String HOST = " http://co-api.51wnl.com/calendar/";

    // 获取调休假
    @GET("vacations?token=A2E0C3CDEA081D3BFC34F8FE23A15886&type=1×tamp=1462377600&client=ceshi")
    Observable<BaseResponseBean<RestBean>> getRest();



}
