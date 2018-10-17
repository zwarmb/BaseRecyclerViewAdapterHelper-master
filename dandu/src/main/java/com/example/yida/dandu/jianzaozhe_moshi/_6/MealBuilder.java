package com.example.yida.dandu.jianzaozhe_moshi._6;

import com.example.yida.dandu.jianzaozhe_moshi._4.ChickenBurger;
import com.example.yida.dandu.jianzaozhe_moshi._4.Coke;
import com.example.yida.dandu.jianzaozhe_moshi._4.VegBurger;
import com.example.yida.dandu.jianzaozhe_moshi._4.milk;
import com.example.yida.dandu.jianzaozhe_moshi._5.Meal;

/**
 * Created by yida on 2018/8/9.
 */

public class MealBuilder {

    // 套餐一
    public Meal One() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }


    // 套餐二
    public Meal Two() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new milk());
        return meal;
    }

}
