package com.example.demo1.view.zidinyi_view_huabu.picture_text;

import android.view.View;

import com.example.demo1.R;
import com.example.demo1.base.BaseFragment;

/**
 * Created by yida on 2019/1/17.
 */
public class PictureOrTextFragment extends BaseFragment {

    public static PictureOrTextFragment newInstance() {
        return new PictureOrTextFragment();
    }


    @Override
    protected boolean isSupportSwipeBack() {
        return true;
    }

    @Override
    protected void initView(View view) {
        initToolbar(view, "图片与文字");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_picture_text;
    }
}
