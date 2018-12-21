package com.example.yida.qq.api.model.main;

/**
 * Created by yida on 2018/10/29.
 */
public interface OnlineStateContentProvider {

    // 用于展示最近联系人界面的在线状态
    String getSimpleDisplay(String account);

    // 用于展示聊天界面的在线状态
    String getDetailDisplay(String account);

}
