package com.bawei.chengjihang.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.chengjihang.R;
import com.bawei.chengjihang.bean.Bean;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<Bean.DataBean> list=new ArrayList<>();
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }
    //判断用哪一个布局
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
//        if (viewHolder==0){
//            View view =View.inflate(context, R.layout.item1,null);
//            RecyclerView.ViewHolder=new VirtualMachineError();
//            return;viewHolder;
//        }
    }

    @Override
    public int getItemCount() {
//        Shop shop=null;



        return 0;
    }
    class Shop{
        ImageView iv;
        TextView text1;
        TextView text2;
    }
}
