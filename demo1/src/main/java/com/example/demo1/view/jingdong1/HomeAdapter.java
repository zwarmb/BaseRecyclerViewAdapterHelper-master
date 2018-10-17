package com.example.demo1.view.jingdong1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.demo1.R;

import java.util.List;

/**
 * Created by yida on 2018/6/26.
 */

public class HomeAdapter extends BaseAdapter {
//    private JingDongBean.DataBean mDataBean;
    private Context mContext;
    private List<JingDongBean.DataBean> mList;

    public HomeAdapter(Context context, List<JingDongBean.DataBean> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        if (mList != null) {
            return mList.size();
        } else {
            return 10;
        }
    }

    @Override
    public Object getItem(int position) {
        return mList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        JingDongBean.DataBean dataBean = mList.get(position);
        List<JingDongBean.DataBean.DataListBean> listBeans = dataBean.getDataList();
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_jingdong1_home, null);
            viewHolder = new ViewHolder();
            viewHolder.mGridViewForScrollView = convertView.findViewById(R.id.gv_item_jingdong1_home);
            viewHolder.mTextView = convertView.findViewById(R.id.tv_item_jingdong1_home);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        RightContentAdapter rightContentAdapter = new RightContentAdapter(listBeans, mContext);
        viewHolder.mGridViewForScrollView.setAdapter(rightContentAdapter);
        viewHolder.mTextView.setText(dataBean.getModuleTitle());
        return convertView;
    }

    private static class ViewHolder {
        GridViewForScrollView mGridViewForScrollView;
        TextView mTextView;

    }

}
