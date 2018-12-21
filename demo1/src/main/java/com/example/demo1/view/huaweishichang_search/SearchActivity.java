package com.example.demo1.view.huaweishichang_search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.demo1.R;

/**
 * Created by yida on 2018/11/21.
 */

public class SearchActivity extends AppCompatActivity implements View.OnClickListener{

    private SearchBar mSearch;
    private int i = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mSearch = findViewById(R.id.search);
        Button button = findViewById(R.id.bt);
        button.setOnClickListener(this);
        mSearch.setDuration(500)
                .setSearchIcon(R.mipmap.ic_search)
                .setSearchTextHint("最火爆的应用:搜索一下");

    }


    @Override
    public void onClick(View v) {
        if (i % 2 == 0) {
            mSearch.closeAnimation();
        } else {
            mSearch.startAnimation();
        }
        i++;
    }
}
