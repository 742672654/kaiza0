package com.qy.led.model2;

import android.util.Log;
import java.util.Date;
import com.qy.led2.SendBuffer2;

public class LedThread extends Thread {

    static int s=0;
    private String ledIP ;
    private String cashOrderData;

    public LedThread(String ledIP,String cashOrderData) {
        this.ledIP = ledIP;
        this.cashOrderData=cashOrderData;
//        this.cashOrderData=(cashOrderData==null)?("北京时间"+new Date().toLocaleString().substring(new Date().toLocaleString().length()-8,
//                                                                    new Date().toLocaleString().length())):cashOrderData;
//        if (cashOrderData!=null&&cashOrderData.length()<=4){
//            this.cashOrderData=cashOrderData+new Date().toLocaleString().substring(new Date().toLocaleString().length()-8,
//                    new Date().toLocaleString().length());
//        }
    }

    public void run() {

        try {

            if (cashOrderData==null || cashOrderData.equals("") || ledIP==null || ledIP.equals("")){ return;}
            if (SendBuffer2.SendInternalText_Net(cashOrderData, ledIP, 1, 64, 32, 1, 0, 9, 1, 1, 1, 1, 1, 3, false)== 0) {
                Log.e("LedThread","发送内码文字=  "+cashOrderData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
