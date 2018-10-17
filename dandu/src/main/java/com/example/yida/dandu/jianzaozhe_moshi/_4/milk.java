package com.example.yida.dandu.jianzaozhe_moshi._4;

import com.example.yida.dandu.jianzaozhe_moshi._3.ColdDrink;

/**
 * Created by yida on 2018/8/9.
 */
//创建牛奶实体类
public class milk extends ColdDrink {
    @Override
    public String name() {
        return "牛奶";
    }

    @Override
    public float price() {
        return 60.5f;
    }
}
