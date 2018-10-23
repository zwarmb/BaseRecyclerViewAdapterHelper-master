package com.example.yida.demo3.bean;

/**
 * Created by yida on 2018/10/23.
 */
public class BaseRequestBean {

    private String token;
    private int type;
    private String client;

    public String getToken() {
        return token;
    }

    public BaseRequestBean setToken(String token) {
        this.token = token;
        return this;
    }

    public int getType() {
        return type;
    }

    public BaseRequestBean setType(int type) {
        this.type = type;
        return this;
    }

    public String getClient() {
        return client;
    }

    public BaseRequestBean setClient(String client) {
        this.client = client;
        return this;
    }
}
