package com.example.demo1.view.glide;

import android.widget.PopupWindow;

/**
 * Created by yida on 2018/6/28.
 */

public class MyPopupWindow extends PopupWindow {

    final MyPopupController mPopupController;

    @Override
    public int getWidth() {
        return super.getWidth();
    }

    public MyPopupWindow(MyPopupController popupController) {
        mPopupController = popupController;
    }
}
