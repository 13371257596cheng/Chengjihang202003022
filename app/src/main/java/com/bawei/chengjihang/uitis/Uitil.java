package com.bawei.chengjihang.uitis;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.chengjihang.base.App;
import com.bumptech.glide.util.Util;

import java.io.UnsupportedEncodingException;

public class Uitil {
    RequestQueue requestQueue;
    private Uitil(){
        requestQueue= Volley.newRequestQueue(App.getContext());
    }

    private static class SingTance{
        private static Uitil util=new Uitil();
    }
    public static Uitil getInstance(){
        return SingTance.util;
    }

    public interface ICallBack{
        void getSuccess(String str);
        void getError(String str);
    }

    public void doGet(String path, final ICallBack iCallBack){
        StringRequest request=new StringRequest(Request.Method.GET, path, new Response.Listener<String>() {
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
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                String a;
                try {
                    a=new String(response.data,"UTF-8");
                } catch (Exception e) {
                    e.printStackTrace();
                    a=new String(response.data);
                }
                return Response.success(a, HttpHeaderParser.parseCacheHeaders(response));
            }
        };
        requestQueue.add(request);
    }




}
