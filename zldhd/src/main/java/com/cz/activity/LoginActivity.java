package com.cz.activity;


import com.Static_bean;
import com.cz.bean.UserBean;
import com.cz.db.BaseSQL_DB;
import com.cz.db.LoginLog_Bean;
import com.cz.db.LoginLog_DB;
import com.cz.db.LoginUser_Bean;
import com.cz.db.User_DB;
import com.cz.http.HttpCallBack2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cz.db.LoginUser_DB;
import com.cz.http.HttpManager2;
import com.cz.util.TimeUtil;
import com.google.gson.Gson;
import com.zld.R;
import java.util.HashMap;
import java.util.Map;


public class LoginActivity extends FragmentActivity implements HttpCallBack2, View.OnClickListener{

	private final static String TAG = "LoginActivity";

	EditText login_account_EditText;
	EditText login_password_EditText;
	EditText login_ip_EditText;
	EditText edition_EditText;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView( R.layout.cz_login_activity);

		initView();
		automatic_login();
	}

	@Override
	public void onClick(View v) {

        	if(v.getId()!=R.id.cz_bt_longin_login){return; }

            String account = login_account_EditText.getText().toString();
            String password = login_password_EditText.getText().toString();
            String ip = login_ip_EditText.getText().toString();
			double edition = Double.parseDouble(edition_EditText.getText().toString());

		LoginUser_Bean loginUserBean = new LoginUser_Bean(account,password,ip, TimeUtil.getDateTime(),null);
			login(loginUserBean,edition,2);
	}

	private void initView(){
		Button button2 = (Button)findViewById(R.id.cz_bt_longin_login);
		button2.setOnClickListener(this);

		login_account_EditText = (EditText) findViewById(R.id.cz_login_account);
		login_password_EditText = (EditText) findViewById(R.id.cz_login_password);
		login_ip_EditText = (EditText) findViewById(R.id.cz_login_ip);
		edition_EditText = (EditText) findViewById(R.id.cz_edition);



		 new BaseSQL_DB(this,"parking.db",null,1);

	}


	private void automatic_login(){

		LoginUser_Bean loginUser = LoginUser_DB.query_LocalLoginUser();
		if(loginUser!=null && loginUser.getAccount()!=null){
			double edition = Double.parseDouble(edition_EditText.getText().toString());
			login(loginUser,edition,2);
		}
	}

	/**
	 * @param loginUserBean
	 * @param edition:版本号
	 * @param type:1是手动登录，2是自动登录
	 */
	private void login(LoginUser_Bean loginUserBean,Double edition,Integer type) {


		Map<String,String> param = new HashMap<String,String>();
			param.put("username",loginUserBean.getAccount());
			param.put("password",loginUserBean.getPassword());
			param.put("edition",edition.toString());
			param.put("type",type.toString());
			param.put("out","json");

		HttpManager2.requestPost(Static_bean.login,param, this, "login");

	}


	@Override
	public void onResponseGET(String url, String param, String sign, String object) {

	}

	@Override
	public void onResponsePOST(String url, final Map<String,String> param, String sign, String object) {

		final UserBean userBean = (UserBean)new Gson().fromJson(object, UserBean.class);

		LoginActivity.this.runOnUiThread(new Runnable() {
			@Override
			public void run() {

			if(userBean.getInfo()!=null && userBean.getInfo().equals("success")){
				userBean.setAccount(param.get("username"));
				userBean.setPassword(param.get("password"));

				//添加到现在登录的用户中
				LoginUser_Bean login = new LoginUser_Bean(userBean.getAccount(),userBean.getPassword(),login_ip_EditText.getText().toString(),userBean.getLogontime(),null);
				LoginUser_DB.insert_LocalLoginUser( login );

				//添加到常驻用户
				User_DB.insert_User(userBean);

				//添加到登录日志
				LoginLog_Bean loginLog = new LoginLog_Bean(userBean.getAccount(),TimeUtil.getDateTime(),Integer.parseInt(param.get("type")),new Gson().toJson(userBean));
				LoginLog_DB.insert_log( loginLog );

				Intent intent = new Intent(LoginActivity.this,ChooseWorkstation2Activity.class);
//				intent.putExtra("s1","这个是s1");
//				intent.putExtra("s3",465465);
				UserBean user = new UserBean();
				intent.putExtra("userBean",user);
				LoginActivity.this.startActivity(intent);
			}else{

				Toast.makeText( LoginActivity.this,userBean.getInfo(),Toast.LENGTH_SHORT ).show();
			}
			}
		});
	}

	@Override
	public void onResponseFile(String url, Map<String, String> param, String sign, String object) {

	}


}
