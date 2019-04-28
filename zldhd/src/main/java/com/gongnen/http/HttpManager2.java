package com.gongnen.http;


import android.app.Activity;

public class HttpManager2 {

	private static final String TAG = "HttpManager";


	public static void requestGET(String getUrl,String param,String sign, final HttpCallBack2 callBack) {


		String obj = HttpURLConnectionUtil.doGET( getUrl, param);
        callBack.onResponseGET( getUrl, obj, sign);
    }

    public static void requestPOST(String getUrl,String param,String sign, final HttpCallBack2 callBack) {


        String obj = HttpURLConnectionUtil.doPOST( getUrl, param);
        callBack.onResponsePOST( getUrl, obj, sign);
    }

    public static String requestGETsynchro(String getUrl,String param,String sign  ) {


        String obj = HttpURLConnectionUtil.doGET( getUrl, param);
        return obj;
    }

    public static String requestPOSTsynchro(String getUrl,String param  ) {


        String obj = HttpURLConnectionUtil.doPOST( getUrl, param);
        return obj;
    }

}

