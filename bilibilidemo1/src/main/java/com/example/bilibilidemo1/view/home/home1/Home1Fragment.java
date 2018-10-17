package com.example.bilibilidemo1.view.home.home1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.bilibilidemo1.R;
import com.example.bilibilidemo1.base.BaseFragment;
import com.example.bilibilidemo1.dialog.DownloadDialog;
import com.example.bilibilidemo1.utils.StartBrotherEvent;
import com.example.bilibilidemo1.view.home.home2.Home2Fragment;
import com.example.bilibilidemo1.widget.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yida on 2018/2/3.
 */

public class Home1Fragment extends BaseFragment {

//    @BindView(R.id.rl_home1)
//    RecyclerView mRlHome1;
    @BindView(R.id.banner_home)
    Banner mBannerHome;
//    @BindView(R.id.srl_home1)
//    SwipeRefreshLayout mSrlHome1;
    @BindView(R.id.btn_download)
    Button mBtnDownload;

    private void initImages() {
        mList.add("https://camo.githubusercontent.com/a8a5a87e676880aa64626cbea3fba78853f1be31/687474703a2f2f6f63656835316b6b752e626b742e636c6f7564646e2e636f6d2f62616e6e65725f6578616d706c65352e706e67");
        mList.add("https://camo.githubusercontent.com/44eeb7b3a25f1d34aa6d2ff7dd62c8f07af3b560/687474703a2f2f6f63656835316b6b752e626b742e636c6f7564646e2e636f6d2f62616e6e65725f6578616d706c65342e706e67");
        mList.add("https://camo.githubusercontent.com/fa591b0ea9768e3722fcd690cc97f987867573d9/687474703a2f2f6f63656835316b6b752e626b742e636c6f7564646e2e636f6d2f62616e6e65725f6578616d706c65332e706e67");
        mList.add("https://camo.githubusercontent.com/078504c5723b59c8ebe787a059853fa1a603a381/687474703a2f2f6f63656835316b6b752e626b742e636c6f7564646e2e636f6d2f62616e6e65725f6578616d706c65322e706e67");
        mList.add("https://camo.githubusercontent.com/72e7034bb9f3ed5e4d28c25a94adb22bb9e7cb98/687474703a2f2f6f63656835316b6b752e626b742e636c6f7564646e2e636f6d2f62616e6e65725f6578616d706c65312e706e67");
    }

    public static Home1Fragment newInstance() {
        return new Home1Fragment();
    }


    private List<String> mList = new ArrayList<>();
    private boolean isRefresh = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_yi, container, false);
        ButterKnife.bind(this, view);
        initImages();
        initBanner(view);

//        initRefresh();
        return view;
    }

//    private void initRefresh() {
//        Log.e("1111", "refresh");
//        mSrlHome1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                Log.e("11", "shuaxinzhong");
//                // 数据请求
//                offRefresh();
//            }
//        });
//    }
//
//    // 关掉刷新动画
//    private void offRefresh() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(4000);
//                    isRefresh = true;
//                    mSrlHome1.setRefreshing(false);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }

    private void initBanner(View view) {
        Banner banner = view.findViewById(R.id.banner_home);
        // 设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        // 设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(mList);
        // 设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        // 设置标题集合(需要样式设置为有显示title)
//        banner.setBannerTitles()
        // 设置自动轮播(默认为true)
        banner.isAutoPlay(true);
        // 设置轮播时长
        banner.setDelayTime(1500);
        // 设置指示器位置
        banner.setIndicatorGravity(BannerConfig.RIGHT);

        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(getContext(), "点击了第" + (position + 1) + "张图片", Toast.LENGTH_SHORT).show();
            }
        });

        // 最后调用
        banner.start();
    }


    @OnClick(R.id.btn_download)
    public void onClick() {
        new DownloadDialog.bundil(getContext()).setDownUrl("https://qd.myapp.com/myapp/qqteam/AndroidQQi/qq_5.3.1.6100_android_r24769_GuanWang_537054438_release.apk").build().show();
    }

    @OnClick(R.id.btn_1)
    public void onClick1() {
        EventBus.getDefault().post(new StartBrotherEvent(Home2Fragment.newInstance()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
