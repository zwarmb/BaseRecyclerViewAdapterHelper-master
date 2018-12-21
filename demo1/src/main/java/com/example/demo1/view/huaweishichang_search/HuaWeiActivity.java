package com.example.demo1.view.huaweishichang_search;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.demo1.R;

/**
 * Created by yida on 2018/11/21.
 */

public class HuaWeiActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huawei_main);
        Button btFirst = findViewById(R.id.bt_first);
        Button btSecond = findViewById(R.id.bt_second);
        btFirst.setOnClickListener(this);
        btSecond.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_first:
                Intent intent = new Intent(this, MarketActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_second:
                Intent intent1 = new Intent(this, SearchActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
