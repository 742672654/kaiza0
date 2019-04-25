package com.gongnen;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.vz.PlateResult;
import com.vz.tcpsdk;
import com.zld.R;
import com.zld.decode.DecodeThread;
import com.zld.photo.DecodeManager;
import com.zld.ui.BaseActivity;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;


public class RelativeLayoutActicity extends BaseActivity implements View.OnClickListener  {

    @Override
    public void onCreate(Bundle v) {
        super.onCreate(v);
        setContentView( R.layout.relative_layout);

        Button button2 = (Button)findViewById(R.id.relative_btn1);
        button2.setOnClickListener(this);

        t = new tcpsdk();
        s0 = t.setup();
        s1 =  t.open("192.168.1.211".getBytes(),"192.168.1.211".length() , 8131, "admin".getBytes(), "admin".length(), "admin".getBytes(), "admin".length());

        //设置拍照回调
        new DecodeThread().yitijiThread("192.168.1.211");

        try {
            //拍照
            Thread.sleep(2000);
            DecodeManager.getinstance().getOneImg("192.168.1.211");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }





        /**
         *  @brief 设置脱机结果的回调函数
         *  @param  [IN] handle 由open函数获得的句柄
         *  @param  [IN] onDataReceiver 识别结果回调函数，如果为NULL，则表示关闭该回调函数的功能
         *  @param  [IN] bEnableImage 指定识别结果的回调是否需要包含截图信息：1为需要，0为不需要
         *  @return 0表示成功，-1表示失败
         *  @ingroup group_device
         */
        // public native int setPlateInfoCallBack( int handle,  OnDataReceiver  onDataReceiver ,int bEnableImage);

        t.setPlateInfoCallBack(s1,new sss(),1);




    }


    tcpsdk t;
    int s0;
    int s1;

    @Override
    public void onClick(View v) {

        try{


            /**
             *  @brief 设置IO输出，并自动复位
             *  @param  [IN] handle 由open函数获得的句柄
             *  @param  [IN] uChnId IO输出的通道号，从0开始
             *  @param  [IN] nDuration 延时时间，取值范围[500, 5000]毫秒
             *  @return 0表示成功，-1表示失败
             *  @ingroup group_device
             */
            // public native  int  setIoOutputAuto(int handle, short uChnId, int nDuration)
            short a1 = 0;
           // int s2 = t.setIoOutputAuto(s1, a1, 800);

            //int s3 = t.forceTrigger(s1);

            int[] i1 = {0};
            int s4 = t.getIoOutput(s1, a1, i1);

            Toast.makeText(this,s0+"------"+s1+"--------"+s4+"----"+i1[0],Toast.LENGTH_SHORT).show();





        }catch (Exception e){

            e.printStackTrace();
        }
      //  DecodeManager.getinstance().controlPole(DecodeManager.openPole, "192.168.1.199");
    }
}

class sss implements tcpsdk.OnDataReceiver{


    @Override
    public void onDataReceive(int handle, PlateResult plateResult, int uNumPlates, int eResultType, byte[] pImgFull, int nFullSize, byte[] pImgPlateClip, int nClipSize) throws UnsupportedEncodingException {



        String plateText = new String(plateResult.license,"GBK");

        new FileSave().seve("zaopian.txt",new String(Base64.encodeBase64(pImgFull)));


        Log.i("获取到车牌号", plateText);
    }
}