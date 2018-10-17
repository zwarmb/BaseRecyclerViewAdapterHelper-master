package com.example.bilibilidemo1.view.home.home;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.bilibilidemo1.R;
import com.example.bilibilidemo1.adapter.HomePagerAdapter;
import com.example.bilibilidemo1.base.SimpleFragment;
import com.flyco.tablayout.SlidingTabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by yida on 2018/2/3.
 */

public class HomeFragment extends SimpleFragment<HomePresenter> implements HomeContract.View {

    @BindView(R.id.sliding_tabs)
    SlidingTabLayout mSlidingTabs;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    Unbinder unbinder;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    private void initHomeViewpager() {
        HomePagerAdapter homePagerAdapter = new HomePagerAdapter(getChildFragmentManager());
        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setAdapter(homePagerAdapter);
        mSlidingTabs.setViewPager(mViewPager);
        // 默认显示第一个
        mViewPager.setCurrentItem(0);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this, view);

        initToolBar(view, "首页", true);

        initHomeViewpager();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }
}
