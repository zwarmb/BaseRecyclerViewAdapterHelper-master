package com.example.yida.dagger2demo.demo1;

import android.content.Context;

import com.example.yida.dagger2demo.Person;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yida on 2018/7/31.
 */
@Module
public class ActivityModule {

    @Provides
    Person providesPersion(Context context) {
        return new Person(context);
    }

}
