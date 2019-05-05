package com.cz.db;


import android.database.Cursor;
import android.util.Log;


public class LoginUser_DB {

    private final static String TAG = "LoginUser_DB";


    public static void insert_LocalLoginUser( LoginUser_Bean userBean ){

        deleteAll_LocalUser();

        StringBuffer buf = new StringBuffer("insert into loginuser(account, password, ip, login_time, out_time)");
            buf.append("values('").append(userBean.getAccount()).append("',");
            buf.append("'").append(userBean.getPassword()).append("',");
            buf.append("'").append(userBean.getIp()).append("',");
            buf.append("'").append(userBean.getLogin_time()).append("',");
            buf.append("'").append(userBean.getOut_time()).append("');");

        Log.i(TAG+24,"执行"+buf.toString());
        BaseSQL_DB.baseSQL_DB.getWritableDatabase().execSQL(buf.toString());
    }

    public static void deleteAll_LocalUser(){

        BaseSQL_DB.baseSQL_DB.getWritableDatabase().execSQL("delete from loginuser where 1=1;");
    }

    public static void update_LocalLoginUser( LoginUser_Bean userBean ){

        deleteAll_LocalUser();
        insert_LocalLoginUser( userBean );
    }

    public static LoginUser_Bean query_LocalLoginUser(){

        Cursor cursor = null;
        try {

            cursor = BaseSQL_DB.baseSQL_DB.getWritableDatabase().rawQuery("select * from loginuser", null);
            cursor.moveToFirst();

            LoginUser_Bean userBean = new LoginUser_Bean();
            userBean.setAccount(cursor.getString(cursor.getColumnIndex("account")));
            userBean.setPassword(cursor.getString(cursor.getColumnIndex("password")));
            userBean.setIp(cursor.getString(cursor.getColumnIndex("ip")));
            userBean.setLogin_time(cursor.getString(cursor.getColumnIndex("login_time")));
            userBean.setOut_time(cursor.getString(cursor.getColumnIndex("out_time")));

            return userBean;
        }catch ( Exception e){

            e.printStackTrace();
            return null;
        }finally {
            if (cursor!=null){ cursor.close(); }
        }
    }




}
