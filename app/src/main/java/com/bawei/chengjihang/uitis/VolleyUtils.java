package com.bawei.chengjihang.uitis;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.chengjihang.base.App;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;

public class VolleyUtils {
    RequestQueue mQueue;

    private VolleyUtils(){
        mQueue= Volley.newRequestQueue(App.getContext());
    }

    private static class SingleInstance{
        private static VolleyUtils INSTANCE=new VolleyUtils();
    }

    public static VolleyUtils getInstance(){
        return  SingleInstance.INSTANCE;
    }

    public void doGet(final String url, final ICallBack iCallBack){
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        iCallBack.getSuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                iCallBack.getError(error.getMessage());
            }
        });
    }

    public void doPost(String url, final HashMap<String,String> map, final ICallBack iCallBack){
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        iCallBack.getSuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                iCallBack.getError(error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        mQueue.add(stringRequest);
    }



    //接口
    public interface ICallBack{
        //成功
        void getSuccess(String json);
        //失败
        void getError(String msg);
    }


}
