package com.example.yida.demo3.base;

import com.example.yida.demo3.bean.BaseResponseBean;
import com.example.yida.demo3.exception.ApiException;
import com.example.yida.demo3.exception.CustomException;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;

/**
 * Created by yida on 2018/10/24.
 */
public class BaseTransformer {

    public static <T>ObservableTransformer<BaseResponseBean<T>, T> handleResult() {
        return new ObservableTransformer<BaseResponseBean<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<BaseResponseBean<T>> upstream) {
                return upstream
                        .onErrorResumeNext(new ErrorResumeFunction<T>())
                        .flatMap(new ResponseFunction<T>());
            }
        };
    }


    /**
     * 非服务器产生的异常, 比如本地无网络请求, Json数据解析错误等等
     * @param <T>
     */
    public static class ErrorResumeFunction<T> implements Function<Throwable, ObservableSource<? extends BaseResponseBean<T>>> {
        @Override
        public ObservableSource<? extends BaseResponseBean<T>> apply(Throwable throwable) throws Exception {
            return Observable.error(CustomException.handleException(throwable));
        }
    }


    /**
     * 服务器返回的数据解析
     * 正常服务器返回数据和服务器可能返回的 exception
     * @param <T>
     */
    private static class ResponseFunction<T> implements Function<BaseResponseBean<T>, ObservableSource<T>> {
        @Override
        public ObservableSource<T> apply(BaseResponseBean<T> tBaseResponseBean) throws Exception {
            int code = tBaseResponseBean.getStatus();
            String message = tBaseResponseBean.getErrMsg();
            if (code == 200) {
                return Observable.just(tBaseResponseBean.getData());
            } else {
                return Observable.error(new ApiException(code, message));
            }
        }
    }

}
