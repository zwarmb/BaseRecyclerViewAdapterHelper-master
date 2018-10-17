package com.example.demo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.demo2.coordinatorlayout.CoordinatorLayoutActivity;
import com.example.demo2.glide.GlideActivity;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btn_time)
    Button mBtnTime;
    @BindView(R.id.button)
    Button mButton;
    @BindView(R.id.button2)
    Button mButton2;
    private Disposable mDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        initView();

    }

    private void initView() {

        mButton.setOnClickListener(this);
        mButton2.setOnClickListener(this);
    }

    @OnClick(R.id.btn_time)
    public void onBtnClick() {
        // 点击后不可再点击
        mBtnTime.setEnabled(false);
        // 从0开始发射6个数字; 0-5依次分别输出, 延时0s执行, 每1s发射一次
        mDisposable = Flowable.intervalRange(1, 60, 0, 1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        mBtnTime.setText("重新获取" + (60 - aLong));
                    }
                })
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        mBtnTime.setEnabled(true);
                        mBtnTime.setText("获取验证码");
                    }
                })
                .subscribe();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDisposable != null) {
            mDisposable.dispose();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent(getApplicationContext(), CoordinatorLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                Log.e("TAG", "点击了glide");
                Intent intent1 = new Intent(getApplicationContext(), GlideActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
