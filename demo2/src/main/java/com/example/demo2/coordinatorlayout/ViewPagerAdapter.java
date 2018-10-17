package com.example.demo2.coordinatorlayout;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by yida on 2018/7/16.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private List<Fragment> mFragmentList;
    private String[] mTitle;

    public ViewPagerAdapter(FragmentManager fm, Context context, List<Fragment> fragmentList, String[] title) {
        super(fm);
        mContext = context;
        mFragmentList = fragmentList;
        mTitle = title;
    }


    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragmentList, String[] title) {
        super(fm);
        mFragmentList = fragmentList;
        mTitle = title;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position > mTitle.length) {
            return "";
        }
        return mTitle[position];
    }
}
