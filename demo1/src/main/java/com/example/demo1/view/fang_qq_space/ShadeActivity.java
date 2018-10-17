package com.example.demo1.view.fang_qq_space;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.demo1.R;

/**
 * Created by yida on 2018/7/27.
 */

public class ShadeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shade);
        findViewById(R.id.iv2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((ShadeImageView)v).getWhere_click()== ShadeImageView.CLICK_SPACE)
                    Toast.makeText(getApplicationContext(),"背景点击",Toast.LENGTH_SHORT).show();
                else if(((ShadeImageView)v).getWhere_click()== ShadeImageView.CLICK_RANGE)
                {
                    Toast.makeText(getApplicationContext(),"范围点击",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
