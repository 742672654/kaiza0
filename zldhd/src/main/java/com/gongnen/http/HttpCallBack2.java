package com.gongnen.http;



/**
 * 描述：通信回调类
 * @author  lulogfei
 */
public interface HttpCallBack2 {


	/**
	 * 描述：通信成功的回调
	 * @param object 回调数据
	 * @param url 请求地址
	 * @param sign 标识
	 * @return
	 */
	public void onResponseGET(String url, String object, String sign);

	public void onResponsePOST(String url, String object, String sign);
}