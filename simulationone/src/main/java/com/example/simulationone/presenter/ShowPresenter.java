package com.example.simulationone.presenter;

import android.util.Log;

import com.example.simulationone.activity.ShowActivity;
import com.example.simulationone.contract.ShowContract;
import com.example.simulationone.entity.ShowBean;
import com.example.simulationone.model.ShowModel;
import com.example.simulationone.utile.OkHttpCallback;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

public class ShowPresenter  {
    private ShowModel showModel;
    private ShowContract.IShowView iShowView;

    public ShowPresenter(ShowContract.IShowView iShowView) {
        showModel =new ShowModel();
        this.iShowView=iShowView;
    }

    public void  getShow(String keyword,int page,int count ){
        Type type=new TypeToken<ShowBean>(){}.getType();
        showModel.getShow(keyword, page, count, new OkHttpCallback() {
            @Override
            public void success(Object obj) {
                ShowBean showBean= (ShowBean) obj;
                if (showBean!=null){
                    iShowView.success(showBean);
                }
            }

            @Override
            public void failure(String error) {

            }
        },type);
    }

   /* @Override
    public void getShow(String keyword,int page,int count) {

        showModel.getShow(keyword, page, count, new OkHttpCallback() {
            @Override
            public void success(Object obj) {
                ShowBean showBean= (ShowBean) obj;
                if(showBean!=null){
                    iShowView.success((List<ShowBean.ResultBean>) showBean);
                }
            }

            @Override
            public void failure(String error) {

            }




        },type);*/

}
