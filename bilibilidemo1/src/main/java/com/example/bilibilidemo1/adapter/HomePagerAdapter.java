package com.example.bilibilidemo1.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.bilibilidemo1.view.home.Home5Fragment;
import com.example.bilibilidemo1.view.home.home1.Home1Fragment;
import com.example.bilibilidemo1.view.home.home2.Home2Fragment;
import com.example.bilibilidemo1.view.home.home3.Home3Fragment;
import com.example.bilibilidemo1.view.home.home4.Home4Fragment;

/**
 * Created by yida on 2018/2/6.
 */

public class HomePagerAdapter extends FragmentPagerAdapter {
    private final String[] titles = {"首页", "新闻", "动画", "图片放大", "mmp"};
    private Fragment[] mFragments;

    public HomePagerAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new Fragment[titles.length];
    }

    @Override
    public Fragment getItem(int position) {
        if (mFragments[position] == null) {

            switch (position) {
                case 0:
                    mFragments[position] = Home1Fragment.newInstance();
                    break;
                case 1:
                    mFragments[position] = Home2Fragment.newInstance();
                    break;
                case 2:
                    mFragments[position] = Home3Fragment.newInstance();
                    break;
                case 3:
                    mFragments[position] = Home4Fragment.newInstance();
                    break;
                case 4:
                    mFragments[position] = Home5Fragment.newInstance();
                    break;
            }
        }
        return mFragments[position];
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
