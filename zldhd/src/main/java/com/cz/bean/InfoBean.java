/*******************************************************************************
 * Copyright (c) 2015 by ehoo Corporation all right reserved.
 * 2015年4月15日 
 * 
 *******************************************************************************/ 
package com.cz.bean;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.zld.bean.CarType;
import com.zld.bean.FreeResons;
import com.zld.bean.LiftReason;
import com.zld.lib.util.SharedPreferencesUtils;

import java.util.List;


/**
 * <pre>
 * 功能说明: 登录车场获取的信息
 * 日期:	2019年5月5日10:47
 * 开发者:	KXD
 */
public class InfoBean {

	private String name;			//收费员
	private String token; 			//token
	private String comid; 			//车场id
	private String parkName;        //车场名字
	private String uid;				//用户账号
	private boolean parkBilling; 	//区分大小车
	private boolean passfree;		//是否免费
	private boolean ishdmoney;      //是否显示收费累计金额 0是显示 1是隐藏
	private String ishidehdbutton; 	//是否显示结算订单按钮
	private String issuplocal;		//是否支持本地化
	private String equipmentModel;	//设备
	private String imei;
	private String stname;			//工作站名称
	private List<CarType> allCarTypes; // 所有车辆类型
	private List<FreeResons> freeResons; // 车辆免费类型
	private List<LiftReason> liftreason;       //抬杆原因
	private String fullset;		//车位已满能否进场
	private String leaveset;	//车场识别识别抬杆设置  （有的月卡车场没人收费（不收费））

	private UserBean userBean;



	//AppInfo实例
	private static InfoBean appInfo = new InfoBean();

	/** 保证只有一个AppInfo实例 */
	private InfoBean(){ }

	/** 获取AppInfo实例 ,单例模式 */  
	public static InfoBean getInstance() {
		return appInfo;  
	}


	public UserBean getUserBean() {
		return userBean;
	}
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getComid() {
		return comid;
	}
	public void setComid(String comid) {
		this.comid = comid;
	}
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public boolean isParkBilling() {
		return parkBilling;
	}
	public void setParkBilling(boolean parkBilling) {
		this.parkBilling = parkBilling;
	}
	public boolean isPassfree() {
		return passfree;
	}
	public void setPassfree(boolean passfree) {
		this.passfree = passfree;
	}
	public boolean isIshdmoney() {
		return ishdmoney;
	}
	public void setIshdmoney(boolean ishdmoney) {
		this.ishdmoney = ishdmoney;
	}
	public String getIshidehdbutton() {
		return ishidehdbutton;
	}
	public void setIshidehdbutton(String ishidehdbutton) {
		this.ishidehdbutton = ishidehdbutton;
	}
	public String getIssuplocal() {
		return issuplocal;
	}
	public void setIssuplocal(String issuplocal) {
		this.issuplocal = issuplocal;
	}
	public String getEquipmentModel() {
		return equipmentModel;
	}
	public void setEquipmentModel(String equipmentModel) {
		this.equipmentModel = equipmentModel;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public List<CarType> getAllCarTypes() {
		return allCarTypes;
	}
	public void setAllCarTypes(List<CarType> allCarTypes) {
		this.allCarTypes = allCarTypes;
	}
	public List<FreeResons> getFreeResons() {
		return freeResons;
	}
	public void setFreeResons(List<FreeResons> freeResons) {
		this.freeResons = freeResons;
	}
	public List<LiftReason> getLiftreason() {
		return liftreason;
	}
	public void setLiftreason(List<LiftReason> liftreason) {
		this.liftreason = liftreason;
	}
	public String getFullset() {
		return fullset;
	}
	public void setFullset(String fullset) {
		this.fullset = fullset;
	}
	public String getLeaveset() {
		return leaveset;
	}
	public void setLeaveset(String leaveset) {
		this.leaveset = leaveset;
	}
	public static InfoBean getAppInfo() {
		return appInfo;
	}
	public static void setAppInfo(InfoBean appInfo) {
		InfoBean.appInfo = appInfo;
	}

	@Override
	public String toString() {
		return "InfoBean{" +
				"name='" + name + '\'' +
				", token='" + token + '\'' +
				", comid='" + comid + '\'' +
				", parkName='" + parkName + '\'' +
				", uid='" + uid + '\'' +
				", parkBilling=" + parkBilling +
				", passfree=" + passfree +
				", ishdmoney=" + ishdmoney +
				", ishidehdbutton='" + ishidehdbutton + '\'' +
				", issuplocal='" + issuplocal + '\'' +
				", equipmentModel='" + equipmentModel + '\'' +
				", imei='" + imei + '\'' +
				", stname='" + stname + '\'' +
				", allCarTypes=" + allCarTypes +
				", freeResons=" + freeResons +
				", liftreason=" + liftreason +
				", fullset='" + fullset + '\'' +
				", leaveset='" + leaveset + '\'' +
				", userBean=" + userBean.toString() +
				'}';
	}
}
