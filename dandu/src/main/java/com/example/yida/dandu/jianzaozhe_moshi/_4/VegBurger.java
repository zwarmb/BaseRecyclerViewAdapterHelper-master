package com.example.yida.dandu.jianzaozhe_moshi._4;

import com.example.yida.dandu.jianzaozhe_moshi._3.Burger;

/**
 * Created by yida on 2018/8/9.
 */

// 创建扩展了汉堡的实体类
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "不知道什么堡";
    }

    @Override
    public float price() {
        return 16.6f;
    }
}
