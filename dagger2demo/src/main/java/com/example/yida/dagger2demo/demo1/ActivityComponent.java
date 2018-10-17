package com.example.yida.dagger2demo.demo1;

import com.example.yida.dagger2demo.MainActivity;

import dagger.Component;

/**
 * Created by yida on 2018/7/31.
 */
@Component(dependencies = {APPComponent.class}, modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
