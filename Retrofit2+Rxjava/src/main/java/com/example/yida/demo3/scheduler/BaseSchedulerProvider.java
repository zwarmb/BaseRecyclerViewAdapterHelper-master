package com.example.yida.demo3.scheduler;

import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;

/**
 * Created by yida on 2018/10/24.
 */
public interface BaseSchedulerProvider {

    @NonNull
    Scheduler computation();

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler ui();

    @NonNull
    <T>ObservableTransformer<T, T> applySchedulers();

}
