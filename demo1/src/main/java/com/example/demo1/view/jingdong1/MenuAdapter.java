package com.example.demo1.view.jingdong1;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.demo1.R;

import java.util.List;

/**
 * Created by yida on 2018/6/22.
 */

public class MenuAdapter extends BaseAdapter {
    private Context mContext;
    private int selectItem = 0;
    private List<String> mList;

    public MenuAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
    }

    public int getSelectItem() {
        return selectItem;
    }

    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (holder == null) {
            holder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.item_jingdong1_menu, null);
            holder.menuText = convertView.findViewById(R.id.tv_item_jingdong1);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // 设置左边分类选中的颜色
        if (position == selectItem) {
            holder.menuText.setBackgroundColor(Color.WHITE);
            holder.menuText.setTextColor(Color.YELLOW);
        } else {
            holder.menuText.setBackgroundColor(mContext.getResources().getColor(R.color.fragment_back));
            holder.menuText.setTextColor(Color.BLACK);
        }
        holder.menuText.setText(mList.get(position));
        return convertView;
    }

    class ViewHolder {
        TextView menuText;
    }
}
