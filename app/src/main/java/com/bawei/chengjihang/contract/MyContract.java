package com.bawei.chengjihang.contract;

import com.bawei.chengjihang.base.BaseView;

public interface MyContract {
    interface IView extends BaseView{
        void getSuccess(String str);
        void getError(String str);
    }

    interface IPresenter{
        void getData(String path);
    }

    interface Imodel{
        void getData(String path,IModelCallBack callBack);
    }
    interface  IModelCallBack{
        void getSuccess(String str);
        void getError(String str);
    }

}
