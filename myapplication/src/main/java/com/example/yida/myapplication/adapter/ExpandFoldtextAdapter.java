package com.example.yida.myapplication.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.example.yida.myapplication.R;
import com.example.yida.myapplication.bean.ExpandFoldTextBean;

import java.util.List;

/**
 * Created by yida on 2018/9/6.
 */

public class ExpandFoldtextAdapter extends RecyclerView.Adapter<ExpandFoldtextAdapter.MyViewHolder> {
    private Activity mContext;

    private final int MAX_LINE_COUNT = 3; // 最大显示行数
    private final int STATE_UNKNOW = -1;  // 未知状态
    private final int STATE_NOT_OVERFLOW = 1; // 文本行数小于最大行数
    private final int STATE_COLLAPSED = 2;//折叠状态

    private final int STATE_EXPANDED = 3;//展开状态

    /**
     * 注意, 保存文本状态的Key 一定要是唯一的,
     * 如果用position作为Key, 则删除,增加条目的时候会出现显示错误
     */
    private SparseArray<Integer> mTextStateList; // 保存文本状态集合
    List<ExpandFoldTextBean> mList;

    public ExpandFoldtextAdapter(Activity context, List<ExpandFoldTextBean> list) {
        mTextStateList = new SparseArray<>();
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(mContext.getLayoutInflater().inflate(R.layout.item_expand_fold_text, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        int state = mTextStateList.get(mList.get(i).getId(), STATE_UNKNOW);
        // 第一次初始化, 未知状态
        if (state == STATE_UNKNOW) {
            myViewHolder.content.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    myViewHolder.content.getViewTreeObserver().removeOnPreDrawListener(this);

                    if (myViewHolder.content.getLineCount() > MAX_LINE_COUNT) {
                        myViewHolder.content.setMaxLines(MAX_LINE_COUNT);
                        myViewHolder.expandOrFold.setVisibility(View.VISIBLE);
                        myViewHolder.expandOrFold.setText("全文");
                        mTextStateList.put(mList.get(i).getId(), STATE_COLLAPSED);
                    } else {
                        myViewHolder.expandOrFold.setVisibility(View.GONE);
                        mTextStateList.put(mList.get(i).getId(), STATE_NOT_OVERFLOW);
                    }
                    return true;
                }
            });
            myViewHolder.content.setMaxLines(Integer.MAX_VALUE);
            myViewHolder.content.setText(mList.get(i).getContent());
        } else {
            // 如果之前已经初始化了, 就用保存的状态
            switch (state) {
                case STATE_NOT_OVERFLOW:
                    myViewHolder.expandOrFold.setVisibility(View.GONE);
                    break;
                case STATE_COLLAPSED:
                    myViewHolder.content.setMaxLines(MAX_LINE_COUNT);
                    myViewHolder.expandOrFold.setVisibility(View.VISIBLE);
                    myViewHolder.expandOrFold.setText("全文");
                    break;
                case STATE_EXPANDED:
                    myViewHolder.content.setMaxLines(Integer.MAX_VALUE);
                    myViewHolder.expandOrFold.setVisibility(View.VISIBLE);
                    myViewHolder.expandOrFold.setText("收起");
                    break;
            }
            myViewHolder.content.setText(mList.get(i).getContent());

        }

        // 全文和收起的点击事件
        myViewHolder.expandOrFold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int state = mTextStateList.get(mList.get(i).getId(), STATE_UNKNOW);
                if (state == STATE_COLLAPSED) {
                    myViewHolder.content.setMaxLines(Integer.MAX_VALUE);
                    myViewHolder.expandOrFold.setText("收起");
                    mTextStateList.put(mList.get(i).getId(), STATE_EXPANDED);
                } else if (state == STATE_EXPANDED) {
                    myViewHolder.content.setMaxLines(MAX_LINE_COUNT);
                    myViewHolder.expandOrFold.setText("全文");
                    mTextStateList.put(mList.get(i).getId(), STATE_COLLAPSED);
                }
            }
        });


        // 删除的点击事件
        myViewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mList.remove(i);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nickName;
        public TextView content;
        public TextView delete;
        public TextView expandOrFold;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nickName = itemView.findViewById(R.id.tv_nickname);
            content = itemView.findViewById(R.id.tv_content);
            delete = itemView.findViewById(R.id.tv_delete);
            expandOrFold = itemView.findViewById(R.id.tv_expand_or_fold);
        }
    }
}
