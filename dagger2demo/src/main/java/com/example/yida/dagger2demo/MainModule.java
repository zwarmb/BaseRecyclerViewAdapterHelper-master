package com.example.yida.dagger2demo;

import android.content.Context;
import android.util.Log;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yida on 2018/7/31.
 */
@Module
public class MainModule {

    private Context mContext;

    public MainModule(Context context) {
        mContext = context;
    }

    @Provides
    public Context providesContext() {
        return this.mContext;
    }

    @Singleton // 单例
    @Provides
    Person providesPerson(Context context) {
        Log.e("module", "这是module");
        return new Person(context);
    }

}
