package com.example.demo1.view.fang_qq_space;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.view.WindowManager;

/**
 * Created by yida on 2018/7/27.
 */

public class ShadeImageView extends android.support.v7.widget.AppCompatImageView {
    private ViewTreeObserver mViewTreeObserver = null;
    private ViewTreeObserver.OnScrollChangedListener mOnScrollChangedListener = null;
    private Bitmap mBitmap = null;
    private Context mContext;
    private int screenHeight = 0; // 屏幕高度

    private float scale = 1; // 图片将要的缩放比例, 用于画圆时中心点的实际位置
    private float oriYAbs = 0, oriXAbs = 0, oriRAbs = 0; // 记录比例放大后的圆的圆点和半径, 用于判断点击的位置

    public final static int CLICK_SPACE = 0; // 点击空白处
    public final static int CLICK_RANGE = 1; // 点击在圆上
    private int where_click = 0; // 用于返回点击在哪里

    public ShadeImageView(Context context) {
        super(context);
        this.mContext = context;
        this.setScaleType(ScaleType.CENTER_CROP);
    }

    public ShadeImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        this.setScaleType(ScaleType.CENTER_CROP);
    }

    @Override
    public void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);
    }

    @Override
    public void setImageResource(int resId) {
//        super.setImageResource(resId);
        Drawable drawable = ContextCompat.getDrawable(mContext, resId);
        setImageDrawable(drawable);
    }

    @Override
    public void setImageDrawable(@Nullable Drawable drawable) {
        super.setImageDrawable(drawable);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            mBitmap = drawableToBitmap(drawable); // 获取设置的图片
        }
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        screenHeight = dm.heightPixels;

        mViewTreeObserver = getViewTreeObserver();
        mOnScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                drawLocation();
            }
        };
        mViewTreeObserver.addOnScrollChangedListener(mOnScrollChangedListener);

        // view加载完成调用
        mViewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                drawLocation();
            }
        });

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (mBitmap != null) {
            scale = getScale(mBitmap, getMeasuredWidth(), getMeasuredHeight());
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                float x = event.getX();
                float y = event.getY();
                where_click = Math.sqrt((x - oriXAbs) * (x - oriXAbs) + (y - oriYAbs) * (y - oriYAbs)) > oriRAbs ? 0 : 1; // 确定点击的位置
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDetachedFromWindow() {
        mViewTreeObserver.removeOnScrollChangedListener(mOnScrollChangedListener);
        super.onDetachedFromWindow();
    }

    public int getWhere_click() {
        return where_click;
    }

    private void drawLocation() { // 根据位置进行画图
        if (mBitmap != null) {
            int[] location = new int[2];
            getLocationOnScreen(location); // 获取当前view左上点在屏幕中的坐标
            float locationY = location[1];
            // oriXAbs, oriYAbs 为图片按屏幕比例放大后的抽象原点, 实际原点需要按比例缩放
            oriXAbs = (mBitmap.getWidth() * scale - getMeasuredWidth()) / 2 + getMeasuredHeight() / 4; // 由于绘制的时候是根据画布来进行坐标计算
            oriYAbs = (mBitmap.getHeight() * scale - getMeasuredHeight()) / 2 + getMeasuredHeight() / 4;
            // orix, oriy实际在画布的原点
            int orix = (int) (oriXAbs / scale);
            int oriy = (int) (oriYAbs / scale);

            // 计算半径
            // 中心位置
            float centerY = screenHeight / 2;
            float startY = screenHeight / 2 - getMeasuredHeight();
            float startY2 = screenHeight / 2 + getMeasuredHeight();
            // 计算当控件滑到中心以下是, 圆全部覆盖后的半径.
            float endX = getMeasuredHeight() * 3 / 4;
            float endY = getMeasuredWidth() - getMeasuredHeight() / 4;
            float endR = (float) (Math.sqrt(endX * endX + endY * endY) / scale);

            if (locationY < centerY && locationY > startY) {
                // 开始绘画位置
                int r = (int) ((locationY - startY) * endR / (centerY - startY));
                oriRAbs = r * scale; // 记录控件里显示的半径范围, 用于实际点击
                Bitmap shadeBm = getShadeBitmap(mBitmap, r, orix, oriy);
                setImageBitmap(shadeBm);

            } else if (locationY <= startY) {
                Bitmap shadeBm = getShadeBitmap(mBitmap, 0, orix, oriy);
                oriRAbs = 0; // 记录控件里显示的半径范围, 用于实际点击
                setImageBitmap(shadeBm);
            }
        }

    }

    // 获取遮罩图片, r为遮罩圆的半径 , 上滑时, orix为原点的xy值, 这是相对于控件的
    public Bitmap getShadeBitmap(Bitmap bitmap, int r, int orix, int oriy) {
        Paint paint = new Paint(); // 笔
        paint.setAntiAlias(true); // 抗锯齿

        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output); // 创建一个画布, 以画布的坐标为标准
        Rect rect = new Rect(orix - r, oriy - r, r + orix, r + oriy); // 构造一个矩形  前面两个参数代表的是左上点
        RectF rectF = new RectF(rect);
        canvas.drawRoundRect(rectF, r, r, paint);
        canvas.save();

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN)); // 取两层绘制交集, 显示上层, 遮罩,  先画的在上面, 后画的在下面
        // 先画圆再设置
        Rect rect1 = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()); // 构造一个矩形
        canvas.drawBitmap(bitmap, rect1, rect1, paint); // 第一个Rect 代表要绘制的bitmap区域, 第二个 Rect 代表的是要将bitmap 绘制在画布的什么地方, 绘制的时候不会改变图片本身

        return output;
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        Bitmap bitmap = Bitmap.createBitmap(width, height, drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565); // 创建bitmap, 用于然后创建它的画布
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmap;
    }

    private float getScale(Bitmap bitmap, float vw, float vh) { // 获得图片centerCrop时的缩放比例
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float scale = 1;
        scale = vw / width > vh / height ? vw / width : vh / height;
        return scale;
    }
}
