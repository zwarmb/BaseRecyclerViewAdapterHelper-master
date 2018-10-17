package com.example.demo1;

import android.app.Fragment;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewPager;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2017/12/28.
 */

public class BannerFragment extends Fragment {
    private static final int MSG_LOOP = 1000;
    private static final int LOOP_INTERVAL = 5000;
    private ViewPager mViewPager = null;


    private static class BannerHandler extends Handler{
        private WeakReference<BannerFragment> mWeakReference = null;

        public BannerHandler(BannerFragment bannerFragment){
            super(Looper.getMainLooper());
            this.mWeakReference = new WeakReference<BannerFragment>(bannerFragment);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (this.mWeakReference == null){
                return;
            }
            BannerFragment bannerFragment = this.mWeakReference.get();
            if (bannerFragment == null || bannerFragment.mViewPager == null || bannerFragment.mViewPager.getAdapter() == null || bannerFragment.mViewPager.getAdapter().getCount() <= 0){
                return;
            }
            int curPos = bannerFragment.mViewPager.getCurrentItem();
            curPos = (curPos + 1) % bannerFragment.mViewPager.getAdapter().getCount();
            bannerFragment.mViewPager.setCurrentItem(curPos);
            if (hasMessages(MSG_LOOP)){
                removeMessages(MSG_LOOP);
            }
            sendEmptyMessageDelayed(MSG_LOOP, LOOP_INTERVAL);
        }
    }



}
