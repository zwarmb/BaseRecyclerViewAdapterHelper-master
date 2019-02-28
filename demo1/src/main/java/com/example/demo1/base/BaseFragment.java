package com.example.demo1.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.demo1.R;

import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * Created by yida on 2018/12/26.
 */
public abstract class BaseFragment extends SwipeBackFragment {
    public Activity mActivity;
    protected View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutId(), null);
        return isSupportSwipeBack() ? attachToSwipeBack(mView) : mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mActivity = getActivity();
        initView(mView);
    }

    public void initToolbar(View view, String title) {
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        TextView textView = toolbar.findViewById(R.id.toolbar_title);
        if (toolbar.findViewById(R.id.toolbar_title) != null) {
//            toolbar.findViewById(R.id.toolbar_title).setText();
            textView.setText(title);
        } else {
            toolbar.setTitle(title);
        }
    }

    /**
     * 处理物理返回按键
     * @return
     */
    @Override
    public boolean onBackPressedSupport() {
        pop();
        return true;
    }

    protected boolean isSupportSwipeBack() {
        return false;
    }

    protected abstract void initView(View view);

    protected abstract int getLayoutId();


}
