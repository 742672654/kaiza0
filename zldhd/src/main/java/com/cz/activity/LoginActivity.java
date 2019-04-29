package com.cz.activity;


import com.Static_bean;
import com.cz.bean.LoginUserBean;
import com.cz.http.HttpCallBack2;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cz.db.LoginUser_DB;
import com.cz.http.HttpManager2;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zld.R;
import com.zld.bean.InformationBean;

import java.util.List;


public class LoginActivity extends FragmentActivity implements HttpCallBack2, View.OnClickListener{


	EditText login_account_EditText;
	EditText login_password_EditText;
	EditText login_ip_EditText;
	EditText edition_EditText;


	LoginUser_DB loginUser_DB;



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


		loginUser_DB=new LoginUser_DB(this,"tcc_user.db",null,1);

	}



	@Override
	public void onClick(View v) {

        	if(v.getId()!=R.id.cz_bt_longin_login){return; }

            String account = login_account_EditText.getText().toString();
            String password = login_password_EditText.getText().toString();
            String ip = login_ip_EditText.getText().toString();
			int edition = Integer.parseInt(edition_EditText.getText().toString());

			loginUser_DB=new LoginUser_DB(this,"tcc_loginuser.db",null,1);

            StringBuffer param = new StringBuffer();
				param.append("account=").append(account);
				param.append("&password=").append(password);
				param.append("&edition=").append(edition);
				param.append("&out=json");

			String  result = HttpManager2.requestPOSTsynchro(Static_bean.login,param.toString());

			LoginUserBean loginUserBean = new Gson().fromJson(result, LoginUserBean.class);

	}

	public void login(String url, String object, String sign) {

	}



	@Override
	public void onResponseGET(String url, String object, String sign) {

	}

	@Override
	public void onResponsePOST(String url, String object, String sign) {

	}
}
