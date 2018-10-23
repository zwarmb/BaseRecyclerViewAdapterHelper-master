package com.example.yida.demo3.bean;

/**
 * Created by yida on 2018/10/23.
 */
public class BaseResponseBean<T> {

    private int status;  // 返回的code
    private T data;     // 返回的数据结果
    private String errMsg;  // 返回的数据说明

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
