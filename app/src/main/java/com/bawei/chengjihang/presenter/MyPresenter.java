package com.bawei.chengjihang.presenter;

import com.bawei.chengjihang.base.BasePrepresenter;
import com.bawei.chengjihang.base.BaseView;
import com.bawei.chengjihang.contract.MyContract;
import com.bawei.chengjihang.model.MyModel;

public class MyPresenter  extends BasePrepresenter implements MyContract.IPresenter {
    private MyModel myModel;

    public MyPresenter(BaseView baseView) {
        super(baseView);
    }

    @Override
    protected void initModel() {
        myModel=new MyModel();
    }

    @Override
    public void getData(String path) {
            myModel.getData(path, new MyContract.IModelCallBack() {
                @Override
                public void getSuccess(String str) {
                    BaseView view=getView();
                    if (view instanceof MyContract.IView){
                        ((MyContract.IView) view).getSuccess(str);
                    }
                }

                @Override
                public void getError(String str) {
                    BaseView view=getView();
                    if (view instanceof  MyContract.IView){
                        ((MyContract.IView) view).getError(str);
                    }
                }
            });
    }
}
