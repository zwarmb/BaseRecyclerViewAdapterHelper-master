package com.example.yida.dagger2demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Person mPerson;
//    @Inject
//    Person mPerson1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("", "weishabndhauhd");
        Toast.makeText(this, "你好要我怎么样", Toast.LENGTH_SHORT).show();
//        mPerson = new Person();


        MainComponent component = DaggerMainComponent.builder().mainModule(new MainModule(this)).build();
        component.inject(this);
    }
}
