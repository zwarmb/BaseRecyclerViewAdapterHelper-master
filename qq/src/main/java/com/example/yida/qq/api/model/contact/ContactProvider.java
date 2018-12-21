package com.example.yida.qq.api.model.contact;

import java.util.List;

/**
 * Created by yida on 2018/10/29.
 */
public interface ContactProvider {

    /**
     * 返回本地所有好友用户信息（通讯录一般列出所有的好友）
     *
     * @return 用户信息集合
     */
    List<String> getUserInfoOfMyFriends();

    /**
     * 返回我的好友数量，提供给通讯录显示所有联系人数量使用
     *
     * @return 好友个数
     */
    int getMyFriendsCount();

    /**
     * 获取备注
     *
     * @param account 账号
     * @return 备注
     */
    String getAlias(String account);

    /**
     * 是否是自己的好友
     *
     * @param account 账号
     * @return 结果
     */
    boolean isMyFriend(String account);

}
