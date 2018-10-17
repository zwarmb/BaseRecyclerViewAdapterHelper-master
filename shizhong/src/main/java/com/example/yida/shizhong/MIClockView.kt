package com.example.yida.shizhong

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import java.util.*

/**
 * Created by yida on 2018/9/3.
 */
class MIClockView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0): View(context, attrs, defStyleAttr) {

    // 画边缘的线 最外圈
    private val mPaintOutCircle = Paint(Paint.ANTI_ALIAS_FLAG)  // 用于绘制时抗锯齿, 初始化时直接属性去锯齿
    // 画外圈的文字(数字)
    private val mPaintOutText = Paint(Paint.ANTI_ALIAS_FLAG)
    // 画进度条,即分钟显示
    private val mPaintProgressBg = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mPaintProgress = Paint(Paint.ANTI_ALIAS_FLAG)
    // 画秒针三角
    private val mPaintTriangle = Paint(Paint.ANTI_ALIAS_FLAG)
    // 画时针
    private val mPaintHour = Paint(Paint.ANTI_ALIAS_FLAG)
    // 画分针
    private val mPaintMinute = Paint(Paint.ANTI_ALIAS_FLAG)
    // 画时针分针中间的小圆点
    private val mPaintBall = Paint(Paint.ANTI_ALIAS_FLAG)
    // 半透明的白色
    private val color_halfWhite: Int = Color.argb(255 - 180, 255, 255, 255)
    // 白色
    private val color_white: Int = Color.parseColor("#FFFFFF")
    // 宽高
    private var mWidth: Int = 0
    private var mHeight: Int = 0

    // 时钟中心的坐标
    private var mCenterX: Int = 0
    private var mCenterY: Int = 0

    private val paddingOut: Float = dp2px(25f)
    private val innerRadius: Float = dp2px(6f)
    private var mHourDegress: Int = 0
    private var mMinuteDegress: Int = 0
    private var mSecondMillsDegress: Float = 0f
    private var mSecondDegress: Int = 0

    // 时钟半径, 不包括padding值
    private var mRadius: Float = 0.toFloat()
    // 手指松开时时钟晃动的动画
    private var mShakeAnim: ValueAnimator? = null
    // 触摸时作用在Camera的矩阵
    private val mCameraMatrix: Matrix by lazy { Matrix() }
    // 照相机, 用于旋转时钟实现3D效果
    private val mCamera: Camera by lazy { Camera() }
    // camera 绕X轴旋转的角度
    private var mCameraRotateX: Float = 0f
    // camera 绕Y轴旋转的角度
    private var mCaneraRotateY: Float = 0f
    // camera 旋转的最大角度
    private val mMaxCameraRotate = 10f
    // 指针在x轴的位移
    private var mCanvasTranslateX: Float = 0f
    // 指针在Y轴的位移
    private var mCanvasTranslateY: Float = 0f
    // 指针的最大位移
    private var mMaxCanvasTranslate: Float = 0f

    // 画布
    private lateinit var mCanvas: Canvas


    init {
        mPaintOutCircle.color = color_halfWhite
        mPaintOutCircle.strokeWidth = dp2px(1f)
        mPaintOutCircle.style = Paint.Style.STROKE

        mPaintOutText.color = color_halfWhite
        mPaintOutText.strokeWidth = dp2px(1f)
        mPaintOutText.style = Paint.Style.STROKE
        mPaintOutText.textSize = sp2px(11f).toFloat()
        mPaintOutText.textAlign = Paint.Align.CENTER

        mPaintProgressBg.color = color_halfWhite
        mPaintProgressBg.strokeWidth = dp2px(2f)
        mPaintProgressBg.style = Paint.Style.STROKE

        mPaintProgress.color = color_halfWhite
        mPaintProgress.strokeWidth = dp2px(2f)
        mPaintProgress.style = Paint.Style.STROKE

        mPaintTriangle.color = color_white
        mPaintTriangle.style = Paint.Style.FILL

        mPaintHour.color = color_halfWhite
        mPaintHour.style = Paint.Style.FILL

        mPaintMinute.color = color_white
        mPaintMinute.strokeWidth = dp2px(3f)
        mPaintMinute.style = Paint.Style.STROKE
        mPaintMinute.strokeCap = Paint.Cap.ROUND

        mPaintBall.color = Color.parseColor("#4169E1")
        mPaintBall.style = Paint.Style.FILL
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = View.MeasureSpec.getSize(widthMeasureSpec)
        val height = View.MeasureSpec.getSize(heightMeasureSpec)
        // 设置为正方形
        val imageSize = if (width < height) width else height
        setMeasuredDimension(imageSize, imageSize)
    }

    /**
     * 把 canvas 画板平移到view的中心
     */
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w
        mHeight = h
        mCenterX = mWidth / 2
        mCenterY = mHeight / 2
    }

    override fun onDraw(canvas: Canvas?) {
        mCanvas = canvas!!
        // 画板平移到视图中心
        canvas.translate(mCenterX.toFloat(), mCenterY.toFloat())

        setCameraRotate()
        drawArcCircle(canvas)
        drawOutText(canvas)
        drawCalibrationLine(canvas)
        drawSecond(canvas)
        drawMinute(canvas)
        drawHour(canvas)
        drawBall(canvas)

    }

    /**
     * 绘制圆心小球
     */
    private fun drawBall(canvas: Canvas) {
        canvas.drawCircle(0f, 0f, innerRadius / 2, mPaintBall)
    }

    /**
     * 绘制时针
     */
    private fun drawHour(canvas: Canvas) {
        canvas.save()
        canvas.rotate(mHourDegress.toFloat())
        canvas.drawCircle(0f, 0f, innerRadius, mPaintTriangle)
        val path = Path()
        path.moveTo(-innerRadius / 2, 0f)
        path.lineTo(innerRadius / 2, 0f)
        path.lineTo(innerRadius / 6, -(width / 4).toFloat())
        path.lineTo(-innerRadius / 6, -(width / 4).toFloat())
        path.close()
        canvas.drawPath(path, mPaintHour)
        canvas.restore()
    }

    /**
     * 绘制分针
     */
    private fun drawMinute(canvas: Canvas) {
        canvas.save()
        canvas.rotate(mMinuteDegress.toFloat())
        canvas.drawLine(0f, 0f, 0f, -(width / 3).toFloat(), mPaintMinute)
        canvas.restore()
    }

    /**
     * 绘制秒针
     * 绘制三角形, 然后旋转画布实现秒针走动
     */
    private fun drawSecond(canvas: Canvas) {
        // 先绘制秒针的三角形
        canvas.save()
        canvas.rotate(mSecondMillsDegress)
        val path = Path()
        path.moveTo(0f, -width * 3f / 8 + dp2px(5f))
        path.lineTo(dp2px(8f), -width * 3f / 8 + dp2px(20f))
        path.lineTo(-dp2px(8f), -width * 3f / 8 + dp2px(20f))
        path.close()
        canvas.drawPath(path, mPaintTriangle)
        canvas.restore()

        // 绘制渐变刻度
        val min = Math.min(width, mHeight) / 2
        for (i in 0 until 90 step 2) {
            // 第一个参数设置透明度, 实现渐变效果, 从255 到 0
            canvas.save()
            mPaintProgress.setARGB((255 - 2.7 * i).toInt(), 255, 255, 255)

            // 这里先减去90°, 是为了旋转到开始角度, 因为开始角度是y轴的负方向
            canvas.rotate((mSecondDegress - 90 - i).toFloat())
            canvas.drawLine(min.toFloat() * 3 / 4, 0f, min * 3 / 4 + dp2px(10f), 0f, mPaintProgress)
            canvas.restore()
        }
    }

    /**
     * 绘制秒针的刻度
     * 每隔2°绘制一个刻度, 也就是180个刻度
     */
    private fun drawCalibrationLine(canvas: Canvas) {
        val min = Math.min(width, mHeight) / 2
        for (i in 0 until 360 step 2) {
            canvas.save()
            canvas.rotate(i.toFloat())
            canvas.drawLine(min.toFloat() * 3 / 4, 0f, min * 3 / 4 + dp2px(10f), 0f, mPaintProgressBg)
            canvas.restore()
        }
    }

    /**
     * 绘制外边缘4个文字
     * 3, 6, 9, 12
     */
    private fun drawOutText(canvas: Canvas) {
        val min = Math.min(width, mHeight)
        val textRadius = (min - paddingOut) / 2
        val fm = mPaintOutText.fontMetrics
        // 文字的高度
        val mTextHeight = Math.ceil((fm.leading - fm.ascent).toDouble()).toInt()
        canvas.drawText("3", textRadius, (mTextHeight / 2).toFloat(), mPaintOutText)
        canvas.drawText("6", 0f, textRadius + mTextHeight / 2, mPaintOutText)
        canvas.drawText("9", -textRadius, (mTextHeight / 2).toFloat(), mPaintOutText)
        canvas.drawText("12", 0f, - textRadius + mTextHeight / 2, mPaintOutText)

    }

    /**
     * 绘制最外层的弧度, 分成四个弧度, 假设每个弧度中间的间隔是6个弧度
     * 那么弧度的位置是 5-85, 95-175, 185-265, 275-355
     */
    private fun drawArcCircle(canvas: Canvas) {
        val min = Math.min(width, mHeight)
        val rect = RectF(- (min - paddingOut) / 2, - (min - paddingOut) / 2, (min - paddingOut) / 2, (min - paddingOut) / 2)

        canvas.drawArc(rect, 5f, 80f, false, mPaintOutCircle)
        canvas.drawArc(rect, 95f, 80f, false, mPaintOutCircle)
        canvas.drawArc(rect, 185f, 80f, false, mPaintOutCircle)
        canvas.drawArc(rect, 275f, 80f, false, mPaintOutCircle)

    }

    // 指针转动的方法
    private fun startTick() {
        // 一秒钟刷新一次
        postDelayed(mRunnable, 150)
    }

    private val mRunnable = Runnable {
        calculateDegree()
        invalidate()
        startTick()
    }

    /**
     * 让时间走起来
     */
    private fun calculateDegree() {
        val mCalendar = Calendar.getInstance()
        mCalendar.timeInMillis = System.currentTimeMillis()
        val minute = mCalendar.get(Calendar.MINUTE)
        val secondMills = mCalendar.get(Calendar.MILLISECOND)
        val second = mCalendar.get(Calendar.SECOND)
        val hour = mCalendar.get(Calendar.HOUR)
        mHourDegress = hour * 30
        mMinuteDegress = minute * 6
        mSecondMillsDegress = second * 6 + secondMills * 0.006f
        mSecondDegress = second * 6
        val mills = secondMills * 0.006f
        // 因为是每2°旋转一个刻度, 所以这里要根据毫秒值来进行计算
        when(mills) {
            in 2 until 4 -> {
                mSecondDegress += 2
            }
            in 4 until 6 -> {
                mSecondDegress += 4
            }
        }
    }


    private fun setCameraRotate() {
        mCameraMatrix.reset()
        mCamera.save()
        mCamera.rotateX(mCameraRotateX) // 绕x轴旋转角度
        mCamera.rotateY(mCaneraRotateY) // 绕y轴旋转角度
        mCamera.getMatrix(mCameraMatrix) // 相关属性设置到matrix中
        mCamera.restore()
        mCanvas.concat(mCameraMatrix) // matrix与canvas相关联
    }


//    override fun onTouchEvent(event: MotionEvent?): Boolean {
//        when (event!!.action) {
//            MotionEvent.ACTION_DOWN -> {
//                mShakeAnim?.let {
//                    if (it.isRunning) {
//                        it.cancel()
//                    }
//                }
//                getCameraRotate(event)
//                getCanvasTranslate(event)
//            }
//            MotionEvent.ACTION_MOVE -> {
//                // 根据手指坐标计算camera应该旋转的角度
//                getCameraRotate(event)
//                getCanvasTranslate(event)
//
//            }
//            MotionEvent.ACTION_UP -> {
//                // 松开手指, 时钟复原并伴随摇晃动画
//                startShakeAnim()
//            }
//        }
//        return true
//    }

    /**
     * 松手时时钟晃动的动画
     */
    private fun startShakeAnim() {

    }

    private fun getCameraRotate(event: MotionEvent) {
        val rotateX = -(event.y - height / 2)
        val rotateY = event.x - width / 2
        // 求出此时旋转的大小与半径之比
        val percentArr = getPercent(rotateX, rotateY)
        // 最终旋转的大小按比例均匀的改变
        mCameraRotateX = percentArr[0] * mMaxCameraRotate
        mCaneraRotateY = percentArr[1] * mMaxCameraRotate
    }

    /**
     * 当拨动时钟是, 会发现时针, 分针, 秒针有一个较小的偏移量, 形成近大远小的立体偏移效果
     * 一开始我打算使用 matrix 和 camera 的 mCamera.translate(x, y, z) 方法改变z 的值
     */
    private fun getCanvasTranslate(event: MotionEvent) {
        val translateX = event.x - width / 2
        val translateY = event.y - height / 2
        // 求出此时位移的大小与半径之比
        val percentArr = getPercent(translateX, translateY)
        // 最终位移的大小按比例均匀改变
        mCanvasTranslateX = percentArr[0] * mMaxCanvasTranslate
        mCanvasTranslateY = percentArr[1] * mMaxCanvasTranslate
    }

    private fun getPercent(translateX: Float, translateY: Float): FloatArray {
        val percentArr = FloatArray(2)
        var percentX = x / mRadius
        var percentY = y / mRadius
        if (percentX > 1) {
            percentX = 1f
        } else if (percentX < -1) {
            percentX = -1f
        }
        if (percentY > 1) {
            percentY = 1f
        } else if (percentY < -1) {
            percentY = -1f
        }
        percentArr[0] = percentX
        percentArr[1] = percentY
        return percentArr
    }


    /**
     * 调用时机: onAttachedToWindow 是在第一次onDraw前调用的, 只调用一次
     */
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        startTick()
    }

    /**
     * 调用时机: 我们销毁View的时候, 我们写的这个view不再显示
     */
    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        removeCallbacks(mRunnable)
    }

    /**
     * dp 转 px
      */
    fun View.dp2px(dipValue: Float): Float {
        return (dipValue * this.resources.displayMetrics.density + 0.5f)
    }

    /**
     * px 转 dp
     */
    fun View.px2dp(pxValue: Float): Float {
        return (pxValue / this.resources.displayMetrics.density + 0.5f)
    }

    /**
     * sp 转 px
     */
    fun View.sp2px(spValue: Float): Float{
        return (spValue * this.resources.displayMetrics.scaledDensity + 0.5f)
    }

}