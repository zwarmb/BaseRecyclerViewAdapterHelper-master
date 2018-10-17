package com.example.yida.dandu.jianzaozhe_moshi._5;

import android.util.Log;

import com.example.yida.dandu.jianzaozhe_moshi._1.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yida on 2018/8/9.
 */

public class Meal {

    private List<Item> mItems = new ArrayList<>();

    public void addItem(Item item) {
        mItems.add(item);

    }

    // 获取套餐价格
    public float getCost() {
        float cost = 0.0f;
        for (Item item : mItems) {
            cost += item.price();
        }
        return cost;
    }

    // 打印信息
    public void showItemMsg() {
        for (Item item : mItems) {
            Log.e("meal", "名    " + item.name() + "饮料    " + item.packing() + "价    " + item.price());
        }
    }

}
