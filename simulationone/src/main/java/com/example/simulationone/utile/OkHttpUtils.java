package com.example.simulationone.utile;

import android.os.Handler;

import com.example.simulationone.api.API;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpUtils {
    private Handler handler=new Handler();
    private static OkHttpUtils mInstance;
    private final OkHttpClient okHttpClient;

    //私有构造
    private OkHttpUtils(){
        //日志拦截器
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                //日志拦截器
                .addInterceptor(interceptor)
                //写
                .readTimeout(5,TimeUnit.SECONDS)
                //读
                .writeTimeout(5,TimeUnit.SECONDS)
                //超时
                .connectTimeout(5,TimeUnit.SECONDS)
                .build();
    }
    //单例模式
    public static OkHttpUtils getmInstance() {
        if (mInstance==null){
            synchronized (OkHttpUtils.class){
                if (mInstance==null){
                    mInstance=new OkHttpUtils();
                }
            }
        }
        return mInstance;
    }
    public void  doget(String url, final OkHttpCallback okHttpCallback, final Type type){
        Request request=new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        okHttpCallback.failure("网络异常了哟");
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson=new Gson();
                final Object o = gson.fromJson(string, type);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        okHttpCallback.success(o);
                    }
                });

            }
        });


    }





}
