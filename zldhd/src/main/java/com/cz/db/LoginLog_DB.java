package com.cz.db;

import android.util.Log;


public class LoginLog_DB{

    private final static String TAG = "LoginLog_DB";

    public static void insert_log( LoginLog_Bean loginLog){

        String sql = new StringBuffer(" INSERT INTO loginlogs(account, login_time, login_type, record) VALUES ( ")
                .append(" '").append(loginLog.getAccount()).append("', ")
                .append(" '").append(loginLog.getOperation_time()).append("', ")
                .append(" '").append(loginLog.getLogin_type()).append("', ")
                .append(" '").append(loginLog.getRecord()).append("')").toString();;

        Log.i(TAG+22,"执行"+sql);
        BaseSQL_DB.baseSQL_DB.getWritableDatabase().execSQL(sql);
    }



}
