package com.example.yida.dagger2demo.demo3;

import dagger.Component;

/**
 * Created by yida on 2018/7/31.
 */
@Component(modules = HttpActivityModule.class)
public interface HttpActivityCompnent {

    void inject(HttpActivity httpActivity);

}
