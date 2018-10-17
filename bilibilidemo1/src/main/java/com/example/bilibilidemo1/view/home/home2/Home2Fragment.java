package com.example.bilibilidemo1.view.home.home2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.bilibilidemo1.R;
import com.example.bilibilidemo1.base.BaseFragment;
import com.example.bilibilidemo1.bean.ResponseBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by yida on 2018/2/3.
 */

public class Home2Fragment extends BaseFragment {

    @BindView(R.id.tv_finish)
    TextView mTvFinish;
    @BindView(R.id.recycle_selected)
    RecyclerView mRecycleSelected;
    @BindView(R.id.recycle_unselected)
    RecyclerView mRecycleUnselected;
    Unbinder unbinder;

    private SelectedRecycleAdapter mSelectedRecycleAdapter;
    private UnSelectedRecycleAdapter mUnSelectedRecycleAdapter;
    private ItemTouchHelper mItemTouchHelper;

    private List<String> mSelectedDatas;
    private List<String> mUnSelectedDatas;

    private boolean isDeleteIconsShow = false;


    public static Home2Fragment newInstance() {
        return new Home2Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_two, container, false);
        unbinder = ButterKnife.bind(this, view);

        initD();

        initData();
        initView();
        initEvent();
        return view;
    }

    /**
     * 解析字符串类型的json数据
     */
    private void initD() {
        String data = "{\"room_id\":\"3506\",\"sort_num\":\"203386848\",\"group_id\":\"3506\",\"user_id\":\"123\",\"city\":\"福州\",\"title\":\"\",\"cate_id\":\"0\",\"live_in\":\"1\",\"video_type\":\"1\",\"create_type\":\"0\",\"room_type\":\"3\",\"watch_number\":\"4\",\"head_image\":\"http:\\/\\/ossniunai.oss-cn-hangzhou.aliyuncs.com\\/public\\/attachment\\/201712\\/22\\/11\\/origin\\/1513883344123.jpg\",\"thumb_head_image\":\"\",\"live_image\":\"http:\\/\\/ossniunai.oss-cn-hangzhou.aliyuncs.com\\/public\\/images\\/logo_video.png\",\"xpoint\":\"0.000000\",\"ypoint\":\"0.000000\",\"is_private\":\"0\",\"private_password\":\"\",\"v_type\":\"0\",\"v_icon\":null,\"nick_name\":\"123\",\"user_level\":\"62\",\"is_live_pay\":\"0\",\"live_pay_type\":\"0\",\"live_fee\":\"0\",\"user_create_time\":\"1511914740\"}";

        ResponseBean responseBean = JSON.parseObject(data, ResponseBean.class);

        Log.e("111", responseBean.getCity() + "  城市");

    }

    private void initView() {
        mRecycleSelected.setLayoutManager(new GridLayoutManager(getContext(), 4));
        mSelectedRecycleAdapter = new SelectedRecycleAdapter(mSelectedDatas, getContext());
        mRecycleSelected.setAdapter(mSelectedRecycleAdapter);
        // 设置条目间隔
        mRecycleSelected.addItemDecoration(new SpaceItemDecoration(8));

        mRecycleUnselected.setLayoutManager(new GridLayoutManager(getContext(), 4));
        mUnSelectedRecycleAdapter = new UnSelectedRecycleAdapter(getContext(), mUnSelectedDatas);
        mRecycleUnselected.setAdapter(mUnSelectedRecycleAdapter);
        // 设置条目的间隔
        mRecycleUnselected.addItemDecoration(new SpaceItemDecoration(8));

    }

    private void initEvent() {
        // 初始化ItemTouchHelper实例
        ItemTouchHelperCallBack callBack = new ItemTouchHelperCallBack(mSelectedRecycleAdapter);
        mItemTouchHelper = new ItemTouchHelper(callBack);
        mItemTouchHelper.attachToRecyclerView(mRecycleSelected);

        mSelectedRecycleAdapter.setItemClickListener(new SelectedRecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(SelectedRecycleAdapter.MyViewHolder myViewHolder, int pos) {
                if (!isDeleteIconsShow) {
                    Toast.makeText(getContext(), mSelectedDatas.get(pos), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onItemLongClickListener(SelectedRecycleAdapter.MyViewHolder myViewHolder, int pos) {
                if (!isDeleteIconsShow) {
                    showAllDeleteIcons();
                    mTvFinish.setVisibility(View.VISIBLE);
                }
            }
        });


        mSelectedRecycleAdapter.setDeleteIconClickListener(new SelectedRecycleAdapter.onDeleteIconClickListener() {
            @Override
            public void onDeleteIconClick(int pos) {
                mUnSelectedRecycleAdapter.addData(mSelectedDatas.get(pos), mUnSelectedDatas.size());
                mSelectedRecycleAdapter.removeData(pos);
            }
        });

        mTvFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideAllDeleteIcons();
                mTvFinish.setVisibility(View.INVISIBLE);
            }
        });

        mUnSelectedRecycleAdapter.setItemClickListener(new UnSelectedRecycleAdapter.onItemClickListener() {
            @Override
            public void onItemClick(UnSelectedRecycleAdapter.MyViewHolder holder, int pos) {
                mSelectedRecycleAdapter.addData(mUnSelectedDatas.get(pos), mSelectedDatas.size());
                mUnSelectedRecycleAdapter.removeData(pos);
            }

            @Override
            public void onItemLongClickListener(UnSelectedRecycleAdapter.MyViewHolder holder, int pos) {
                if (!isDeleteIconsShow) {
                    showAllAddIcons();
                    mTvFinish.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    /**
     * 显示出所有的删除图标
     */
    private void showAllDeleteIcons() {

        int count = mRecycleSelected.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = mRecycleSelected.getChildAt(i);
            ImageView delete = child.findViewById(R.id.delelte_item_home2);
            delete.setVisibility(View.VISIBLE);
        }

        isDeleteIconsShow = true;
        SelectedRecycleAdapter.isShowDeleteIcon(isDeleteIconsShow);
    }

    /**
     * 隐藏所有的删除图标
     */
    private void hideAllDeleteIcons() {

        int count = mRecycleSelected.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = mRecycleSelected.getChildAt(i);
            ImageView delete = child.findViewById(R.id.delelte_item_home2);
            delete.setVisibility(View.INVISIBLE);
        }

        isDeleteIconsShow = false;
        SelectedRecycleAdapter.isShowDeleteIcon(isDeleteIconsShow);
    }

    private void showAllAddIcons() {
        int count = mRecycleUnselected.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = mRecycleUnselected.getChildAt(i);
            ImageView delete = child.findViewById(R.id.delelte_item_home2);
            delete.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    private void initData() {
        mSelectedDatas = new ArrayList<String>();
        mSelectedDatas.add("头条");
        mSelectedDatas.add("娱乐");
        mSelectedDatas.add("精选");
        mSelectedDatas.add("热点");
        mSelectedDatas.add("体育");
        mSelectedDatas.add("网易号");
        mSelectedDatas.add("直播");
        mSelectedDatas.add("财经");
        mSelectedDatas.add("科技");
        mSelectedDatas.add("房产");
        mSelectedDatas.add("汽车");
        mSelectedDatas.add("轻松一刻");
        mSelectedDatas.add("跟帖");
        mSelectedDatas.add("图片");
        mSelectedDatas.add("段子");
        mSelectedDatas.add("家具");
        mSelectedDatas.add("游戏");
        mSelectedDatas.add("健康");
        mSelectedDatas.add("政务");
        mSelectedDatas.add("漫画");
        mSelectedDatas.add("中国足球");
        mSelectedDatas.add("数码");
        mSelectedDatas.add("趣闻");

        mUnSelectedDatas = new ArrayList<String>();
        mUnSelectedDatas.add("NBA");
        mUnSelectedDatas.add("社会");
        mUnSelectedDatas.add("军事");
        mUnSelectedDatas.add("欧洲杯");
        mUnSelectedDatas.add("CBA");
        mUnSelectedDatas.add("跑步");
        mUnSelectedDatas.add("移动互联");
        mUnSelectedDatas.add("云课堂");
        mUnSelectedDatas.add("房产");
        mUnSelectedDatas.add("旅游");
        mUnSelectedDatas.add("读书");
        mUnSelectedDatas.add("酒香");
        mUnSelectedDatas.add("教育");
        mUnSelectedDatas.add("亲子");
        mUnSelectedDatas.add("暴雪游戏");
        mUnSelectedDatas.add("态度营销");
        mUnSelectedDatas.add("时尚");
        mUnSelectedDatas.add("情感");
        mUnSelectedDatas.add("艺术");
        mUnSelectedDatas.add("海外");
        mUnSelectedDatas.add("博客");
        mUnSelectedDatas.add("论坛");
        mUnSelectedDatas.add("型男");
        mUnSelectedDatas.add("萌宠");
    }

}
