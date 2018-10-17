package com.example.bilibilidemo1.view.home.home2;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bilibilidemo1.R;

import java.util.List;

/**
 * Created by yida on 2018/2/8.
 */

public class UnSelectedRecycleAdapter extends RecyclerView.Adapter<UnSelectedRecycleAdapter.MyViewHolder> {
    private Context mContext;
    private List<String> mList;

    public UnSelectedRecycleAdapter(Context context, List<String> list) {
        this.mContext = context;
        this.mList = list;
    }

    public interface onItemClickListener {
        void onItemClick(MyViewHolder holder, int pos);

        void onItemLongClickListener(MyViewHolder holder, int pos);
    }

    private onItemClickListener mItemClickListener;

    public void setItemClickListener(onItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_home2_kuang, parent, false));
        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.mTextView.setText(mList.get(position));
        holder.mImageView.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.add));

        if (mItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mItemClickListener != null) {
                        mItemClickListener.onItemClick(holder, position);
                    }
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mItemClickListener.onItemLongClickListener(holder, position);
                    return false;
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
        notifyItemInserted(pos);
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
