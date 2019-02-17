package com.example.simulationone.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.simulationone.R;
import com.example.simulationone.entity.ShowBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ShowAdapter extends XRecyclerView.Adapter<ShowAdapter.MyVh> {
    private Context context;
    private List<ShowBean.ResultBean> list;

    /*public void setAdapter(Context context) {
        this.context = context;
        this.list=new ArrayList<>();
    }*/

    public ShowAdapter(Context context, List<ShowBean.ResultBean> list) {
        this.context = context;
        this.list=new ArrayList<>();
    }

    public void setData(List<ShowBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ShowAdapter.MyVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.show_item_layout,viewGroup,false);
        return new MyVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowAdapter.MyVh myVh,final int i) {
        ShowBean.ResultBean resultBean = list.get(i);
            Glide.with(context).load(resultBean.masterPic).into(myVh.image);

        myVh.title.setText(resultBean.commodityName);
        myVh.price.setText(resultBean.price);

    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    public class MyVh extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView title;
        private TextView price;

        public MyVh(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
        }
    }
}
