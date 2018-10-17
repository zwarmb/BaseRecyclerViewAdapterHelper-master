package com.example.bilibilidemo1.zidingyi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.bilibilidemo1.bean.PaintDataBean;

import java.util.List;

/**
 * Created by yida on 2018/4/16.
 */

public class MyText extends View {

    // 颜色表 此处定义是ARGB, 带有alpha通道, 也就是透明度
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};

    // 饼状图初始绘制角度
    private float mStartAngle = 0;

    // 数据
    private List<PaintDataBean> mDataBeans;

    // 宽高
    private int mWidth, mHeight;

    // 创建一个画笔
    private Paint mPaint;


    public MyText(Context context) {
        this(context, null);
        initPaint();

    }

    public MyText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
//        PaintDataBean paintDataBean = new PaintDataBean("zz", 5);
//        List<PaintDataBean> list = new ArrayList<>();
//        list.add(new PaintDataBean("zz", 5));
//        list.add(new PaintDataBean("qq", 4));
//        list.add(new PaintDataBean("ww", 6));
//        list.add(new PaintDataBean("ee", 3));
//        list.add(new PaintDataBean("rr", 1));
//        list.add(new PaintDataBean("tt", 8));
//        list.add(new PaintDataBean("yy", 7));
//        initData(list);
    }

    private void initPaint() {
        // 初始化画笔
        mPaint = new Paint();

        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(5f);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mHeight = h;
        mWidth = w;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mDataBeans == null) {
            return;
        }
        float currentStartAngle = mStartAngle;                      // 当前的起始角度
        canvas.translate(mWidth / 2, mHeight / 2);        // 移动画布坐标原点
        float r = (float) (Math.min(mWidth, mHeight) / 2 * 0.8);    // 饼状图圆半径
        RectF rectF = new RectF(-r, -r, r, r);                      // 由于画布坐标原点改变, 所以圆的左上位置为负

        for (int i = 0; i < mDataBeans.size(); i++) {
            PaintDataBean paintDataBean = mDataBeans.get(i);
            mPaint.setColor(paintDataBean.getColor());
            canvas.drawArc(rectF, currentStartAngle, paintDataBean.getAngle(), true, mPaint);
            // 累计到下一次时初始化的角度
            currentStartAngle += paintDataBean.getAngle();
        }
    }

    // 设置起始角度
    public void setStartAngle(int startAngle) {
        this.mStartAngle = startAngle;
        invalidate(); // 刷新
    }

    // 设置数据
    public void staData(List<PaintDataBean> dataBeanList) {
        this.mDataBeans = dataBeanList;
        initData(dataBeanList);
        invalidate(); // 刷新
    }

    // 初始化数据
    private void initData(List<PaintDataBean> dataBeanList) {
//        for (int i = 0; i < dataBeanList.size(); i++) {
//            Log.e("qqqq    ", dataBeanList.get(i).getName());
//        }

        if (dataBeanList == null && dataBeanList.size() == 0) {
            return;
        }
        float sumValue = 0; // 累计的值
        float sumAngle = 0; // 累计的角度
        for (int i = 0; i < dataBeanList.size(); i++) {
            PaintDataBean paintDataBean = dataBeanList.get(i);

            sumValue += paintDataBean.getValue();  // 计算数值和

            int j = i % mColors.length;            // 设置颜色
            paintDataBean.setColor(mColors[j]);

            float percentage = paintDataBean.getValue() / sumValue; // 百分比
            float angle = percentage * 360;                         // 对应的角度
            paintDataBean.setPercentage(percentage);                // 记录百分比
            paintDataBean.setAngle(angle);                          // 记录角度大小
            sumAngle += angle;                                      // 累计角度

        }
    }
}
