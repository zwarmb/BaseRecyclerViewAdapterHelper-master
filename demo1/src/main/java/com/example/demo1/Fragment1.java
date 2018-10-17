package com.example.demo1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yida on 2018/6/13.
 */

public class Fragment1 extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f1);

        mRecyclerView = findViewById(R.id.mv11);

        initView();

    }

    private void initView() {
        List<Fragment1Bean> fragment1Bean = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Fragment1Bean fragment1Bean1 = new Fragment1Bean();
            fragment1Bean1.setStr("条目" + i);
            fragment1Bean.add(fragment1Bean1);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(R.layout.item_f1, fragment1Bean);
        fragmentAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Log.e("qq", "点击了第 " + position);
            }
        });
        mRecyclerView.setAdapter(fragmentAdapter);
    }


    class FragmentAdapter extends BaseQuickAdapter<Fragment1Bean, BaseViewHolder> {

        public FragmentAdapter(int layoutResId, @Nullable List<Fragment1Bean> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, Fragment1Bean item) {
            helper.setText(R.id.text3, item.getStr());
        }


        @Override
        public int getItemCount() {
            return super.getItemCount();
        }
    }



    private class Fragment1Bean {
        String str;
        ImageView mImageView;

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public ImageView getImageView() {
            return mImageView;
        }

        public void setImageView(ImageView imageView) {
            mImageView = imageView;
        }
    }
}
