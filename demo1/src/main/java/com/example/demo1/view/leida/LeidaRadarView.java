package com.example.demo1.view.leida;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by yida on 2018/6/19.
 */

public class LeidaRadarView extends View {

    private int count = 6; // 数据个数为6， 数据是几就是几边形
    private float angle = (float) (Math.PI / 3);
    private double[] data = {50, 50, 50, 50, 50, 50}; // 默认数据
    private float maxValue = 100; // 数据最大值
    private String[] titles = {"a", "b", "c", "d", "e", "f"}; // 默认标题

    private Paint radarPaint;  // 蜘蛛网画笔， 也就是背景蛛网
    private Paint valuePaint;  // 上层的数据
    private Paint textPaint;   // 标题的text画笔

    private float radius;       // 网格最大半径
    private int centerX;        // 雷达中心坐标x
    private int centerY;        // 坐标y

    public LeidaRadarView(Context context) {
        super(context);
        init();
    }

    public LeidaRadarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LeidaRadarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) { //
            setMeasuredDimension(dp2px(300), dp2px(300));
        } else if (widthMeasureSpec == MeasureSpec.AT_MOST) {
            setMeasuredDimension(dp2px(250), heightSpecSize);
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpecSize, dp2px(250));
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        radius = Math.min(h, w) / 2 *0.65f;
        centerX = w / 2;
        centerY = h / 2;

        postInvalidate();
    }

    private void init() {
        Log.e("leida", "init");
        radarPaint = new Paint(); // 蛛网
        radarPaint.setColor(Color.GRAY);
        radarPaint.setAntiAlias(true); // 抗锯齿
        radarPaint.setStyle(Paint.Style.STROKE);

        valuePaint = new Paint();
        valuePaint.setColor(Color.BLUE);
        valuePaint.setAntiAlias(true); // 抗锯齿
        valuePaint.setStyle(Paint.Style.FILL_AND_STROKE); // 填充

        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(sp2px(16));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawRegion(canvas);
        drawHexagon(canvas);
        drawText(canvas);
    }

    private void drawText(Canvas canvas) {
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float fontHeight = fontMetrics.descent - fontMetrics.ascent;
        for (int i = 0; i < count; i++) {
            float x = (float) (centerX + radius * Math.cos(angle * i));
            float y = (float) (centerY + radius * Math.sin(angle * i));

            if (angle * i >= 0 && angle * i <= Math.PI / 2) {
                canvas.drawText(titles[i], x, y + fontHeight / 2, textPaint);
            } else if (angle * i > Math.PI / 2 && angle * i <= Math.PI) {
                float dis = textPaint.measureText(titles[i]);
                canvas.drawText(titles[i], x - dis, y + fontHeight / 2, textPaint);
            } else if (angle * i > Math.PI && angle * i <= 3 * Math.PI / 2) {
                float dis = textPaint.measureText(titles[i]);
                canvas.drawText(titles[i], x - dis, y, textPaint);
            } else if (angle * i > 3 * Math.PI / 2 && angle * i <= Math.PI * 2) {
                canvas.drawText(titles[i], x, y, textPaint);
            }
        }
    }

    private void drawHexagon(Canvas canvas) {
        Path path = new Path();
        float r = radius / (count - 1);
        for (int i = 0; i < count; i++) {
            float R = r * i;
            path.reset();
            for (int j = 0; j < count; j++) {
                if (j == 0) {
                    path.moveTo(centerX + R, centerY);
                } else {
                    float x = (float) (centerX + R * Math.cos(angle * j));
                    float y = (float) (centerY + R * Math.sin(angle * j));
                    path.lineTo(x, y);
                }
            }
            path.close();
            canvas.drawPath(path, radarPaint);
        }
        for (int i = 0; i < count; i++) {
            path.reset();
            path.moveTo(centerX, centerY);
            float x = (float) (centerX + radius * Math.cos(angle * i));
            float y = (float) (centerY + radius * Math.sin(angle * i));
            path.lineTo(x ,y);
            canvas.drawPath(path, radarPaint);
        }
    }

    private void drawRegion(Canvas canvas) {
        Path path = new Path();
        valuePaint.setAlpha(200); // 透明度
        for (int i = 0; i < count; i++) { // 根据数据的个数
            double percent = data[i] / maxValue; // 获取数据百分比
            float x = (float) (centerX + radius * Math.cos(angle * i) * percent);
            float y = (float) (centerY + radius * Math.sin(angle * i) * percent);
            if (i == 0) {
                path.moveTo(x, centerY);
            } else {
                path.lineTo(x, y);
            }
            canvas.drawCircle(x, y, 5, valuePaint); // 绘制小圆点
        }

        valuePaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, valuePaint);

        // 绘制中间填充区域
        valuePaint.setAlpha(127); // 设置透明度
        valuePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawPath(path, valuePaint);
    }

    // 设置标题属性
    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    // 设置数值
    public void setData(double[] data) {
        this.data = data;
    }

    // 设置最大数值
    public void setMaxValue(float maxValue) {
        this.maxValue = maxValue;
    }

    // 设置蛛网画笔颜色
    public void setRadarPaintColor(int color) {
        radarPaint.setColor(color);
    }

    // 设置数据画笔颜色
    public void setValuePaintColor(int color) {
        valuePaint.setColor(color);
    }

    // 设置字体颜色
    public void setTextPaintColor(int color) {
        textPaint.setColor(color);
    }

    // 获取最大值
    public float getMaxValue() {
        return maxValue;
    }

    // 设置个数
    public void setCount(int i) {
        this.count = i;
    }

    // 转换
    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }

    private int sp2px(int sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, getResources().getDisplayMetrics());
    }
}
