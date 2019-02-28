package com.example.demo1.view.zidinyi_view_huabu.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yida on 2019/1/28.
 */
public class TextDemoView extends View {

    private Paint mPaint;
    private int mWidth, mHeight;



    public TextDemoView(Context context) {
        super(context, null);
    }

    public TextDemoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
//        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mHeight = h;
        this.mWidth = w;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.BLACK);
        canvas.drawLine(0, mHeight / 2, mWidth, mHeight / 2, mPaint);
        canvas.drawLine(mWidth / 2, 0, mWidth / 2, mHeight, mPaint);



        // 移动原点至画布中心
        canvas.translate(mWidth / 2, mHeight / 2);



        mPaint.setColor(Color.RED);
        mPaint.setTextSize(50);
        String s = "zhangyida";
        canvas.drawText(s, 0, 0, mPaint);



    }
}
