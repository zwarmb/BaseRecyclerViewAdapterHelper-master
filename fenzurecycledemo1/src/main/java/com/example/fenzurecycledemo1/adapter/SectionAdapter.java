package com.example.fenzurecycledemo1.adapter;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.fenzurecycledemo1.R;
import com.example.fenzurecycledemo1.bean.MySection;
import com.example.fenzurecycledemo1.bean.UserBean;

import java.util.List;

/**
 * Created by Administrator on 2018/1/12.
 */

public class SectionAdapter extends BaseSectionQuickAdapter<MySection, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId      The layout resource id of each item.
     * @param sectionHeadResId The section head layout id for each item
     * @param data             A new list is created out of this one to avoid mutable list
     */
    public SectionAdapter(int layoutResId, int sectionHeadResId, List<MySection> data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, MySection item) {
        helper.setText(R.id.header, item.header);
        helper.setVisible(R.id.more, item.isMore());
        helper.addOnClickListener(R.id.more);
    }

    @Override
    protected void convert(BaseViewHolder helper, MySection item) {
        UserBean userBean = item.t;
        switch (helper.getLayoutPosition() %
                2) {
            case 0:
                helper.setImageResource(R.id.iv, R.mipmap.m_img1);
                break;
            case 1:
                helper.setImageResource(R.id.iv, R.mipmap.m_img2);
                break;

        }
        helper.setText(R.id.tv, userBean.getName());
    }
}
