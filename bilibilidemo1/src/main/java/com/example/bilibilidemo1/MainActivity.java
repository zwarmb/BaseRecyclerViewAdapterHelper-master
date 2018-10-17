package com.example.bilibilidemo1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;

public class MainActivity extends SupportActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_NoActionBar);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);

        }

//        if (Build.VERSION.SDK_INT >= 23) {
//            String[] mPermissionList = new String[]{Manifest.permission.PACKAGE_USAGE_STATS, Manifest.permission.REQUEST_INSTALL_PACKAGES, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_LOGS, Manifest.permission.SET_DEBUG_APP};
////            RxPermissions rxPermissions = new RxPermissions(this);
////            rxPermissions.request(mPermissionList).subscribe(granted -> {
////                if (savedInstanceState == null) {
////                    launchRootFragment(null);
////                }
////            });
//        }

        if (savedInstanceState == null) {
            loadRootFragment(R.id.fragment_container, MainFragment.newInstance());
        }
        setFragmentAnimator(new DefaultHorizontalAnimator());

        //        // eventBus没有注册时注册
//        if (!EventBus.getDefault().isRegistered(this)) {
//            EventBus.getDefault().register(this);
//        }

        initNavigationView();

    }


    public boolean isDeleteIcon() {
        return isDeleteIcon();
    }

    private void initNavigationView() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        // eventbus存在就解除掉
//        if (EventBus.getDefault().isRegistered(this)) {
//            EventBus.getDefault().unregister(this);
//        }
    }
}
