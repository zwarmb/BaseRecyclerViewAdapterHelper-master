package com.example.yida.qq.api.model.main;

import java.util.Set;

/**
 * Created by yida on 2018/10/29.
 */
public interface OnlineStateChangeObserver {

    /**
     * 通知在线状态事件变化
     *
     * @param account 在线状态事件发生变化的账号
     */
    void onlineStateChange(Set<String> account);

}
