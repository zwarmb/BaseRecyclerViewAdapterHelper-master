package com.example.yida.dandu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.yida.dandu.jianzaozhe_moshi._5.Meal;
import com.example.yida.dandu.jianzaozhe_moshi._6.MealBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MealBuilder mealBuilder = new MealBuilder();
        Meal meal1 = mealBuilder.One();
        meal1.showItemMsg();
        Log.e("main", " 价  " + meal1.getCost());

        Meal meal2 = mealBuilder.Two();
        meal2.showItemMsg();
        Log.e("main", " 价  " + meal2.getCost());
    }
}
