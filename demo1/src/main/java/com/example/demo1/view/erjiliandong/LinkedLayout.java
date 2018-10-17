package com.example.demo1.view.erjiliandong;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.example.demo1.view.erjiliandong.base.BaseScrollableContainer;

/**
 * Created by yida on 2018/6/21.
 */

public class LinkedLayout extends LinearLayout {

    private Context mContext;
    private BaseScrollableContainer mTabContainer;
    private BaseScrollableContainer mContentContainer;

    public void setContenters(BaseScrollableContainer mTabContainer, BaseScrollableContainer mContentContainer) {}

    public LinkedLayout(Context context) {
        super(context);
    }

    public LinkedLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LinkedLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
