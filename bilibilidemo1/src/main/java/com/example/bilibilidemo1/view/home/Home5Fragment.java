package com.example.bilibilidemo1.view.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bilibilidemo1.R;
import com.example.bilibilidemo1.base.BaseFragment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by yida on 2018/2/3.
 */

public class Home5Fragment extends BaseFragment {

    @BindView(R.id.email)
    EditText mEmail;
    @BindView(R.id.btn_email)
    Button mBtnEmail;
    Unbinder unbinder;

    public static Home5Fragment newInstance() {
        return new Home5Fragment();
    }

//    //判断email格式是否正确
    public static boolean isEmail(String email){
        if (null==email || "".equals(email)) return false;
        //Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}"); //简单匹配
        Pattern p =  Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");//复杂匹配
        Matcher m = p.matcher(email);
        return m.matches();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_li, container, false);
        unbinder = ButterKnife.bind(this, view);


        initView();

        return view;
    }

    private void initView() {

        final String email = mEmail.getText().toString();

        mBtnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("qq 邮箱 ", email);
                if (isEmail(email)) {
                    // 是邮箱

                    int i = email.indexOf("@");
                    String substring = email.substring(0, i);

                    Log.e("qq  邮箱@之前的几位   : ", substring);
                    for (int j = 0; j < i; j++) {
                        Log.e(" www ", email.charAt(j) + " ");
                    }

                } else {
                    // 不是邮箱
                    Toast.makeText(getContext(), "请输入正确的邮箱", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

//    /**
//     * 描述：是否是邮箱.
//     *
//     * @param str 指定的字符串
//     * @return 是否是邮箱:是为true，否则false
//     */
//    public static Boolean isEmail(String str) {
//        Boolean isEmail = false;
//        String expr = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
//        if (str.matches(expr)) {
//            isEmail = true;
//        }
//        return isEmail;
//    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
