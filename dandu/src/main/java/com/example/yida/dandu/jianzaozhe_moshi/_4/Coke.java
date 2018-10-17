package com.example.yida.dandu.jianzaozhe_moshi._4;

import com.example.yida.dandu.jianzaozhe_moshi._3.ColdDrink;

/**
 * Created by yida on 2018/8/9.
 */
//创建可乐实体类
public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "可乐";
    }

    @Override
    public float price() {
        return 6.5f;
    }
}
