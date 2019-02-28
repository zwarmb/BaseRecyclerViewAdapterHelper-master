package com.example.demo1.view.leida;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.demo1.R;

/**
 * Created by yida on 2018/6/19.
 */

public class LeidaActivity extends AppCompatActivity {

    private String[] titles = {"我", "的", "老", "家", "在", "这"};
    private double[] data = {6, 7, 7, 5, 10, 8};
    private LeidaRadarView mLeidaRadarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laida);
        mLeidaRadarView = findViewById(R.id.laida);

        mLeidaRadarView.setCount(6);
        mLeidaRadarView.setData(data);
        mLeidaRadarView.setMaxValue(10);
        mLeidaRadarView.setTitles(titles);
    }
}
