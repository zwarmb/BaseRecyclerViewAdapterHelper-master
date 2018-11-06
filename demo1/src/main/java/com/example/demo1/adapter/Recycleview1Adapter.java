package com.example.demo1.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.demo1.MainActivity;
import com.example.demo1.R;

import java.util.List;

/**
 * Created by yida on 2018/6/8.
 */

public class Recycleview1Adapter extends BaseQuickAdapter<MainActivity.rvBean, BaseViewHolder> {

    public Recycleview1Adapter(int layoutResId, @Nullable List<MainActivity.rvBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final MainActivity.rvBean item) {
        helper.setText(R.id.textView, item.getStr()).setText(R.id.textView2, item.getContent()).setText(R.id.textView4, item.getName());
//        helper.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(helper.itemView.getContext(), "点击了第" + item.getStr() + " 条", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
