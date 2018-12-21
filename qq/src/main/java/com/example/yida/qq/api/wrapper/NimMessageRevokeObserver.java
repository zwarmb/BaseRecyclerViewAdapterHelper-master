package com.example.yida.qq.api.wrapper;

import com.netease.nimlib.sdk.Observer;
import com.netease.nimlib.sdk.msg.model.RevokeMsgNotification;

/**
 * Created by yida on 2018/10/29.
 */
public class NimMessageRevokeObserver implements Observer<RevokeMsgNotification> {

    @Override
    public void onEvent(RevokeMsgNotification notification) {
        if (notification == null || notification.getMessage() == null) {
            return;
        }

        MessageHelper.getInstance().onRevokeMessage(notification.getMessage(), notification.getRevokeAccount());
    }

}
