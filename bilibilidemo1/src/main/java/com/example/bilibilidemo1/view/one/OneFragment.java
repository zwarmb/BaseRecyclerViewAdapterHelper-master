package com.example.bilibilidemo1.view.one;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bilibilidemo1.R;
import com.example.bilibilidemo1.base.BaseFragment;
import com.example.bilibilidemo1.bean.ArcWerBean;
import com.example.bilibilidemo1.utils.MeToolbar;
import com.example.bilibilidemo1.zidingyi.ArcWerView;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends BaseFragment {


    @BindView(R.id.me_toolbar)
    MeToolbar mMeToolbar;
    @BindView(R.id.sliding_tabs)
    SlidingTabLayout mSlidingTabs;
    Unbinder unbinder;
    @BindView(R.id.arc_view)
    ArcWerView mArcView;

    public static OneFragment newInstance() {
        return new OneFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        initToolBar(view, "一");
        unbinder = ButterKnife.bind(this, view);
        mSlidingTabs.setVisibility(View.GONE);

        List<ArcWerBean> list = new ArrayList<>();
        ArcWerBean bean = new ArcWerBean();
        for (int i = 0; i < 6; i++) {
            bean.setAngle(0);
            bean.setTwlong(100);
            bean.setMovewidth(80);
            bean.setDistance(0);
            bean.setName("太极");
            list.add(bean);
        }
        mArcView.setDate(list);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
