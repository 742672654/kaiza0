package com.cz.http;

import java.util.Map;


public class HttpManager2 {

    private static final String TAG = "HttpManager";


    public static void requestPost(String url, Map<String,String> param, final HttpCallBack2 callBack, String sign) {


        new OkHttpUtil().doPost(url,  param, new HttpCallBack2(){


            @Override
            public void onResponseGET(String url,String param, String object, String sign) {

                callBack.onResponseGET(url,  param, object,  sign);
            }

            @Override
            public void onResponsePOST(String url, Map<String,String> param,String object, String sign) {

                callBack.onResponsePOST(url,  param, object,  sign);
            }

            @Override
            public void onResponseFile(String url,Map<String,String> param, String object, String sign) {

                callBack.onResponseFile(url,  param, object,  sign);
            }
        }, sign);

    }


}



