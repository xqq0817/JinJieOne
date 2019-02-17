package com.example.weekonel.api;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

public interface MyApiService {
    @GET
    Observable<ResponseBody> doGet(@Url String url, @QueryMap HashMap<String,String> map);
}
