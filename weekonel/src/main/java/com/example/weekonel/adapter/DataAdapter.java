package com.example.weekonel.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.weekonel.R;
import com.example.weekonel.entity.DataBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyVh> {
    private Context context;
    private List<DataBean.ResultBean> data;

    public DataAdapter(Context context, List<DataBean.ResultBean> data) {
        this.context = context;
        this.data = data;
    }
    @NonNull
    @Override
    public DataAdapter.MyVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.dataadapter, null);
        return new MyVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.MyVh myVh, int i) {
        myVh.simp.setImageURI(data.get(i).getMasterPic());
        myVh.tv_name.setText(data.get(i).getCommodityName());
        myVh.tv_money.setText("￥"+data.get(i).getPrice());
        myVh.tv_shou.setText("已售"+data.get(i).getSaleNum()+"件");

        myVh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyVh extends RecyclerView.ViewHolder {

        private SimpleDraweeView simp;
        private TextView tv_name;
        private TextView tv_money;
        private TextView tv_shou;

        public MyVh(@NonNull View itemView) {
            super(itemView);
            simp = itemView.findViewById(R.id.simp);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_money = itemView.findViewById(R.id.tv_money);
            tv_shou = itemView.findViewById(R.id.tv_shou);
        }
    }
}
