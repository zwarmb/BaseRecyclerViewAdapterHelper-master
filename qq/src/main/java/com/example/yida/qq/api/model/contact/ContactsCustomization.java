package com.example.yida.qq.api.model.contact;

import com.example.yida.qq.business.contact.core.item.AbsContactItem;
import com.example.yida.qq.business.contact.core.viewholder.AbsContactViewHolder;

import java.util.List;

/**
 * Created by yida on 2018/10/29.
 */
public interface ContactsCustomization {

    /**
     * 获取功能项ViewHolder的Class（第三方APP提供）
     *
     * @return 实现AbsContactViewHolder且Item数据实现AbsContactItem的自定义类
     */
    Class<? extends AbsContactViewHolder<? extends AbsContactItem>> onGetFuncViewHolderClass();

    /**
     * 获取所有功能项（第三方APP提供）
     *
     * @return 功能项集合
     */
    List<AbsContactItem> onGetFuncItems();

    /**
     * 用户自定义的功能项（折叠群、黑名单、我的电脑等）点击事件处理，一般跳转到相应功能模块
     *
     * @param item 自定义的功能项的基类，一般可以通过"=="、"instance of"来判断对应的具体功能
     */
    void onFuncItemClick(AbsContactItem item);

}
