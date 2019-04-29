package com.cz.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class User_DB extends SQLiteOpenHelper {

    private final static String TAG = "User_DB";

    public static final String CREATE_TEBLE = "create table tcc_loginuser(account text,account text, logontime text,qr text,role text,iscancel text,notemsg text)";



    public void insert_LocalLoginUser( LoginUserBean userBean ){
        deleteAll_LocalUser();

        StringBuffer buf = new StringBuffer("insert into tcc_user(account, password, ip, login_time, out_time)");
        buf.append("values('").append(userBean.getAccount()).append("',");
        buf.append("'").append(userBean.getPassword()).append("',");
        buf.append("'").append(userBean.getIp()).append("',");
        buf.append("'").append(userBean.getLogin_time()).append("',");
        buf.append("'").append(userBean.getOut_time()).append("');");
        getWritableDatabase().execSQL(buf.toString());
    }

    public void deleteAll_LocalUser(){

        getWritableDatabase().execSQL("delete from tcc_user where 1=1;");
    }

    public void update_LocalLoginUser( LoginUserBean userBean ){

        deleteAll_LocalUser();
        insert_LocalLoginUser( userBean );
    }

    public LoginUserBean query_LocalLoginUser(){

        Cursor cursor = null;
        try {

            cursor = this.getWritableDatabase().rawQuery("select * from tcc_user", null);
            cursor.moveToFirst();

            LoginUserBean userBean = new LoginUserBean();
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






    // TODO: 下面是默认构造方法
    public User_DB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override   // TODO: 创建数据库
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TEBLE);
    }


    @Override   // TODO: 数据库不存在就创建
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL(" drop table if exists tcc_user");
        onCreate(sqLiteDatabase);
    }



}
