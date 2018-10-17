package com.example.bilibilidemo1.view.home.home4;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bm.library.PhotoView;
import com.example.bilibilidemo1.R;
import com.example.bilibilidemo1.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by yida on 2018/3/2.
 */

public class Home4ImageFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.pager)
    ViewPager mPager;
    @BindView(R.id.crossIv)
    ImageView mCrossIv;
    @BindView(R.id.photoOrderTv)
    TextView mPhotoOrderTv;
    @BindView(R.id.saveTv)
    TextView mSaveTv;
    @BindView(R.id.centerIv)
    ImageView mCenterIv;
    Unbinder unbinder;

    private String curImageUrls= "";
    private String[] imageUrls = new String[]{};

    private int curPosition = -1;
    private int[] initialedPosition = null;
    private ObjectAnimator mObjectAnimator;
    private View curPage;


    public static Home4ImageFragment newInstance(String url, String[] imageUrls) {
        Bundle bundle = new Bundle();
        bundle.putString("ONCLICKURL", url);
        bundle.putStringArray("IMAGEYRLS", imageUrls);
        Home4ImageFragment home4ImageFragment = new Home4ImageFragment();
        home4ImageFragment.setArguments(bundle);
        return home4ImageFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_four_image, container, false);
        unbinder = ButterKnife.bind(this, view);

        curImageUrls = getArguments().getString("ONCLICKURL");
        imageUrls = getArguments().getStringArray("IMAGEYRLS");

        initialedPosition = new int[imageUrls.length];
        initInitialedPositions();

        mSaveTv.setOnClickListener(this);
        mCrossIv.setOnClickListener(this);

        mPager.setPageMargin((int) (getResources().getDisplayMetrics().density * 15));
        mPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imageUrls.length;
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                if (imageUrls[position] != null && !"".equals(imageUrls[position])) {
                    PhotoView view = new PhotoView(getContext());
                    view.enable();
//                    view.setScaleType(ImageView.ScaleType.FIT_XY);
////                    Glide.with(getContext()).load(imageUrls[position]);
//                    Glide.with(getContext()).load(imageUrls[position]).override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).fitCenter().crossFade().listener(new RequestListener<String, GlideDrawable>() {
//                    }).into(view);
                }
                return null;
            }
        });


        return view;
    }

    private void initInitialedPositions() {
        for (int i = 0; i < initialedPosition.length; i++) {
            initialedPosition[i] = -1;
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {

    }
}
