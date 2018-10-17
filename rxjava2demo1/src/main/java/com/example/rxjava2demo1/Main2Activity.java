package com.example.rxjava2demo1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class Main2Activity extends AppCompatActivity {

    private static String TAG = "Main2 -------------";
    private static Subscription mSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        Bb();
//        Cc();
//        Dd();

//        Ee();
//        Ff();
        Gg();

    }

    private void Gg() {

        Flowable.interval(1, TimeUnit.MICROSECONDS)
                .onBackpressureDrop()
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        Log.e(TAG, "onSubscribe");
                        mSubscription = s;
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.e(TAG, "onNext   " + aLong);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e(TAG, "onError   ", t);
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete");
                    }
                });

    }

    public static void request(long n) {
        mSubscription.request(n);
    }

    private static void Ff() {
        Log.e(TAG, "FFFFF");
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> e) throws Exception {

                for (int i = 0; ; i++) {
                    e.onNext(i);
                }
            }
        }, BackpressureStrategy.DROP)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {

                    @Override
                    public void onSubscribe(Subscription s) {
                        Log.d(TAG, "onSubscribe");
                        mSubscription = s;  //把Subscription保存起来
                        Log.e(TAG, mSubscription.toString() + "   next");
                        s.request(128);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.w(TAG, "onError: ", t);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }
                });

    }


//    public static void demo3() {
//        Flowable.create(new FlowableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
//                Log.d(TAG, "emit 1");
//                emitter.onNext(1);
//                Log.d(TAG, "emit 2");
//                emitter.onNext(2);
//                Log.d(TAG, "emit 3");
//                emitter.onNext(3);
//                Log.d(TAG, "emit complete");
//                emitter.onComplete();
//            }
//        }, BackpressureStrategy.ERROR).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Integer>() {
//
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "onSubscribe");
//                        mSubscription = s;  //把Subscription保存起来
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "onNext: " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.w(TAG, "onError: ", t);
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete");
//                    }
//                });
//    }
//

    private void Ee() {

        Flowable<Integer> flowable = Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> e) throws Exception {
                Log.e(TAG, "111");
                e.onNext(111);
                Log.e(TAG, "222");
                e.onNext(222);
                Log.e(TAG, "333");
                e.onNext(333);
                Log.e(TAG, "444");
                e.onNext(444);
                Log.e(TAG, "555");
                e.onNext(555);
                e.onComplete();
            }
        }, BackpressureStrategy.ERROR);

        Subscriber<Integer> subscriber = new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                Log.e(TAG, "onSubscribe");
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG, "onNext      " + integer);
            }

            @Override
            public void onError(Throwable t) {
                Log.e(TAG, "onError   " + t);
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete");
            }
        };

        flowable.subscribe(subscriber);
    }

    private void Dd() {
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                for (int i = 0; ; i++) {
                    e.onNext(i);
                    Thread.sleep(1000);
                }
            }
        }).subscribeOn(Schedulers.io());

        Observable<String> observable1 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("aaa");
            }
        }).subscribeOn(Schedulers.io());

        Observable.zip(observable, observable1, new BiFunction<Integer, String, String>() {
            @Override
            public String apply(Integer integer, String s) throws Exception {
                return integer + s;
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e(TAG, s);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.e(TAG, throwable.getMessage());
            }
        });

    }

    private void Cc() {
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                for (int i = 0; ; i++) {
                    e.onNext(i);
                }
            }
        }).subscribeOn(Schedulers.io());

        Observable<String> observable1 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("aaa");
            }
        }).subscribeOn(Schedulers.io());

        Observable.zip(observable, observable1, new BiFunction<Integer, String, String>() {
            @Override
            public String apply(Integer integer, String s) throws Exception {
                return integer + s;
            }
        }).subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.e(TAG, s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e(TAG, throwable.getMessage());
                    }
                });

    }

    private void Bb() {

        Observable<Integer> observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.d(TAG, "emit 1");
                Thread.sleep(1000);
                emitter.onNext(1);

                Log.d(TAG, "emit 2");
                Thread.sleep(1000);
                emitter.onNext(2);

                Log.d(TAG, "emit 3");
                Thread.sleep(1000);
                emitter.onNext(3);

                Log.d(TAG, "emit 4");
                Thread.sleep(1000);
                emitter.onNext(4);

                Log.d(TAG, "emit complete1");
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.io());

        Observable<String> observable2 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                Log.d(TAG, "emit A");
                Thread.sleep(1000);
                emitter.onNext("A");

                Log.d(TAG, "emit B");
                Thread.sleep(1000);
                emitter.onNext("B");

                Log.d(TAG, "emit C");
                Thread.sleep(1000);
                emitter.onNext("C");

                Log.d(TAG, "emit complete2");
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.io());


        Observable.zip(observable1, observable2, new BiFunction<Integer, String, String>() {
            @Override
            public String apply(Integer integer, String s) throws Exception {
                return integer + s;
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe");
            }

            @Override
            public void onNext(String value) {
                Log.d(TAG, "onNext: " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
            }
        }/*, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.e(TAG, throwable.getMessage());
            }
        }*/);


//
//        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                Log.e(TAG, "1111");
//                e.onNext(1);
//                Thread.sleep(500);
//                Log.e(TAG, "2222");
//                e.onNext(2);
//                Thread.sleep(500);
//                Log.e(TAG, "3333");
//                e.onNext(3);
//                Thread.sleep(500);
////                Thread.sleep(500);
////                Log.e(TAG, "4444");
////                e.onNext(4);
////                Thread.sleep(500);
////                Log.e(TAG, "5555");
////                e.onNext(5);
//                e.onComplete();
//            }
//        }).subscribeOn(Schedulers.io());
//
//        Observable<String> observable1 = Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> e) throws Exception {
//                Log.e(TAG, "aaaa");
//                e.onNext("a");
//                Thread.sleep(500);
//                Log.e(TAG, "bbbb");
//                e.onNext("b");
//                Thread.sleep(500);
//                Log.e(TAG, "cccc");
//                e.onNext("c");
//                Thread.sleep(500);
//                Log.e(TAG, "dddd");
//                e.onNext("d");
//                Thread.sleep(500);
//                Log.e(TAG, "eeee");
//                e.onNext("e");
//                Thread.sleep(500);
//                e.onComplete();
//            }
//        }).subscribeOn(Schedulers.io());
//
//        Observable.zip(observable, observable1, new BiFunction<Integer, String, String>() {
//            @Override
//            public String apply(Integer integer, String s) throws Exception {
//                return integer + "     " + s;
//            }
//        }).subscribe(new Observer<String>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.e(TAG, "onSubscribe");
//            }
//
//            @Override
//            public void onNext(String value) {
//                Log.e(TAG, "onNext       " + value);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.e(TAG, "Error");
//            }
//
//            @Override
//            public void onComplete() {
//
//                Log.e(TAG, "complete");
//            }
//        });

    }



}
