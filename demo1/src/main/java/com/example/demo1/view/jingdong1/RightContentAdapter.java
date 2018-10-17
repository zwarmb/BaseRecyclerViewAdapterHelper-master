package com.example.demo1.view.jingdong1;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.demo1.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by yida on 2018/6/22.
 */

public class RightContentAdapter extends BaseAdapter {
    private List<JingDongBean.DataBean.DataListBean> mDataListBeans;
    private Context mContext;

    public RightContentAdapter(List<JingDongBean.DataBean.DataListBean> dataListBeans, Context context) {
        mDataListBeans = dataListBeans;
        mContext = context;
    }

    @Override
    public int getCount() {
        if (mDataListBeans != null) {
            return mDataListBeans.size();
        } else {
            return 10;
        }
    }

    @Override
    public Object getItem(int position) {
        return mDataListBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        JingDongBean.DataBean.DataListBean dataListBean = mDataListBeans.get(position);
        ViewHolder viewHolder = null;
        if (viewHolder == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.item_jingdong1_rightcontent, null);
            viewHolder.mImageView = convertView.findViewById(R.id.iv_item_jingdong1_rightcontent);
            viewHolder.mTextView = convertView.findViewById(R.id.tv_item_jingdong1_rightcontent);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.mTextView.setText(dataListBean.getTitle());
        Uri uri = Uri.parse(dataListBean.getImgURL());
        viewHolder.mImageView.setImageURI(uri);

        return convertView;
    }

    class ViewHolder {
        SimpleDraweeView mImageView;
        TextView mTextView;
    }
}
