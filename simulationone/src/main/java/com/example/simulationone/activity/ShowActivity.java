package com.example.simulationone.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.simulationone.R;
import com.example.simulationone.adapter.ShowAdapter;
import com.example.simulationone.contract.ShowContract;
import com.example.simulationone.entity.ShowBean;
import com.example.simulationone.presenter.ShowPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShowActivity extends AppCompatActivity implements ShowContract.IShowView {

    private XRecyclerView xrv;
    private ShowPresenter presenter;
    private ShowAdapter adapter;
    private String  keyword="板鞋";
    private   int count=10;
    private List<ShowBean.ResultBean> list;
    private Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        //获取资源ID
        initView();
        presenter = new ShowPresenter(this);
        presenter.getShow(keyword,count,10 );

    }


    private void initView() {

        list=new ArrayList<>();
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        xrv.setLayoutManager(layoutManager);
        adapter = new ShowAdapter(this, list);


        xrv.setAdapter(adapter);
        xrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                count = 1;
                presenter.getShow(keyword, count, 10);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                       xrv .refreshComplete();
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore() {
                count++;
                presenter.getShow(keyword, count, 10);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xrv.loadMoreComplete();
                    }
                }, 2000);
            }
        });
    }



    @Override
    public void success(ShowBean showBean) {
        if (showBean != null) {
            if (count == 1) {
                list.clear();
            }
            list.addAll(showBean.data);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void failure(String error) {

    }
}
