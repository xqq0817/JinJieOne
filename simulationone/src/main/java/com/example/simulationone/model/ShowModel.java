package com.example.simulationone.model;

import android.os.Handler;

import com.example.simulationone.api.API;
import com.example.simulationone.contract.ShowContract;
import com.example.simulationone.utile.OkHttpCallback;
import com.example.simulationone.utile.OkHttpUtils;

import java.lang.reflect.Type;
import java.util.HashMap;

public class ShowModel  {
    private Handler handler=new Handler();

    public void getShow( String keyword,int page,int count, final OkHttpCallback callback, Type type) {
        String  url=API.SHOW_API+"?keyword="+keyword+"&page="+page+"&count="+count;
        OkHttpUtils.getmInstance().doget(url,callback,type);
    }

    //接口
    public interface ShowModelCallback{
        void success(String result);
        void failure(String msg);
    }
}
