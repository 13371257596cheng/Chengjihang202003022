package com.bawei.chengjihang.base;

import java.lang.ref.WeakReference;

public abstract class BasePrepresenter <V extends BaseView> {
    private WeakReference<V> weakReference;

    public BasePrepresenter(V v){
        weakReference=new WeakReference<>(v);
        initModel();
    }

    public void detachView(){
        if (weakReference!=null){
            weakReference.clear();
            weakReference=null;
        }
    }

    public V getView(){
        return weakReference.get();
    }


    protected abstract void initModel();


    public abstract void getData(String path);
}
