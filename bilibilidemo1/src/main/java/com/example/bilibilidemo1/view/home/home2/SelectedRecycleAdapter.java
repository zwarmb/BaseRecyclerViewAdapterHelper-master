package com.example.bilibilidemo1.view.home.home2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bilibilidemo1.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by yida on 2018/2/8.
 */

public class SelectedRecycleAdapter extends RecyclerView.Adapter<SelectedRecycleAdapter.MyViewHolder>
        implements ItemTouchHelperCallBack.OnItemPositionChangeListener {

    private List<String> mList;
    private Context mContext;
    private static boolean isShowDeleteIcon;


    @Override
    public boolean onItemMove(int fromPos, int toPos) {
        Collections.swap(mList, fromPos, toPos);
        /**
         * 就这一个地方的错 , 导致我的条目移动没有反应
         */
        notifyItemMoved(fromPos, toPos);
        return true;
    }

    private OnItemClickListener mItemClickListener;
    private onDeleteIconClickListener mDeleteIconClickListener;

    public interface OnItemClickListener {

        void onItemClickListener(MyViewHolder myViewHolder, int pos);
        void onItemLongClickListener(MyViewHolder myViewHolder, int pos);

    }
    public interface onDeleteIconClickListener {
        void onDeleteIconClick(int pos);

    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public void setDeleteIconClickListener(onDeleteIconClickListener deleteIconClickListener) {
        mDeleteIconClickListener = deleteIconClickListener;
    }

    public static void isShowDeleteIcon(boolean isShow) {
        isShowDeleteIcon = isShow;
    }

    public SelectedRecycleAdapter(List<String> list, Context context) {
        mList = list;
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home2_kuang, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.mTextView.setText(mList.get(position));

        if (isShowDeleteIcon) {
            holder.mImageView.setVisibility(View.VISIBLE);
        }else {
            holder.mImageView.setVisibility(View.INVISIBLE);
        }

        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDeleteIconClickListener.onDeleteIconClick(holder.getLayoutPosition());
            }
        });

        if (mItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClickListener.onItemClickListener(holder, position);
                }
            });
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClickListener.onItemLongClickListener(holder, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addData(String data, int pos) {
        mList.add(pos, data);
        notifyDataSetChanged();
    }

    public void removeData(int pos) {
        mList.remove(pos);

        notifyDataSetChanged();
        notifyItemRemoved(pos);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        ImageView mImageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            mTextView = itemView.findViewById(R.id.tv_item_home2);
            mImageView = itemView.findViewById(R.id.delelte_item_home2);
        }
    }
}
