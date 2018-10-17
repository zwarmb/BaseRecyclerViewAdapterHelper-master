package com.example.demo1.view.glide;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;

/**
 * Created by yida on 2018/6/28.
 */

class MyPopupController {

    private int layoutResId;            // 布局id
    private Context mContext;
    private PopupWindow mPopupWindow;
    private View mPopupView;            // 弹窗布局view
    private View mView;
    private Window mWindow;

    public MyPopupController(Context context, PopupWindow popupWindow) {
        mContext = context;
        mPopupWindow = popupWindow;
    }

    public void setView(int layoutResId) {
        mView = null;
        this.layoutResId = layoutResId;
        installContent();
    }

    public void setView(View view) {
        mView = view;
        this.layoutResId = 0;
        installContent();
    }

    private void installContent() {
        if (layoutResId != 0) {
            mPopupView = LayoutInflater.from(mContext).inflate(layoutResId, null);
        } else if (mView != null) {
            mPopupView = mView;
        }
        mPopupWindow.setContentView(mPopupView);
    }

    /**
     * 设置弹窗宽高
     * @param width
     * @param height
     */
    private void setWidthAndHeight(int width, int height) {
        if (width == 0 || height == 0) {
            // 如果没设置宽高， 默认是包裹内容
            mPopupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
            mPopupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        } else {
            mPopupWindow.setHeight(height);
            mPopupWindow.setWidth(width);
        }
    }

    /**
     * 设置背景灰色透明度
     * @param f
     */
    private void setBackGroupLevel(float f) {
        mWindow = ((Activity)mContext).getWindow();
        WindowManager.LayoutParams params = mWindow.getAttributes();
        params.alpha = f;
        mWindow.setAttributes(params);
    }

    /**
     * 设置动画样式
     * @param style
     */
    private void setAnimation(int style) {
        mPopupWindow.setAnimationStyle(style);
    }

    /**
     * 设置outside是否可点击
     * @param touchable
     */
    public void setOutsideTouchable(boolean touchable) {
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000)); // 设置背景透明
        mPopupWindow.setOutsideTouchable(touchable);    // 设置outside可点击
        mPopupWindow.setFocusable(touchable);
    }

    static class PopupParams {

        int layoutResId;  // 布局Id
        Context mContext;
        int width, height;  // 弹窗的宽和高
        boolean isShowBg, isShowAnim;
        float bg_level;
        int animationStyle;
        View mView;
        boolean isTouchable;

        public PopupParams(Context context) {
            mContext = context;
        }

        public void apply(MyPopupController controller) {
            if (mView != null) {
                controller.setView(mView);
            } else if (layoutResId != 0) {
                controller.setView(layoutResId);
            } else {
                throw new IllegalArgumentException("popupwindow is null");
            }
            controller.setWidthAndHeight(width, height);
            controller.setOutsideTouchable(isTouchable);
            if (isShowBg) {
                controller.setBackGroupLevel(bg_level);
            }
            if (isShowAnim) {
                controller.setAnimation(animationStyle);
            }
        }
    }
}
