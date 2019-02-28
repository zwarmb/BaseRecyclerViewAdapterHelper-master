package com.example.demo1.view.zidinyi_view_huabu.picture_text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yida on 2019/1/17.
 */
public class Picture_text_view extends View {

    private int mWidth, mHeight;
    private Paint mPaint;

    public Picture_text_view(Context context) {
        super(context, null);
    }

    public Picture_text_view(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(20);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String str = "ABCDEFGHIJKLMN";
        // 绘制字符在如下坐标处
        canvas.drawText(str, 200, 100, mPaint);

        // 左毕右开, 筛选一段字符并绘制在指定位置
        canvas.drawText(str, 2, 8, 200, 200, mPaint);

        String s = "已不再这";
        // 对每个字符指定位置
        canvas.drawPosText(s, new float[] {300, 20, 320, 40, 340, 60, 360, 80}, mPaint);


    }
}
