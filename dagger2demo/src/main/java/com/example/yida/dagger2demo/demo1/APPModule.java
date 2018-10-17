package com.example.yida.dagger2demo.demo1;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yida on 2018/7/31.
 */
@Module
public class APPModule {

    private Context mContext;

    public APPModule(Context context) {
        mContext = context;
    }

    @Provides
    public Context providesContext() {
        return mContext;
    }
}
