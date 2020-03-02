package com.bawei.chengjihang.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public  abstract class BaseActivity <P extends BasePrepresenter> extends AppCompatActivity implements BaseView {
    private P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getReasuce());//获取布局文件

        presenter=initPresenter();
        //初始化控件
        getid();
        //获取数据
        getData();

    }

    public P getPresenter(){
        return presenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.detachView();
            presenter=null;
        }
    }
    //获取布局文件
    protected abstract int getReasuce();
    //初始化控件
    protected abstract void getid();
    //获取数据
    protected abstract void getData();

    protected abstract P initPresenter();

}
