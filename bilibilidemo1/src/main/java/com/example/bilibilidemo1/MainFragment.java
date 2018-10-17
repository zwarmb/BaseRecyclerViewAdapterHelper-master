package com.example.bilibilidemo1;


import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.bilibilidemo1.base.BaseFragment;
import com.example.bilibilidemo1.utils.StartBrotherEvent;
import com.example.bilibilidemo1.view.four.FourFragment;
import com.example.bilibilidemo1.view.home.home.HomeFragment;
import com.example.bilibilidemo1.view.one.OneFragment;
import com.example.bilibilidemo1.view.three.ThreeFragment;
import com.example.bilibilidemo1.view.two.TwoFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment {

    @BindView(R.id.bottomBar)
    BottomBar mBottomBar;

    @BindView(R.id.contentContainer)
    FrameLayout mMainFragment;

    public static MainFragment newInstance() {
        Bundle bundle = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    private BaseFragment[] mFragments = new BaseFragment[5];
    private int mSelectPosition, mCurrentPosition = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, @NonNull ViewGroup container,
                             @NonNull Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragments_main, container, false);

        ButterKnife.bind(this, view);
        LayoutTransition transition = new LayoutTransition();
        ObjectAnimator animIn = ObjectAnimator.ofFloat(null, "translationY", 100, 0);
        // 设置动画时长
        animIn.setDuration(1);
        transition.setAnimator(LayoutTransition.APPEARING, animIn);
        ObjectAnimator animOut = ObjectAnimator.ofFloat(null, "alpha", 1, 0);

        animOut.setDuration(500);
        transition.setAnimator(LayoutTransition.DISAPPEARING, animOut);

        if (savedInstanceState == null) {
            Log.e("11", "fragment保存为空");
            mFragments[0] = HomeFragment.newInstance();
            mFragments[1] = OneFragment.newInstance();
            mFragments[2] = TwoFragment.newInstance();
            mFragments[3] = ThreeFragment.newInstance();
            mFragments[4] = FourFragment.newInstance();

            loadMultipleRootFragment(R.id.contentContainer, 0,
                    mFragments[0],
                    mFragments[1],
                    mFragments[2],
                    mFragments[3],
                    mFragments[4]);
        } else {
            // fragment 不会反复创建
            mFragments[0] = findChildFragment(HomeFragment.class);
            mFragments[1] = findChildFragment(OneFragment.class);
            mFragments[2] = findChildFragment(TwoFragment.class);
            mFragments[3] = findChildFragment(ThreeFragment.class);
            mFragments[4] = findChildFragment(FourFragment.class);
        }
        EventBus.getDefault().register(this);
        mBottomBar.getCurrentTab().setSelected(true);
        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {

            @Override
            public void onTabSelected(int tabId) {
                switch (tabId) {
                    case R.id.tab_home:
                        mSelectPosition = 0;
                        Log.e("11", "home");
                        showHideFragment(mFragments[mSelectPosition], mFragments[mCurrentPosition]);
                        mCurrentPosition = 0;
                        break;
                    case R.id.tab_one:
                        mSelectPosition = 1;
                        Log.e("11", "one");
                        showHideFragment(mFragments[mSelectPosition], mFragments[mCurrentPosition]);
                        mCurrentPosition = 1;
                        break;
                    case R.id.tab_two:
                        mSelectPosition = 2;
                        Log.e("11", "two");
                        showHideFragment(mFragments[mSelectPosition], mFragments[mCurrentPosition]);
                        mCurrentPosition = 2;
                        break;
                    case R.id.tab_three:
                        mSelectPosition = 3;
                        Log.e("11", "three");
                        showHideFragment(mFragments[mSelectPosition], mFragments[mCurrentPosition]);
                        mCurrentPosition = 3;
                        break;
                    case R.id.tab_four:
                        mSelectPosition = 4;
                        Log.e("11", "four");
                        showHideFragment(mFragments[mSelectPosition], mFragments[mCurrentPosition]);
                        mCurrentPosition = 4;
                        break;
                }
            }
        });

        return view;
    }

    @Subscribe
    public void startBrother(StartBrotherEvent startBrotherEvent) {
        start(startBrotherEvent.mISupportFragment);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
