package com.example.yida.demo3.exception;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;

/**
 * Created by yida on 2018/10/24.
 */
public class CustomException {

    /**
     * 未知错误
     */
    public static final int UNKNOWN = 1000;

    /**
     * 解析错误
     */
    public static final int PARSE_ERROR = 1001;

    /**
     * 网络错误
     */
    public static final int NETWORK_ERROR = 1002;

    /**
     * 协议错误
     */
    public static final int HTTP_ERROR = 1003;

    public static ApiException handleException(Throwable e) {
        ApiException apiException;
        if (e instanceof JsonParseException || e instanceof JSONException || e instanceof ParseException) {
            apiException = new ApiException(PARSE_ERROR, e.getMessage());
            return apiException;
        } else if (e instanceof ConnectException) {
            apiException = new ApiException(NETWORK_ERROR, e.getMessage());
            return apiException;
        } else if (e instanceof UnknownHostException || e instanceof SocketTimeoutException) {
            apiException = new ApiException(NETWORK_ERROR, e.getMessage());
            return apiException;
        } else {
            apiException = new ApiException(UNKNOWN, e.getMessage());
            return apiException;
        }
    }

}
