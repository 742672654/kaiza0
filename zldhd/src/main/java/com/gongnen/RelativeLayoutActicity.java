package com.gongnen;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.gongnen.http.HttpCallBack2;
import com.gongnen.http.HttpManager2;
import com.zld.R;
import com.zld.ui.BaseActivity;



public class RelativeLayoutActicity extends BaseActivity implements View.OnClickListener, HttpCallBack2 {

    static final String TAG = "RelativeLayoutActicity";


    @Override
    public void onCreate(Bundle v) {
        super.onCreate(v);
        setContentView( R.layout.relative_layout);

        Button button2 = (Button)findViewById(R.id.relative_btn1);
        button2.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {


        HttpManager2.requestPOSTsynchro("http://tm.banxie.net:30002/collectorApi/orderhistory","");
    }




    @Override
    public void onResponseGET(String url, String object, String sign) {

        Log.i(TAG,"点了一下");

        Intent intent = new Intent(RelativeLayoutActicity.this, Cesi2Activity.class);
        RelativeLayoutActicity.this.startActivity(intent);

    }

    @Override
    public void onResponsePOST(String url, String object, String sign) {

    }
}