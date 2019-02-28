package com.example.demo1.view.zidinyi_view_dianxianmian;

import android.support.annotation.NonNull;

/**
 * Created by yida on 2018/12/25.
 */
public class PieData {
    // 用户关心的数据
    String name;            // 名字
    float value;            // 数值
    float percentage;       // 百分比

    // 非用户关心数据
    int color = 0;          // 颜色
    float andle = 0;        // 角度


    public PieData(@NonNull String name, @NonNull float value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getAndle() {
        return andle;
    }

    public void setAndle(float andle) {
        this.andle = andle;
    }
}
