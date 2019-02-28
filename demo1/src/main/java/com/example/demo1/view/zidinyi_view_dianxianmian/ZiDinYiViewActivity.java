package com.example.demo1.view.zidinyi_view_dianxianmian;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.demo1.R;

import java.util.ArrayList;

/**
 * Created by yida on 2018/12/24.
 */
public class ZiDinYiViewActivity extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_zidinyi);


        BingZhuangTu tu = findViewById(R.id.bingzhuangtu);
        ArrayList<PieData> list = new ArrayList<>();
        PieData pieData = new PieData("111", 60);
        PieData pieData1 = new PieData("222", 50);
        PieData pieData2 = new PieData("333", 40);
        PieData pieData3 = new PieData("444", 40);
        PieData pieData4 = new PieData("555", 30);
        PieData pieData5 = new PieData("666", 20);
        list.add(pieData);
        list.add(pieData1);
        list.add(pieData2);
        list.add(pieData3);
        list.add(pieData4);
        list.add(pieData5);

        tu.setData(list);
    }
}
