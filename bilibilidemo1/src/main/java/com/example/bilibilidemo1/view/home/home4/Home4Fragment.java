package com.example.bilibilidemo1.view.home.home4;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

import com.bumptech.glide.Glide;
import com.example.bilibilidemo1.R;
import com.example.bilibilidemo1.base.SimpleFragment;
import com.example.bilibilidemo1.utils.StringUtils;
import com.example.bilibilidemo1.zaxiang.MJavascriptInterface;
import com.example.bilibilidemo1.zaxiang.MyWebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by yida on 2018/2/3.
 */

public class Home4Fragment extends SimpleFragment<Home4Presenter> implements Home4Contract.View {

    @BindView(R.id.wv_home_4)
    WebView mWvHome4;
    Unbinder unbinder;

    private String[] imageUrls;

    public static Home4Fragment newInstance() {
        return new Home4Fragment();
    }


    @SuppressLint("JavascriptInterface")
    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this, view);

        Log.e("11", "第四个页面, 点击图片放大");
        mWvHome4.getSettings().setJavaScriptEnabled(true);
        mWvHome4.getSettings().setAppCacheEnabled(true);
        mWvHome4.getSettings().setDatabaseEnabled(true);
        mWvHome4.getSettings().setDomStorageEnabled(true);
        mWvHome4.getSettings().setBlockNetworkImage(true);

        // 防止中文乱码
        mWvHome4.getSettings().setDefaultTextEncodingName("UTF-8");

        mWvHome4.loadUrl("https://www.jianshu.com/p/976c86fa72bc");
        imageUrls = StringUtils.returnImageUrlsFormHtml("https://www.jianshu.com/p/976c86fa72bc");
        mWvHome4.addJavascriptInterface(new MJavascriptInterface(getContext(), imageUrls), "imagelistener");
        mWvHome4.setWebViewClient(new MyWebViewClient());
//        mWvHome4.setWebViewClient(new WebViewClient() {
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                super.onPageFinished(view, url);
//                mWvHome4.loadUrl("javascript:(function(){" +
//                        "var objs = document.getElementsByTagName(\"img\"); " +
//                        "for(var i=0;i<objs.length;i++)  " +
//                        "{"
//                        + "    objs[i].onclick=function()  " +
//                        "    {  "
//                        + "        window.imagelistener.openImage(this.src);  " +//通过js代码找到标签为img的代码块，设置点击的监听方法与本地的openImage方法进行连接
//                        "    }  " +
//                        "}" +
//                        "})()");
//            }
//        });
        mWvHome4.addJavascriptInterface(new MJavascriptInterface(getContext(), imageUrls), "imagelistener");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_four;
    }

    @Override
    public void onDestroyView() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Glide.get(getContext()).clearDiskCache();   // 开一个线程清理磁盘缓存
            }
        }).start();
        Glide.get(getContext()).clearMemory();   // 清理内存缓存
        super.onDestroyView();
        unbinder.unbind();
    }
}
