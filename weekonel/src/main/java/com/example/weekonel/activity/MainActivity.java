package com.example.weekonel.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weekonel.R;
import com.example.weekonel.adapter.DataAdapter;
import com.example.weekonel.api.API;
import com.example.weekonel.entity.DataBean;
import com.example.weekonel.presenter.DataPresenterImpl;
import com.example.weekonel.view.DataView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;

public class MainActivity<T> extends AppCompatActivity implements View.OnClickListener, DataView<T> {

    private EditText edText;
    private Button butSou;
    private XRecyclerView xrecyclerview;
    private DataPresenterImpl dataPresenter;
    private String trim;
    private DataAdapter dataAdapter;
    private ImageView tv_cai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //资源ID
        initView();
        dataPresenter = new DataPresenterImpl(this);

    }

    @Override
    public void onClick(View v) {
        trim = edText.getText().toString().trim();
        HashMap<String, String> map = new HashMap<>();
        map.put("keyword",trim);
        map.put("page","1");
        map.put("count","10");
        switch (v.getId()){
            case R.id.but_sou:
                dataPresenter.setData(API.SHANG_URL,map);
                break;
        }
    }

    @Override
    public void success(T result) {
        if (result instanceof DataBean){
            DataBean dataBean=(DataBean) result;
            dataAdapter = new DataAdapter(this, dataBean.getResult());
            xrecyclerview.setAdapter(dataAdapter);
            xrecyclerview.setLayoutManager(new GridLayoutManager(this,2));
        }
    }

    @Override
    public void defeated(T error) {

    }
    //资源ID
    private void initView() {
        tv_cai = findViewById(R.id.tv_cai);
        edText = (EditText) findViewById(R.id.ed_text);
        butSou = (Button) findViewById(R.id.but_sou);
        xrecyclerview = (XRecyclerView) findViewById(R.id.xrecyclerview);

        butSou.setOnClickListener(this);
    }
}
