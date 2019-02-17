package com.example.weekonel.model;

import com.example.weekonel.utils.UtilsCallBack;

import java.util.HashMap;

public interface DataModel {
    void getData(String url, HashMap<String,String> map, UtilsCallBack utilsCallBack);
}
