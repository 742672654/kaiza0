package com.cz.http;


import android.util.Log;
import java.io.IOException;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class OkHttpUtil {

    private final static String TAG = "OkHttpUtil";


    public String doPost(final String url, final Map<String,String> param, final HttpCallBack2 httpCallBack2, final String sign){


        Log.i(TAG,url+"----"+param);

        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody.Builder buil = new FormBody.Builder();

        //添加参数
        for (Map.Entry<String, String> entry : param.entrySet()) {
            buil.add(entry.getKey(), entry.getValue());
        }

        Request request = new Request.Builder().url(url).post(buil.build()).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: " + e.getMessage());
                httpCallBack2.onResponsePOST(url,param,sign,null);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, response.protocol() + " " +response.code() + " " + response.message());
                Headers headers = response.headers();
                for (int i = 0; i < headers.size(); i++) {
                    Log.d(TAG, headers.name(i) + ":" + headers.value(i));
                }
                httpCallBack2.onResponsePOST(url,param,sign,response.body().string());
            }
        });





        return null;
    }





}
