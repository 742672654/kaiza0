package com.gongnen;


import android.util.Log;

import com.zld.photo.DecodeManager;


public class taigan {

    public final static String TAG = "taigan";

    public static void tai(String ip) {

        DecodeManager.getinstance().controlPole(DecodeManager.openPole, ip);

}
}