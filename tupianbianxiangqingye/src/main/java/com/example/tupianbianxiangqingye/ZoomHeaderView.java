package com.example.tupianbianxiangqingye;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/1/8.
 */

public class ZoomHeaderView extends LinearLayout {
    private float mTouchSlop;
    private ZoomHeaderViewPager mViewPager;

    private float iDownY;
    private float mFirstY;
    private boolean isExpand = false;
    private TextView mTextView;

    private RecyclerView mRecyclerView;
    private RelativeLayout mBottomView;

    // 图片放到最大时的y
    private float mMaxY;
    private final int ANIMATE_LENGTH = 300;

    // 底部栏的其实Y
    private int mBottomY;

    public ZoomHeaderView(Context context) {
        super(context);
    }

    public ZoomHeaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        // 获得给定视图
        mViewPager = (ZoomHeaderViewPager) getChildAt(1);
        mFirstY = getY();
        mTextView = findViewById(R.id.tv_close);
    }

    public ZoomHeaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return true;
            case MotionEvent.ACTION_MOVE:
                float moveY = event.getY() - iDownY;
                float currentY = getY();

                // 向上滑动viewpager整体向上移动
                if (currentY + moveY < 0 && currentY + moveY > -getHeight() / 2) {
                    doPagerUp(moveY, currentY);
                }
                // 向下移动退出viewpager
                if (currentY + moveY > 0 && currentY + moveY < 800) {
                    doPagerDown(moveY, currentY);
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
                float upY = event.getY() - iDownY;
                float currentUpY = getY();
                // 当超过阀值时, 结束掉viewpager
                if (upY + currentUpY > 190) {
                    finish();
                }
                // 小于阀值, 回复到viewpager初始的样子
                if (currentUpY + upY > -getHeight() / 4 && currentUpY + upY < 190) {
                    restore(upY + currentUpY);
                }
                // 超过展开的阀值
                if (upY + currentUpY < -getHeight() / 4) {
                    if (upY + currentUpY < mMaxY) {
                        expand(mMaxY);
                    } else {
                        expand(upY + currentUpY);
                    }
                }
                return true;
        }
        return super.onTouchEvent(event);
    }


    private void doPagerDown(float moveY, float currentY) {
        int pos = mViewPager.getCurrentItem();
        View v = mViewPager.getChildAt(pos);
        v.setTranslationY((currentY + moveY) / 4);
        mTextView.setAlpha(v.getY() / 76);
    }

    private void doPagerUp(float moveY, float currentY) {
        mMaxY = currentY + moveY;
        setTranslationY(currentY + moveY);
        mTextView.setAlpha(0f);
    }

    public void restore(float y) {
        mTextView.setAlpha(0f);
        if (y > mFirstY) {
            ValueAnimator valueAnimator = ValueAnimator.ofFloat(1, 0);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mTextView.setAlpha((Float) animation.getAnimatedValue());
                }
            });
            valueAnimator.setDuration(ANIMATE_LENGTH);
            valueAnimator.start();
        }

        mRecyclerView.scrollToPosition(0);
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(y, mFirstY);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float y = (float) animation.getAnimatedValue();
                setTranslationY(y);
                isExpand = false;
                mViewPager.canScroll = true;
            }
        });

        valueAnimator.setDuration(ANIMATE_LENGTH);
        valueAnimator.start();
        // 底层的recycleView禁止滑动
        ((CtrlLinearLayoutManager)mRecyclerView.getLayoutManager()).setScrollEnable(false);

        // 隐藏底部
        ValueAnimator bottomAnimate = ValueAnimator.ofFloat(mBottomView.getY(), mBottomView.getHeight() + mBottomY);
        bottomAnimate.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mBottomView.setY((Float) animation.getAnimatedValue());
            }
        });
        bottomAnimate.start();
    }

    private void expand(float y) {
        mRecyclerView.scrollToPosition(0);
        ValueAnimator va = ValueAnimator.ofFloat(y, -getHeight() / 3);
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float y = (float) animation.getAnimatedValue();
                mViewPager.canScroll = false;
                setTranslationY(y);
                isExpand = true;
            }
        });

        va.setInterpolator(new DecelerateInterpolator());
        va.setDuration(ANIMATE_LENGTH);
        va.start();
        // 应许滑动
        ((CtrlLinearLayoutManager)mRecyclerView.getLayoutManager()).setScrollEnable(true);

        // 底部上移
        ValueAnimator bottomAnimae = ValueAnimator.ofFloat(mBottomView.getY(), mBottomY);
        bottomAnimae.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mBottomView.setY((Float) animation.getAnimatedValue());
            }
        });
        bottomAnimae.start();
    }

    private void finish() {
        TranslateAnimation ta = new TranslateAnimation(0, 0, 0, 1000);
        ta.setDuration(ANIMATE_LENGTH);
        ta.setFillAfter(true);
        ta.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ((Activity)getContext()).finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        startAnimation(ta);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                iDownY = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int moveY = (int) ev.getY();
                if (Math.abs(moveY - iDownY) > mTouchSlop) {
                    return true;
                }
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    public ZoomHeaderViewPager getViewPager() {
        return mViewPager;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean expand) {
        isExpand = expand;
    }

    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
    }

    public RelativeLayout getBottomView() {
        return mBottomView;
    }

    public void setBottomView(RelativeLayout bottomView, int bottomY) {
        mBottomView = bottomView;
        mBottomY = bottomY;
    }
}
