package com.example.yida.dagger2demo.demo2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.yida.dagger2demo.R;

import javax.inject.Inject;

/**
 * Created by yida on 2018/7/31.
 */

public class TwoActivity extends AppCompatActivity {

//    @Inject
//    Product mProduct;

    @Inject
    Two mTwo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DaggerTwoActivityComponent.create().inject(this);
        DaggerTwoActivityComponent.builder().build().inject(this);
    }
}
