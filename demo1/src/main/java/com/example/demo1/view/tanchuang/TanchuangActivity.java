package com.example.demo1.view.tanchuang;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.WindowManager;

import com.example.demo1.R;

/**
 * Created by yida on 2018/6/29.
 */

public class TanchuangActivity extends AppCompatActivity {

    private long saveTime = 15 * 1000;  // 设置定时跳转的时长
    private CountDownTimer mCountDownTimer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanchuang);


        // 设置屏幕常亮
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


    }


    /**
     * 监听屏幕的点击事件
     *
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            // 离开手指
            case MotionEvent.ACTION_UP:

                break;
            // 点击屏幕
            case MotionEvent.ACTION_DOWN:

                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    public void startGG() {
        if (mCountDownTimer == null) {
            mCountDownTimer = new CountDownTimer(saveTime, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {  // 计时途中

                }

                @Override
                public void onFinish() {    // 计时完毕触发操作
                    // TODO: 2018/6/29 弹出弹窗
                    new AlertDialog.Builder(getApplicationContext())
                            .setTitle("真的要这样吗")
                            .setMessage("点击了就无法挽回了")
                            .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //关掉弹窗
                                    dialog.dismiss();
                                }
                            });
                }
            };
            mCountDownTimer.start();
        } else {
            mCountDownTimer.start();
        }

    }


    @Override
    protected void onResume() {
        super.onResume();
        // 屏幕显示时重启该操作
        startGG();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 在界面销毁的时候停止定时
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }

    }
}
