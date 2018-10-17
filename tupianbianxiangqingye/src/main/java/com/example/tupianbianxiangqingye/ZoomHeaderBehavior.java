package com.example.tupianbianxiangqingye;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/1/8.
 */

public class ZoomHeaderBehavior extends CoordinatorLayout.Behavior<View> {
    public ZoomHeaderBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private boolean isFirst = true;
    private ZoomHeaderView mHeaderView;

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return super.layoutDependsOn(parent, child, dependency);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        init((RecyclerView) child, dependency);
        return super.onDependentViewChanged(parent, child, dependency);
    }

    private void init(final RecyclerView child, View dependency) {
        if (isFirst) {
            mHeaderView = (ZoomHeaderView) dependency;
            isFirst = false;
            mHeaderView.setRecyclerView(child);
            child.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                }

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    if (child.getChildAt(0).getY() == 0) {
                        mHeaderView.restore(mHeaderView.getY());
                    }
                    super.onScrolled(recyclerView, dx, dy);
                }
            });
        }
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        // 只处理上下滑动
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY, boolean consumed) {
        if (velocityY < 0 && ((RecyclerView)target).getChildAt(0).getY() == 0) {
            mHeaderView.restore(mHeaderView.getY());
        }
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        if (((RecyclerView) target).getChildAt(0).getY() == 0) {
            if (dy < 0) {
                mHeaderView.setY(mHeaderView.getY() - dy);
                if (mHeaderView.getY() < 500) {
                    mHeaderView.restore(mHeaderView.getY());
                }
            }
        }
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
    }
}
