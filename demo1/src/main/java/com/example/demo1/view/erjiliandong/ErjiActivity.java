package com.example.demo1.view.erjiliandong;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.demo1.R;

/**
 * Created by yida on 2018/6/21.
 */

public class ErjiActivity extends AppCompatActivity {

    private LinkedLayout mLinkedLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mLinkedLayout = findViewById(R.id.ll_main3);
    }
}
