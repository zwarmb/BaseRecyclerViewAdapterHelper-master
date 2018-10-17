package com.example.demo1.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.demo1.MainActivity;
import com.example.demo1.R;

import java.util.List;

/**
 * Created by yida on 2018/6/13.
 */

public class Main2Adapter extends BaseQuickAdapter<MainActivity.rvBean, BaseViewHolder> {
    public Main2Adapter(int layoutResId, @Nullable List<MainActivity.rvBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MainActivity.rvBean item) {

        helper.setText(R.id.id_tv_title, item.getStr()).setText(R.id.id_tv_desc, item.getContent());
        if (helper.getLayoutPosition() > 0 && helper.getLayoutPosition() % 6 == 0) {
            helper.setVisible(R.id.id_tv_title, false);
            helper.setVisible(R.id.id_tv_desc, false);
            helper.setVisible(R.id.id_iv_ad, true);
        } else {
            helper.setVisible(R.id.id_tv_title, true);
            helper.setVisible(R.id.id_tv_desc, true);
            helper.setVisible(R.id.id_iv_ad, false);
        }
    }
}
