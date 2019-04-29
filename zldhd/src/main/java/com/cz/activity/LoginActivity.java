package com.cz.activity;


import com.Static_bean;
import com.cz.db.LoginUserBean;
import com.cz.db.User_DB;
import com.cz.http.HttpCallBack2;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cz.db.LoginUser_DB;
import com.cz.http.HttpManager2;
import com.cz.http.okHttpUtil;
import com.cz.util.TimeUtil;
import com.google.gson.Gson;
import com.zld.R;


public class LoginActivity extends FragmentActivity implements HttpCallBack2, View.OnClickListener{

	EditText login_account_EditText;
	EditText login_password_EditText;
	EditText login_ip_EditText;
	EditText edition_EditText;

	LoginUser_DB loginUser_DB;
	User_DB user_DB;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView( R.layout.cz_login_activity);

		Button button2 = (Button)findViewById(R.id.cz_bt_longin_login);
		button2.setOnClickListener(this);

		login_account_EditText = (EditText) findViewById(R.id.cz_login_account);
		login_password_EditText = (EditText) findViewById(R.id.cz_login_password);
		login_ip_EditText = (EditText) findViewById(R.id.cz_login_ip);
		edition_EditText = (EditText) findViewById(R.id.cz_edition);

		loginUser_DB = new LoginUser_DB(this,"tcc_loginuser.db",null,1);

		user_DB = new User_DB(this,"tcc_user.db",null,1);
	}



	@Override
	public void onClick(View v) {

        	if(v.getId()!=R.id.cz_bt_longin_login){return; }

            String account = login_account_EditText.getText().toString();
            String password = login_password_EditText.getText().toString();
            String ip = login_ip_EditText.getText().toString();
			double edition = Double.parseDouble(edition_EditText.getText().toString());

			LoginUserBean loginUserBean = new LoginUserBean(account,password,ip, TimeUtil.getDateTime(),null);

			login(loginUserBean,edition,2);
	}

	/**
	 * @param loginUserBean
	 * @param type:1是手动登录，2是自动登录
	 */
	public void login(LoginUserBean loginUserBean,double edition,int type) {


		StringBuffer param = new StringBuffer();
		param.append("account=").append(loginUserBean.getAccount());
		param.append("&password=").append(loginUserBean.getPassword());
		param.append("&edition=").append(edition);
		param.append("&type=").append(type);
		param.append("&out=json");

		new okHttpUtil().doPost(this);

	}



	@Override
	public void onResponseGET(String url, String object, String sign) {

		Log.i("",object);
	}

	@Override
	public void onResponsePOST(String url, final String object, String sign) {

		Log.i("AAAA",object+"-------------");


		final LoginUserBean loginBean = (LoginUserBean)new Gson().fromJson(object, LoginUserBean.class);

		LoginActivity.this.runOnUiThread(new Runnable() {
			@Override
			public void run() {


				Toast.makeText( LoginActivity.this,loginBean.toString(),Toast.LENGTH_SHORT ).show();
			}
		});
	}
}
