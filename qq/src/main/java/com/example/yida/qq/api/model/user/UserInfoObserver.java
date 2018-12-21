package com.example.yida.qq.api.model.user;

import java.util.List;

/**
 * Created by yida on 2018/10/29.
 *
 * UIKit 与 app 好友关系变化监听接口
 */
public interface UserInfoObserver {

    /**
     * 用户信息变更
     *
     * @param accounts 账号列表
     */
    void onUserInfoChanged(List<String> accounts);

}
