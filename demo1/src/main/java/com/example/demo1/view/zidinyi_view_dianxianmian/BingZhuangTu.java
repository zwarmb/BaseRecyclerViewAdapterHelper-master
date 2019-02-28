package com.example.demo1.view.zidinyi_view_dianxianmian;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by yida on 2018/12/25.
 *
 *
 * 一个饼状图
 */
public class BingZhuangTu extends View {

    // 颜色表 (注意: 此处定义颜色使用的是ARGB，带Alpha通道的)
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    // 饼状图初始绘制角度
    private float mStartAngle = 0;
    // 数据
    private ArrayList<PieData> mList;
    // 宽高
    private int mWidth, mHeight;
    // 画笔
    private Paint mPaint = new Paint();



    public BingZhuangTu(Context context) {
        super(context, null);
    }

    public BingZhuangTu(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init();

    }

    // 初始化画笔配置
    private void init() {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
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
        if (null == mList) {
            return;
        }
        float currentStartAngle = mStartAngle;                      // 当前起始角度
        canvas.translate(mWidth / 2, mHeight / 2);          // 将画布坐标原点移动到中心位置
        float r = (float) (Math.min(mWidth, mHeight) / 2 * 0.8);       // 饼状图半径
        RectF rectF = new RectF(-r, -r, r, r);                          // 饼状图绘制区域

        for (int i = 0; i < mList.size(); i++) {
            PieData pie = mList.get(i);
            mPaint.setColor(pie.getColor());
            canvas.drawArc(rectF, currentStartAngle, pie.getAndle(), true, mPaint);
            currentStartAngle += pie.getAndle();
        }
    }

    // 设置起始角度
    public void setStartAngle(int mStartAngle) {
        this.mStartAngle = mStartAngle;
        // 刷新
        invalidate();
    }

    // 设置数据
    public void setData(ArrayList<PieData> mdata) {
        this.mList = mdata;
        initData(mList);
        invalidate();
    }

    // 初始化数据
    private void initData(ArrayList<PieData> mData) {
        if (null == mData || mData.size() == 0) {
            return;
        }
        float sumValue = 0;
        for (int i = 0; i < mData.size(); i++) {
            PieData pieData = mData.get(i);
            sumValue += pieData.getValue();     // 计算数值和

            int j = i % mColors.length;
            pieData.setColor(mColors[j]);       // 设置颜色
        }
        float sumAngle = 0;
        for (int i = 0; i < mData.size(); i++) {
            PieData pieData = mData.get(i);
            float percentage = pieData.getValue() / sumValue;   // 百分比
            float angle = percentage * 360;                     // 对应的角度

            pieData.setPercentage(percentage);                  // 记录百分比
            pieData.setAndle(angle);                            // 记录角度大小
            sumAngle += angle;

            Log.e("angle", "" + pieData.getAndle());
        }
    }

}
