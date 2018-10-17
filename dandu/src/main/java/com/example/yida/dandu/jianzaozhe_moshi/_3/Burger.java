package com.example.yida.dandu.jianzaozhe_moshi._3;

import com.example.yida.dandu.jianzaozhe_moshi._1.Item;
import com.example.yida.dandu.jianzaozhe_moshi._1.Packing;
import com.example.yida.dandu.jianzaozhe_moshi._2.Wrapper;

/**
 * Created by yida on 2018/8/9.
 */

// 创建实现item接口的抽象类, 提供默认数据
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();

}
