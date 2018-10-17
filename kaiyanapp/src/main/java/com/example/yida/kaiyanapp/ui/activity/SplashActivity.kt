package com.example.yida.kaiyanapp.ui.activity

import android.Manifest
import android.content.Intent
import android.graphics.Typeface
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import com.example.yida.kaiyanapp.MainActivity
import com.example.yida.kaiyanapp.MyApplication
import com.example.yida.kaiyanapp.R
import com.example.yida.kaiyanapp.base.BaseActivity
import com.example.yida.kaiyanapp.utils.APPUtils
import com.example.yida.kaiyanapp.utils.showToast
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_splash.*
import me.weyye.hipermission.HiPermission
import me.weyye.hipermission.PermissionCallback
import me.weyye.hipermission.PermissionItem

/**
 * Created by yida on 2018/8/29.
 */
class SplashActivity: BaseActivity() {

    private var textTypeface: Typeface?= null
    private var descTypeFace: Typeface?= null
    private var alphaAnimation: AlphaAnimation?= null

    init {
        textTypeface = Typeface.createFromAsset(MyApplication.context.assets, "fonts/Lobster-1.4.otf")
        descTypeFace = Typeface.createFromAsset(MyApplication.context.assets, "fonts/FZLanTingHeiS-L-GB-Regular.TTF")
    }

    override fun initView() {
        tv_app_name.typeface = textTypeface
        tv_splash_desc.typeface = descTypeFace
        tv_version_name.text = "V ${APPUtils.getVerName(MyApplication.context)}"

        // 渐变展示启动屏
        alphaAnimation = AlphaAnimation(0.3f, 1.0f)
        alphaAnimation?.duration = 2000 // 时间
        alphaAnimation?.setAnimationListener(object: Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                redirectTo()
            }

            override fun onAnimationStart(animation: Animation?) {

            }
        })

    }

    override fun initData() {
    }

    override fun layoutId(): Int {
        return R.layout.activity_splash
    }

    override fun start() {
    }

    fun redirectTo() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    /**
     * 6.0以下版本(系统自动申请) 不会弹窗
     * 有些厂商修改了6.0系统申请机制, 他们修改成系统自动申请权限了
     */
    private fun checkPermission() {
        val permissionItems = ArrayList<PermissionItem>()
        permissionItems.add(PermissionItem(android.Manifest.permission.READ_PHONE_STATE, "手机状态", R.drawable.permission_ic_phone))
        permissionItems.add(PermissionItem(Manifest.permission.WRITE_EXTERNAL_STORAGE, "存储空间", R.drawable.permission_ic_storage))

        HiPermission.create(this)
                .title("亲爱的张伟")
                .msg("为了能够正常使用, 请开启这些权限吧! ")
                .permissions(permissionItems)
                .style(R.style.PermissionDefaultBlueStyle)
                .animStyle(R.style.PermissionAnimScale)
                .checkMutiPermission(object : PermissionCallback {
                    override fun onFinish() {
                        showToast("初始化完毕!")
                        layout_splash.startAnimation(alphaAnimation)
                    }

                    override fun onDeny(permission: String?, position: Int) {
                        Logger.i("permission_onDeny")
                    }

                    override fun onGuarantee(permission: String?, position: Int) {
                        Logger.i("permission_onGuarantee")
                    }

                    override fun onClose() {
                        Logger.i( "permission_onClose")
                        showToast("用户关闭了权限")
                    }

                })

    }
}