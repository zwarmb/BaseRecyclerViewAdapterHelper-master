package com.example.demo1.view.viewpager;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yida on 2018/7/24.
 */

public class CycleViewPager extends ViewPager {
    private InnerPagerAdapter mInnerPagerAdapter;
    private int mCurrentIndex = 1;

    // 是否自动播放
    private boolean isPlay = false;
    private final int PLAY = 0x123;

    // 默认图片切换时间
    private long mDelayTime = 2000;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == PLAY) {
                setCurrentItem(mCurrentIndex);
                if (isPlay) {
                    play();
                }
            }
        }
    };


    public CycleViewPager(Context context) {
        super(context);
    }

    public CycleViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setAdapter(PagerAdapter adapter) {
        mInnerPagerAdapter = new InnerPagerAdapter(adapter);
        super.setAdapter(adapter);
        setCurrentItem(1);
    }

    public void startPlay(long delayTime) {
        isPlay = true;
        this.mDelayTime = delayTime;
        play();
    }

    private void play() {
        mCurrentIndex ++;
        mCurrentIndex = mCurrentIndex % mInnerPagerAdapter.getCount();
        if (mCurrentIndex == 0) {
            mCurrentIndex += 2;
        }
        mHandler.sendEmptyMessageDelayed(PLAY, mDelayTime);
    }

    public void stopPlay() {
        isPlay = false;
    }

    @Override
    public void setOnPageChangeListener(OnPageChangeListener listener) {
        super.setOnPageChangeListener(new InnerOnPageChangeListener(listener));
    }

    private class InnerOnPageChangeListener implements OnPageChangeListener {

        private int position;
        private OnPageChangeListener mOnPageChangeListener;

        public InnerOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
            mOnPageChangeListener = onPageChangeListener;
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (mOnPageChangeListener != null) {
                mOnPageChangeListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
        }

        @Override
        public void onPageSelected(int position) {
            mCurrentIndex = position;
            this.position = position;
            if (mOnPageChangeListener != null) {
                mOnPageChangeListener.onPageSelected(position);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            if (mOnPageChangeListener != null) {
                mOnPageChangeListener.onPageScrollStateChanged(state);
            }
            if (state == ViewPager.SCROLL_STATE_IDLE) {
                if (position == mInnerPagerAdapter.getCount() - 1) {
                    setCurrentItem(1, false);
                } else if (position == 0) {
                    setCurrentItem(mInnerPagerAdapter.getCount() - 2, false);
                }
            }
        }
    }

    private class InnerPagerAdapter extends PagerAdapter {

        private PagerAdapter mPagerAdapter;

        public InnerPagerAdapter(PagerAdapter pagerAdapter) {
            mPagerAdapter = pagerAdapter;
            pagerAdapter.registerDataSetObserver(new DataSetObserver() {
                @Override
                public void onChanged() {
                    super.onChanged();
                }

                @Override
                public void onInvalidated() {
                    super.onInvalidated();
                }
            });
        }

        @Override
        public int getCount() {
            return mPagerAdapter.getCount() + 2;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return mPagerAdapter.isViewFromObject(view, object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            if (position == 0) {
                position = mPagerAdapter.getCount() - 1;
            } else if (position == mPagerAdapter.getCount() + 1) {
                position = 0;
            } else {
                position -= 1;
            }
            return mPagerAdapter.instantiateItem(container, position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }
    }

}
