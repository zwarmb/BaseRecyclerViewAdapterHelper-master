package com.example.yida.qq.api.model;

/**
 * Created by yida on 2018/10/29.
 */
public interface SimpleCallback<T> {

    /**
     * 回调函数返回结果
     *
     * @param success 是否成功，结果是否有效
     * @param result  结果
     * @param code    失败时错误码
     */
    void onResult(boolean success, T result, int code);

}
