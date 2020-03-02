package com.bawei.chengjihang.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bawei.chengjihang.R;
import com.bawei.chengjihang.base.BaseActivity;
import com.bawei.chengjihang.base.BasePrepresenter;
import com.bawei.chengjihang.bean.Bean;
import com.bawei.chengjihang.contract.MyContract;
import com.bawei.chengjihang.presenter.MyPresenter;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends BaseActivity implements MyContract.IView {


    private RecyclerView lv;
    private ImageView iv1;
    private ImageView iv2;

    @Override
    protected int getReasuce() {
        return R.layout.activity_main;
    }
    //初始化控件
    @Override
    protected void getid() {
        lv = findViewById(R.id.lv);
        iv1 = findViewById(R.id.iv1);
        iv2 = findViewById(R.id.iv2);
    }
    //获取数据
    @Override
    protected void getData() {
        String path="http://blog.zhaoliang5156.cn/api/shop/jingdong.json";
        Log.i("xxx",path+"");
        BasePrepresenter prepresenter=getPresenter();
        if (prepresenter!=null && prepresenter instanceof  BasePrepresenter){
            prepresenter.getData(path);
        }

        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "169", Toast.LENGTH_SHORT).show();
            }
        });
        
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "139", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    protected BasePrepresenter initPresenter() {
        return new MyPresenter(this);
    }

    @Override
    public void getSuccess(String str) {
        Log.i("xxx",str);
        //解析
        Gson gson=new Gson();
        Bean bean=gson.fromJson(str,Bean.class);
        String beans=bean.getCode();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false);
        lv.setLayoutManager(linearLayoutManager);

    }

    @Override
    public void getError(String str) {
        byte[] bannerdata;
//        Glide.with(MainActivity.this).load(bannerdata.getClass().getResource())
    }
}
