package com.example.tupianbianxiangqingye;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

/**
 * Created by Administrator on 2018/1/9.
 */

public class CtrlLinearLayoutManager extends LinearLayoutManager {
    private boolean isScrollEnable = true;
    public CtrlLinearLayoutManager(Context context) {
        super(context);
    }

    public void setScrollEnable(boolean falg) {
        this.isScrollEnable = falg;
    }

    @Override
    public boolean canScrollHorizontally() {
        return isScrollEnable && super.canScrollHorizontally();
    }
}
