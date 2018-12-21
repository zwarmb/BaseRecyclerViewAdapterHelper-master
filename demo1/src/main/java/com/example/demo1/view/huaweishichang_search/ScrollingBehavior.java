package com.example.demo1.view.huaweishichang_search;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yida on 2018/11/20.
 */

public class ScrollingBehavior extends CoordinatorLayout.Behavior<SearchBar>{

    public ScrollingBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, SearchBar child, View dependency) {
        return isDepent(dependency);
    }

    private boolean isDepent(View dependency) {
        return dependency != null && dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, SearchBar child, View dependency) {
        float y = dependency.getY();
        int totalScrollRange = ((AppBarLayout)dependency).getTotalScrollRange();

        if (Math.abs(y) < totalScrollRange * 0.6) {
            if (child.getCurrentState() == SearchBar.State.OPEN) { // 当searchBar处于展开状态
                child.setTranslationY(y);
            } else if (child.getCurrentState() == SearchBar.State.EXPANDING) { // 当searchBar处于展开和收缩的过程中
                child.setTranslationY(y);
            }
        }
        return true;
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull SearchBar child,
                                  @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
    }
}
