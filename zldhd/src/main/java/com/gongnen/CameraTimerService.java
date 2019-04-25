package com.gongnen;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vz.tcpsdk;
import com.zld.bean.AppInfo;
import com.zld.bean.InformationBean;
import com.zld.bean.PARKING_ip_Bean;
import com.zld.lib.constant.Constant;
import com.zld.photo.DecodeManager;
import java.util.List;



public class CameraTimerService extends Service {

    private static final String TAG = "CameraTimerService";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    static  tcpsdk  tsdk = null;
    static  int  sxt_handle = 0;

    @Override
    public void onCreate() {
        super.onCreate();


            // 获取当前停车场的IP
            new Thread(){
                public void run(){

                    StringBuffer buffer = new StringBuffer("comid=").append(AppInfo.getInstance().getComid());
                    String jsonList = new HttpURLConnectionUtil().doPOST(Constant.requestUrl+Constant.WhitelistInformation_URL, buffer.toString());

                    Gson gson1=new Gson();
                    List<InformationBean> list= gson1.fromJson(jsonList, new TypeToken<List<InformationBean>>() {}.getType());

                    PARKING_ip_Bean.PARKING_ip=list;

                    Log.v("拍照监听--",PARKING_ip_Bean.PARKING_ip.toString());

                }
            }.start();

    }




    int[] i1 = new int[]{3};
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        if (PARKING_ip_Bean.getEntrance(1)==null){
            return super.onStartCommand(intent, flags, startId);
        }

        try{

            if(tsdk == null){
                //开启出口摄像头控制
                tsdk = new tcpsdk();
                //tsdk.setup();
                InformationBean info = PARKING_ip_Bean.getEntrance(1);
                sxt_handle = tsdk.open( info.getIp().getBytes(),info.getIp().length() , 8131,
                        info.getCusername().getBytes(),info.getCusername().length(),
                        info.getCpassword().getBytes(), info.getCpassword().length());
                Log.v(TAG+"39999","初始化:"+sxt_handle);
            }
        }catch (Exception e){
            e.printStackTrace();
            Log.v(TAG+"39999","报错了");
        }


        //因为1是开路，0是闭路
        i1[0]=3;

        //检测是否有车辆压倒地感
       int s2 = tsdk.getIoOutput(sxt_handle, 0, i1);
        Log.v(TAG+"39999",sxt_handle+"--"+s2+"---"+i1[0]);
        //如果i1[0]==0代表有压倒
        if (i1[0]==0){

            Log.v(TAG+"39999","自动拍照ip:"+PARKING_ip_Bean.typeIP(1));
            DecodeManager.getinstance().getOneImg(PARKING_ip_Bean.typeIP(1));
        }

        return super.onStartCommand(intent, flags, startId);
    }

}
