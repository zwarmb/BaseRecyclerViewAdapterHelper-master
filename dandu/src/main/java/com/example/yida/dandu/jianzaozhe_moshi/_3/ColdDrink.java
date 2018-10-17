package com.example.yida.dandu.jianzaozhe_moshi._3;

import com.example.yida.dandu.jianzaozhe_moshi._1.Item;
import com.example.yida.dandu.jianzaozhe_moshi._1.Packing;
import com.example.yida.dandu.jianzaozhe_moshi._2.Bottle;

/**
 * Created by yida on 2018/8/9.
 */

// 创建实现item接口的抽象类, 提供默认数据
public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();

}
