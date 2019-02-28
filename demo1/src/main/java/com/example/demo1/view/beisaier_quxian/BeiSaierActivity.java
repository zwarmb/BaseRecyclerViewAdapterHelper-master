package com.example.demo1.view.beisaier_quxian;

import android.os.Bundle;
import android.os.VibrationEffect;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo1.R;
import com.wx.android.common.util.VibratorUtils;

/**
 * Created by yida on 2019/1/7.
 */
public class BeiSaierActivity extends AppCompatActivity {

    private BeiSaierView mBeiSaierView;
    private SeekBar mSeekBar;
    private TextView mTextView;
    private Switch mLoop, mTangent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beisaier);

        mBeiSaierView = findViewById(R.id.bezier);
        mTextView = findViewById(R.id.textview);
        mSeekBar = findViewById(R.id.seekbar);
        mLoop = findViewById(R.id.loop);
        mTangent = findViewById(R.id.tangent);

        mTextView.setText(mBeiSaierView.getOrderStr() + "阶贝塞尔曲线");

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress == 0) {
                    progress = 1;
                }
                mBeiSaierView.setRate(progress * 2);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mLoop.setChecked(false);
        mTangent.setChecked(true);
        mLoop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mBeiSaierView.setLoop(isChecked);
            }
        });
        mTangent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mBeiSaierView.setTangent(isChecked);
            }
        });
    }

    // com.wx.android.common:common:1.0.1


    public void start(View view) {
        mBeiSaierView.start();
//        VibratorUtils.vibrate(this, 500);
    }

    public void stop(View view) {
        mBeiSaierView.stop();
//        VibratorUtils.vibrate(this, 500);
    }

    public void add(View view) {
//        mBeiSaierView.addPoint();
//        mTextView.setText(mBeiSaierView.getOrderStr() + "阶贝塞尔曲线");



        if (mBeiSaierView.addPoint()) {
            mTextView.setText(mBeiSaierView.getOrderStr() + "阶贝塞尔曲线");
//            VibratorUtils.vibrate(this, 300);
        } else {
            Toast.makeText(getApplicationContext(), "Add point failed", Toast.LENGTH_SHORT).show();
        }
    }

    public void del(View view) {
//        mBeiSaierView.delPoint();
//        mTextView.setText(mBeiSaierView.getOrderStr() + "阶贝塞尔曲线");

        if (mBeiSaierView.delPoint()) {
            mTextView.setText(mBeiSaierView.getOrderStr() + "阶贝塞尔曲线");
//            VibratorUtils.vibrate(this, 300);
        } else {
            Toast.makeText(getApplicationContext(), "Delete point failed.", Toast.LENGTH_SHORT).show();
        }
    }
}
