package com.example.bilibilidemo1.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.bilibilidemo1.R;

/**
 * Created by yida on 2018/2/3.
 */

public class MeToolbar extends Toolbar {
    private TextView mTitleTextView;
    private TextView mLeftTextView;
    private TextView mRightTextView;
//    private SlidingTabLayout mSlidingTabLayout;

    public MeToolbar(Context context) {
        super(context, null);
    }

    public MeToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public MeToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 初始化toolbar控件
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        mLeftTextView = this.findViewById(R.id.tv_return);
        mTitleTextView = this.findViewById(R.id.tv_title);
        mRightTextView = this.findViewById(R.id.tv_right);
//        mSlidingTabLayout = this.findViewById(R.id.sliding_tabs);

    }

//    public void setSlidingTabLayoutIsShow(boolean isShow) {
//        if (isShow) {
//            mSlidingTabLayout.setVisibility(VISIBLE);
//        }else {
//            mSlidingTabLayout.setVisibility(GONE);
//        }
//    }

//    public void setSlidingTabLayoutIsShow() {
//        mSlidingTabLayout.setVisibility(GONE);
//    }

    /**
     * 设置title文本
     *
     * @param title
     */
    public void setCenterTitle(String title) {

        this.setTitle("");
        mTitleTextView.setVisibility(VISIBLE);
        mTitleTextView.setText(title);

    }

    /**
     * 设置title颜色
     *
     * @param titleColor
     */
    public void setTitleColor(int titleColor) {
        mTitleTextView.setTextColor(titleColor);
    }


    /**
     * 设置左侧文本颜色
     *
     * @param color
     */
    public void setLeftTextColor(int color) {
        mLeftTextView.setTextColor(color);
    }

    /**
     * 设置左侧文本图片资源
     *
     * @param res
     */
    public void setLeftDrawable(int res) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), res);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        mLeftTextView.setCompoundDrawables(drawable, null, null, null);
    }

    /**
     * 设置左侧点击事件
     *
     * @param onClickListener
     */
    public void setLeftOnclistener(OnClickListener onClickListener) {
        mLeftTextView.setOnClickListener(onClickListener);
    }

    /**
     * 设置右侧文本
     *
     * @param s
     */
    public void setRightText(String s) {

        this.setTitle("");
        if ("".equals(s)) {
            mRightTextView.setVisibility(GONE);
        }
        mRightTextView.setVisibility(VISIBLE);
        mRightTextView.setText(s);

    }

    /**
     * 设置右侧文本颜色
     *
     * @param rightTextColor
     */
    public void setRightTextColor(int rightTextColor) {
        mRightTextView.setTextColor(rightTextColor);
    }

    /**
     * 设置右侧图片资源
     *
     * @param res
     */
    public void setRightDrawable(int res) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), res);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        mRightTextView.setCompoundDrawables(drawable, null, null, null);
    }

    /**
     * 设置右侧文本点击事件
     *
     * @param onClickListener
     */
    public void setRightListener(OnClickListener onClickListener) {
        mRightTextView.setOnClickListener(onClickListener);
    }


    /**
     * 设置左侧文本
     *
     * @param s
     */
    public void setLeftText(String s) {

        this.setTitle("");
        mLeftTextView.setVisibility(VISIBLE);
        mLeftTextView.setText(s);

    }

}
