package com.example.bilibilidemo1.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bilibilidemo1.R;
import com.example.bilibilidemo1.utils.MeToolbar;
import com.flyco.tablayout.SlidingTabLayout;

import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * Created by yida on 2018/2/2.
 */

public class BaseFragment extends SwipeBackFragment {

    public Activity mActivity;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setParallaxOffset(0.5f);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mActivity = getActivity();
    }

//    public AppBarLayout isShow(View view) {
//        AppBarLayout appBarLayout = view.findViewById(R.id.abl);
//
//    }

    public void isShow(View view, boolean isShow) {
        SlidingTabLayout slidingTabLayout = view.findViewById(R.id.sliding_tabs);
        if (isShow) {
            slidingTabLayout.setVisibility(View.VISIBLE);
        } else {
            slidingTabLayout.setVisibility(View.GONE);
        }
    }

    public MeToolbar initToolBar(View view, String title) {
        MeToolbar meToolbar = view.findViewById(R.id.me_toolbar);
        meToolbar.setCenterTitle(title);
        isShow(view, false);
        return meToolbar;
    }

    public MeToolbar initToolBar(View view, String title, boolean isShow) {
        MeToolbar meToolbar = view.findViewById(R.id.me_toolbar);
        meToolbar.setCenterTitle(title);
        isShow(view, isShow);
        return meToolbar;
    }

    public MeToolbar initToolBar(View view ,String title, int resID) {
        MeToolbar meToolbar = view.findViewById(R.id.me_toolbar);
        meToolbar.setCenterTitle(title);
        meToolbar.setLeftDrawable(resID);
        meToolbar.setLeftOnclistener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftInput();
                pop();
            }
        });
        return meToolbar;
    }

    public MeToolbar initToolBar(View view ,String title, int resID, boolean isShow) {
        MeToolbar meToolbar = view.findViewById(R.id.me_toolbar);
        meToolbar.setCenterTitle(title);
        meToolbar.setLeftDrawable(resID);
        isShow(view, isShow);
        meToolbar.setLeftOnclistener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftInput();
                pop();
            }
        });
        return meToolbar;
    }

    public MeToolbar initToolBar(View view, String title, String rightText, View.OnClickListener onClickListener) {
        MeToolbar meToolbar = view.findViewById(R.id.me_toolbar);
        meToolbar.setCenterTitle(title);
        meToolbar.setRightText(rightText);
//        meToolbar.setSlidingTabLayoutIsShow();
        meToolbar.setRightListener(onClickListener);
        return  meToolbar;
    }

    public MeToolbar initToolBar(View view, String title, int resID, View.OnClickListener onClickListener) {
        MeToolbar meToolbar = view.findViewById(R.id.me_toolbar);
        meToolbar.setCenterTitle(title);
        meToolbar.setRightDrawable(resID);
//        meToolbar.setSlidingTabLayoutIsShow();
        meToolbar.setRightListener(onClickListener);
        return  meToolbar;
    }

    public MeToolbar initToolBar(View view, String title, int resID, String rightText, View.OnClickListener onClickListener) {
        MeToolbar meToolbar = view.findViewById(R.id.me_toolbar);
        meToolbar.setCenterTitle(title);
        meToolbar.setLeftDrawable(resID);
//        meToolbar.setSlidingTabLayoutIsShow();
        meToolbar.setLeftOnclistener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftInput();
                pop();
            }
        });
        meToolbar.setRightText(rightText);
        meToolbar.setRightListener(onClickListener);
        return meToolbar;
    }

    public MeToolbar initToolBar(View view, String title, int resID, int rightResID, View.OnClickListener onClickListener) {
        MeToolbar meToolbar = view.findViewById(R.id.me_toolbar);
        meToolbar.setCenterTitle(title);
        meToolbar.setLeftDrawable(resID);
//        meToolbar.setSlidingTabLayoutIsShow();
        meToolbar.setLeftOnclistener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftInput();
                pop();
            }
        });
        meToolbar.setRightDrawable(rightResID);
        meToolbar.setRightListener(onClickListener);
        return meToolbar;
    }

//    // 网络请求无数据时页面显示的友好提示
//    public View getEmptyView(RecyclerView recyclerView) {
//        return getEmptyView(recyclerView, "暂无数据 !");
//    }
//
//    public void getEmptyView(RecyclerView recyclerView, String txt) {
//        View view = getLayoutInflater().inflate(R.layout)
//    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 隐藏软键盘
        hideSoftInput();
    }
}
