package com.example.fenzurecycledemo1.bean;

/**
 * Created by Administrator on 2018/1/12.
 */

public class UserBean {
    private String name;
    private String img;

    public UserBean(String name, String img) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
