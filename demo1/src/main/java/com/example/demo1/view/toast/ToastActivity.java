package com.example.demo1.view.toast;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo1.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by yida on 2019/1/8.
 */
public class ToastActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);


        TextView t1 = findViewById(R.id.text_time1);
        TextView t2 = findViewById(R.id.text_time2);
        TextView t3 = findViewById(R.id.text_time3);
        TextView t4 = findViewById(R.id.text_time4);
        TextView t5 = findViewById(R.id.text_time5);
        TextView t05 = findViewById(R.id.text_time05);



        t1.setOnClickListener(this);
        t2.setOnClickListener(this);
        t3.setOnClickListener(this);
        t4.setOnClickListener(this);
        t5.setOnClickListener(this);
        t05.setOnClickListener(this);

    }




    public void showToast(Toast toast, int time) {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                toast.show();
            }
        }, 0, 2000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                toast.cancel();
                timer.cancel();
            }
        }, time);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.text_time1) {
            Toast toast = Toast.makeText(getApplicationContext(), "显示toast", Toast.LENGTH_SHORT);
            showToast(toast, 1000);
        } else if (v.getId() == R.id.text_time2) {
            Toast toast = Toast.makeText(getApplicationContext(), "显示toast", Toast.LENGTH_SHORT);
            showToast(toast, 2000);
        } else if (v.getId() == R.id.text_time3) {
            Toast toast = Toast.makeText(getApplicationContext(), "显示toast", Toast.LENGTH_SHORT);
            showToast(toast, 3000);
        } else if (v.getId() == R.id.text_time4) {
            Toast toast = Toast.makeText(getApplicationContext(), "显示toast", Toast.LENGTH_SHORT);
            showToast(toast, 4000);
        } else if (v.getId() == R.id.text_time5) {
            Toast toast = Toast.makeText(getApplicationContext(), "显示toast", Toast.LENGTH_SHORT);
            showToast(toast, 5000);
        } else if (v.getId() == R.id.text_time05) {
            Toast toast = Toast.makeText(getApplicationContext(), "显示toast", Toast.LENGTH_SHORT);
            showToast(toast, 500);
        }
    }
}
