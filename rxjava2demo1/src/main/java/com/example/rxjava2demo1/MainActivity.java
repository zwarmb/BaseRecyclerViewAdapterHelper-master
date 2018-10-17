package com.example.rxjava2demo1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "kaishile");

        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
//        Intent intent = new Intent(this, Main2Activity.class);
//        startActivity(intent);
        Aa();
    }

    private void Aa() {
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                Log.e("TAG", "1");
//                e.onNext(1);
//                Log.e("TAG", "2");
//                e.onNext(2);
//                Log.e("TAG", "3");
//                e.onNext(3);
//                Log.e("TAG", "4");
//                e.onNext(4);
//                Log.e(TAG, "onComplete");
//                e.onComplete();
//                Log.e("TAG", "5");
//                e.onNext(5);
//            }
//        }).subscribe(new Observer<Integer>() {
//            private Disposable mDisposable;
//
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.e(TAG, "onSubscribe");
//            }
//
//            @Override
//            public void onNext(Integer value) {
//                if (value == 3) {
//                    Log.e(TAG, "onDisposed");
//                    mDisposable.dispose();
//                }
//                Log.e(TAG, "onNext" + value);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.e(TAG, "onError");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.e(TAG, "onComplete");
//            }
//        });

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                Log.e(TAG, "1" + Thread.currentThread().getName());
                e.onNext(1);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, Thread.currentThread().getName());
                    }
                });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
