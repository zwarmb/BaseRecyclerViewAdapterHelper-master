package com.example.sdkdemo1;

import android.Manifest;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.moge.sdk.MGSDKManager;
import com.moge.sdk.listener.LoginResultParam;
import com.moge.sdk.listener.OnExitCallback;
import com.moge.sdk.listener.OnLoginCallback;
import com.moge.sdk.listener.OnPayCallback;
import com.moge.sdk.listener.PayParam;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private String mLog = "sdktest";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        initView();



        Button login = findViewById(R.id.btn_login_demo);
        Button charge = findViewById(R.id.btn_charge_demo);
        Button exit = findViewById(R.id.btn_exit_demo);
        Button logout = findViewById(R.id.btn_logout);
        Button update_user = findViewById(R.id.btn_update_roleinfo);

        final EditText money = findViewById(R.id.et_money);


        /**
         * 登录
         */
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MGSDKManager.getInstance(MainActivity.this).login(MainActivity.this, true, new OnLoginCallback() {
                    @Override
                    public void onLoginSuccess(LoginResultParam loginResultParam) {
                        Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLoginFailure(int i, String s) {
                        Toast.makeText(getApplicationContext(), "登录失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        /**
         * 充值
         */
        charge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(money.getText())) {
                    Toast.makeText(MainActivity.this, "请输入金额", Toast.LENGTH_SHORT).show();
                    return;
                }
                int m = Integer.valueOf(money.getText().toString().trim());

                PayParam param = new PayParam();
                param.roleId = "id1";
                param.money = m + "";
                param.serverid = "服务器id";
                param.productName = "产品名称";
                param.productDesc = "产品描述";
                param.attach = "attach";
                param.roleName = "龙天";
                param.roleLevel = "角色等级";

                MGSDKManager.getInstance(MainActivity.this).pay(MainActivity.this, param, new OnPayCallback() {
                    @Override
                    public void paySuccess(int i) {
                        Toast.makeText(MainActivity.this, "交易成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void payError(int i, String s) {
                        Log.e("TAG    " + i, s);
                        Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        /**
         * 退出
         */
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MGSDKManager.getInstance(MainActivity.this).exit(MainActivity.this, new OnExitCallback() {
                    @Override
                    public void success() {
                        Toast.makeText(MainActivity.this, "退出成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void fail() {
                        Toast.makeText(MainActivity.this, "退出失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        /**
         * 注销
         */
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MGSDKManager.getInstance(MainActivity.this).logout(MainActivity.this);
            }
        });

        /**
         * 上传用户信息
         */
        update_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        if(Build.VERSION.SDK_INT >= 24){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS}, 0);
        }

        MGSDKManager.getInstance(this).onCreate(MainActivity.this);

    }

    private void initView() {

        Button login = findViewById(R.id.btn_login_demo);
        Button charge = findViewById(R.id.btn_charge_demo);
        Button exit = findViewById(R.id.btn_exit_demo);
        Button logout = findViewById(R.id.btn_logout);
        Button update_user = findViewById(R.id.btn_update_roleinfo);

        final EditText money = findViewById(R.id.et_money);


        /**
         * 登录
         */
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MGSDKManager.getInstance(MainActivity.this).login(MainActivity.this, true, new OnLoginCallback() {
                    @Override
                    public void onLoginSuccess(LoginResultParam loginResultParam) {
                        Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLoginFailure(int i, String s) {
                        Toast.makeText(getApplicationContext(), "登录失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        /**
         * 充值
         */
        charge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(money.getText())) {
                    Toast.makeText(MainActivity.this, "请输入金额", Toast.LENGTH_SHORT).show();
                    return;
                }
                int m = Integer.valueOf(money.getText().toString().trim());

                PayParam param = new PayParam();
                param.roleId = "id1" + getRandom();
                param.money = money + "";
                param.serverid = "服务器id" +  + getRandom();
                param.productName = "产品名称" +  + getRandom();
                param.productDesc = "产品描述" +  + getRandom();
                param.attach = String.valueOf(Calendar.getInstance().getTimeInMillis());//attach
                param.roleName = "龙天" +  + getRandom();
                param.roleLevel = "角色等级" +  + getRandom();

                Log.e("TAG      ", param.roleId);

                MGSDKManager.getInstance(MainActivity.this).pay(MainActivity.this, param, new OnPayCallback() {
                    @Override
                    public void paySuccess(int i) {
                        Toast.makeText(MainActivity.this, "交易成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void payError(int i, String s) {
                        Log.e("TAG     " + i, s);
                        Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        /**
         * 退出
         */
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MGSDKManager.getInstance(MainActivity.this).exit(MainActivity.this, new OnExitCallback() {
                    @Override
                    public void success() {
                        Toast.makeText(MainActivity.this, "退出成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void fail() {
                        Toast.makeText(MainActivity.this, "退出失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        /**
         * 注销
         */
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MGSDKManager.getInstance(MainActivity.this).logout(MainActivity.this);
            }
        });

        /**
         * 上传用户信息
         */
        update_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        if(Build.VERSION.SDK_INT >= 24){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS}, 0);
        }

        MGSDKManager.getInstance(this).onCreate(MainActivity.this);


    }



    public int getRandom() {
        int i = (int) (Math.random() * 100000);
        return i;
    }


    @Override
    protected void onPause() {
        super.onPause();
        MGSDKManager.getInstance(this).onPause(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MGSDKManager.getInstance(this).onResume(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        MGSDKManager.getInstance(this).onStop(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MGSDKManager.getInstance(this).onDestroy(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        // TODO Auto-generated method stub
        super.onNewIntent(intent);
        MGSDKManager.getInstance(this).onNewIntent(this, intent);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // TODO Auto-generated method stub
        super.onConfigurationChanged(newConfig);
        MGSDKManager.getInstance(this).onConfigurationChanged(this, newConfig);
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        MGSDKManager.getInstance(this).onBackPressed(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        MGSDKManager.getInstance(this).onActivityResult(this, requestCode, resultCode, data);
    }

}
