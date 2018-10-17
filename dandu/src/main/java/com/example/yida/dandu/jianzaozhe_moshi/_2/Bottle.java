package com.example.yida.dandu.jianzaozhe_moshi._2;

import com.example.yida.dandu.jianzaozhe_moshi._1.Packing;

/**
 * Created by yida on 2018/8/9.
 */

// 纸盒包装实现包装类型
public class Bottle implements Packing {

    @Override
    public String pack() {
        return "塑料瓶包装";
    }
}
