package com.example.weekonel.model;

import com.example.weekonel.entity.DataBean;
import com.example.weekonel.utils.RestrofitUtils;
import com.example.weekonel.utils.UtilsCallBack;
import com.google.gson.Gson;

import java.util.HashMap;

public class DataModelImpl implements DataModel{
    @Override
    public void getData(String url, HashMap<String, String> map, final UtilsCallBack utilsCallBack) {

        RestrofitUtils.getInstance().doGet(url,map).setHttpListener(new RestrofitUtils.HttpListener() {
            @Override
            public void onSuccess(String result) {
                DataBean dataBean = new Gson().fromJson(result, DataBean.class);
                utilsCallBack.success(dataBean);
            }

            @Override
            public void onError(String error) {
                utilsCallBack.defeated(error);
            }
        });

    }
}
