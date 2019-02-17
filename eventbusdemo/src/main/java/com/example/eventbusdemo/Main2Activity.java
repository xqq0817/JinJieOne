package com.example.eventbusdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void to1(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("post:"+Thread.currentThread().getName());
                EventBus.getDefault().post("我是2的数据111");
                EventBus.getDefault().post("我是2的数据222");
                EventBus.getDefault().post("我是2的数据333");
            }
        }).start();
        this.finish();
    }

}
