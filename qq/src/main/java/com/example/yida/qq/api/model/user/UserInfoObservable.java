package com.example.yida.qq.api.model.user;

import android.content.Context;
import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yida on 2018/10/29.
 *
 * 用户资料变动观察者管理
 */
public class UserInfoObservable {

    private List<UserInfoObserver> observers = new ArrayList<>();
    private Handler uiHandler;

    public UserInfoObservable(Context context) {
        uiHandler = new Handler(context.getMainLooper());
    }

    synchronized public void registerObserver(UserInfoObserver observer, boolean register) {
        if (observer == null) {
            return;
        }
        if (register) {
            observers.add(observer);
        } else {
            observers.remove(observer);
        }
    }

    synchronized public void notifyUserInfoChanged(final List<String> accounts) {
        uiHandler.post(new Runnable() {
            @Override
            public void run() {
                for (UserInfoObserver observer : observers) {
                    observer.onUserInfoChanged(accounts);
                }
            }
        });
    }

}
