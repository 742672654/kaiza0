package com.cz.activity;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cz.bean.UserBean;
import com.cz.db.User_DB;
import com.gongnen.http.HttpCallBack2;
import com.zld.R;


public class LoginActivity extends FragmentActivity implements HttpCallBack2 , View.OnClickListener{


	EditText login_account;
	EditText login_password;
	EditText login_ip;
	User_DB user_DB;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView( R.layout.cz_login_activity);

		Button button2 = (Button)findViewById(R.id.cz_bt_longin_login);
		button2.setOnClickListener(this);

		login_account = (EditText) findViewById(R.id.cz_login_account);
		login_password = (EditText) findViewById(R.id.cz_login_password);
		login_ip = (EditText) findViewById(R.id.cz_login_ip);

		user_DB=new User_DB(this,"tcc_user.db",null,1);

	}



	@Override
	public void onClick(View v) {




		user_DB.insert_LocalUser(new UserBean("acc01","pass01","ip01"));

		user_DB.update_LocalUser(new UserBean("acc02","pass02","ip02"));
		user_DB.query_LocalUser();
		Toast.makeText(this,user_DB.query_LocalUser().toString(),Toast.LENGTH_LONG).show();
	}



	@Override
	public void onResponseGET(String url, String object, String sign) {

	}

	@Override
	public void onResponsePOST(String url, String object, String sign) {

	}

}
