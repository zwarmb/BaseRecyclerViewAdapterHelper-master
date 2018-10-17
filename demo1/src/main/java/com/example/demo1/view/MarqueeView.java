package com.example.demo1.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by yida on 2018/6/13.
 */

public class MarqueeView extends RecyclerView {
    public MarqueeView(Context context) {
        super(context);
    }

    public MarqueeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MarqueeView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    Thread mThread = null;
    AtomicBoolean mAtomicBoolean = new AtomicBoolean(false);
    Handler mHandler;

    private void init() {

        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1:
                    MarqueeView.this.scrollBy(5, 5);
                    break;
                }
            }
        };

        if (mThread == null) {
            mThread = new Thread() {
                @Override
                public void run() {
                    while (mAtomicBoolean.get()) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        Message msg = mHandler.obtainMessage();
                        msg.what=1;
                        msg.sendToTarget();

                    }
                    // 退出循環時清理handler
                    mHandler = null;
                }
            };
        }
    }

    /**
     * 在附着在窗口的时候开始调用
     */
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mAtomicBoolean.set(true);
        init();
        mThread.start();
    }

    /**
     * 在脱离窗口是处理相应的操作
     */
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopMarquee();
    }

    /**
     * 停止滚动
     */
    private void stopMarquee() {
        mAtomicBoolean.set(false);
        mThread = null;
    }
}
