package com.example.fenzurecycledemo1.bean;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Created by Administrator on 2018/1/12.
 */

public class MySection extends SectionEntity<UserBean> {

    private boolean isMore;

    public MySection(boolean isHeader, String header, boolean isMore) {
        super(isHeader, header);
        this.isMore = isMore;
    }

    public MySection(UserBean userBean) {
        super(userBean);
    }

    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean more) {
        isMore = more;
    }
}
