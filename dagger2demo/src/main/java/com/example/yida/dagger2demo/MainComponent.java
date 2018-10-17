package com.example.yida.dagger2demo;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by yida on 2018/7/31.
 */
@Singleton // 单例
@Component(modules = {MainModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);

}
