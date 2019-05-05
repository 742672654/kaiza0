package com.gongnen;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cz.http.HttpCallBack2;
import com.zld.R;
import com.zld.ui.ZldNewActivity;

import java.util.Map;


public class CesiActivity extends AppCompatActivity implements View.OnClickListener, HttpCallBack2 {


    private final String TAG="CesiActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cesi);
        initView();
    }


    @Override
    public void  onClick(View view){

        Toast.makeText(this,"点了一下",Toast.LENGTH_LONG).show();

    }

    private void initView(){
        Button button = (Button)findViewById(R.id.createBtn);
        Button  insertBtn = (Button)findViewById(R.id.insertBtn);
        Button  deleteBtn = (Button)findViewById(R.id.deleteBtn);
        Button  updateBtn = (Button)findViewById(R.id.updateBtn);
        Button  queryBtn = (Button)findViewById(R.id.queryBtn);
        button.setOnClickListener(this);
        insertBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
        updateBtn.setOnClickListener(this);
        queryBtn.setOnClickListener(this);
    }


    @Override
    public void onResponseGET(String url, String param, String sign, String object) {
        Intent intent = new Intent(this, ZldNewActivity.class);

        this.startActivity(intent);

    }

    @Override
    public void onResponsePOST(String url, Map<String, String> param, String sign, String object) {

    }

    @Override
    public void onResponseFile(String url, Map<String, String> param, String sign, String object) {

    }
}
