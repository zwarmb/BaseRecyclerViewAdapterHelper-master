package com.example.demo1.view.zidinyi_view_huabu.xuanzhuan;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yida on 2018/12/25.
 */
public class XuanZhuan_yuanhuan_View extends View {

    private Paint mPaint = new Paint();
    private int mWidth, mHeight;

    public XuanZhuan_yuanhuan_View(Context context) {
        super(context, null);
    }

    public XuanZhuan_yuanhuan_View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    // 初始化画笔
    private void init() {
        mPaint.setColor(Color.RED);    // 颜色
        mPaint.setAntiAlias(true);      // 抗锯齿
        mPaint.setStyle(Paint.Style.STROKE);
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

        // 绘制十字线
        canvas.drawLines(new float[]{
                0, mHeight / 2, mWidth, mHeight / 2,
                mWidth / 2, 0, mWidth / 2, mHeight
        }, mPaint);


        mPaint.setColor(Color.BLUE);

        canvas.translate(mWidth / 2, mHeight / 2);

        canvas.drawCircle(0, 0, 200, mPaint);
        canvas.drawCircle(0, 0, 180, mPaint);
        for (int i = 0; i < 360; i+=10) {
            canvas.drawLine(0, 180, 0, 200, mPaint);
            canvas.rotate(10);
        }

    }
}
