package com.example.bilibilidemo1.zaxiang;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.bilibilidemo1.utils.StartBrotherEvent;
import com.example.bilibilidemo1.view.home.home4.Home4ImageFragment;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by yida on 2018/3/2.
 */

public class MJavascriptInterface {

    private Context mContext;
    private String[] iamgeUrl;

    public MJavascriptInterface(Context context, String[] iamgeUrl) {
        mContext = context;
        this.iamgeUrl = iamgeUrl;
    }
    @android.webkit.JavascriptInterface
    public void onShowImage(String url) {
        Intent intent = new Intent();
        intent.putExtra("imageUrl", url);
        intent.setClass(mContext, Home4ImageFragment.class);
        EventBus.getDefault().post(new StartBrotherEvent(Home4ImageFragment.newInstance(url, iamgeUrl)));
        for (int i = 0; i < iamgeUrl.length; i++) {
            Log.e("所有图片地址", iamgeUrl[i].toString());
        }
    }
}
