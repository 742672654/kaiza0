package com.gongnen;


import android.util.Log;

import com.zld.bean.AppInfo;
import com.zld.lib.constant.Constant;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


/**
 *@功能    模拟HTTP请求
 *@参考  www.cnblogs.com/zhi-leaf/p/8508071.html
 */

public class HttpURLConnectionUtil {


	public static String getUTF8StringFromGBKString(String gbkStr) {
		try {
			return new String(getUTF8BytesFromGBKString(gbkStr), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new InternalError();
		}
	}

	public static byte[] getUTF8BytesFromGBKString(String gbkStr) {
		int n = gbkStr.length();
		byte[] utfBytes = new byte[3 * n];
		int k = 0;
		for (int i = 0; i < n; i++) {
			int m = gbkStr.charAt(i);
			if (m < 128 && m >= 0) {
				utfBytes[k++] = (byte) m;
				continue;
			}
			utfBytes[k++] = (byte) (0xe0 | (m >> 12));
			utfBytes[k++] = (byte) (0x80 | ((m >> 6) & 0x3f));
			utfBytes[k++] = (byte) (0x80 | (m & 0x3f));
		}
		if (k < utfBytes.length) {
			byte[] tmp = new byte[k];
			System.arraycopy(utfBytes, 0, tmp, 0, k);
			return tmp;
		}
		return utfBytes;
	}


	 /**
	  *@功能      模拟发送GET请求
	  *@接收   param:"code=1&id=ss"
	  */
	  public static String doGET ( String uri, String param ) throws Exception {


		  	BufferedReader br = null;
	        try {


				//uri = getUTF8StringFromGBKString(uri + ((param!=null && !"".equals(param))?"":"&" + param));

	            URL url = new URL(uri );
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	            connection.setDoOutput(true); // 设置该连接是可以输出的
	            connection.setRequestMethod("GET"); // 设置请求方式
	            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
	            br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
	            String line = null;
	            StringBuilder result = new StringBuilder();
	            while ((line = br.readLine()) != null) { // 读取数据
	                result.append(line + "\n");
	            }
	            connection.disconnect();
	            return result.toString();
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw e;
	        }finally {
	        	if( br != null )try{br.close();}catch(IOException e){e.printStackTrace();}
			}
	    }

	  
	  /**
	   *@功能    模拟发送POST form表单
	   *@接收  param:"code=001&name=测试"
	   */
	  public static String doPOST( String uri, String param ) {
	    	
		  		return doPOST2( uri, param, null );
	    }
	  /**
	   *@功能    模拟发送POST form表单2
	   *@接收  param: "code=001&name=测试"
	   *@接收  headers： Map类型 headers头文件
	   */
	  public static String doPOST2( String uri, String param, Map<String,String> headers ) {
	    	
	    	 BufferedReader br = null;
	        try {
	            URL url = new URL(uri);
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	            connection.setDoInput(true); // 设置可输入
	            connection.setDoOutput(true); // 设置该连接是可以输出的
	            connection.setRequestMethod("POST"); // 设置请求方式
	            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

	            if( headers!=null && headers.size()>0 ){
	            for(Entry<String, String> entry : headers.entrySet()) { 

	            	  connection.setRequestProperty(entry.getKey(), entry.getValue());
	            }
	            }
	            PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
	            pw.write(param);
	            pw.flush();
	            pw.close();
	            br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
	            String line = null;
	            StringBuilder result = new StringBuilder();
	            while ((line = br.readLine()) != null) { // 读取数据
	                result.append(line + "\n");
	            }
	            connection.disconnect();
	            return result.toString();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }finally {
	        	if( br != null )try {br.close();} catch(IOException e){e.printStackTrace();}
			}
	    }




	public  String doPOST3( String uri, String param, Map<String,String> headers ){

		BufferedReader br = null;
		try {
			URL url = new URL(uri);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setDoInput(true); // 设置可输入
			connection.setDoOutput(true); // 设置该连接是可以输出的
			connection.setRequestMethod("POST"); // 设置请求方式
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

			if( headers!=null && headers.size()>0 ){
				for(Entry<String, String> entry : headers.entrySet()) {

					connection.setRequestProperty(entry.getKey(), entry.getValue());
				}
			}
			PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
			pw.write(param);
			pw.flush();
			pw.close();
			br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
			String line = null;
			StringBuilder result = new StringBuilder();
			while ((line = br.readLine()) != null) { // 读取数据
				result.append(line + "\n");
			}
			connection.disconnect();

			return result.toString();
		} catch (Exception e) {
			e.printStackTrace();
            return null;
		}finally {
			if( br != null )try {br.close();} catch(IOException e){e.printStackTrace();}
		}
	}



	  /**
	   *@功能    模拟发送JSON数据
	   *@接收  param格式:{"code":"0","name":"小张","id":"01"}
	   */
	  public  String doJSON( String uri, String param ) throws Exception {
	    	
	    	BufferedReader br = null;
	        try {
	            URL url = new URL( uri );
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	            connection.setDoInput(true); // 设置可输入
	            connection.setDoOutput(true); // 设置该连接是可以输出的
	            connection.setRequestMethod("POST"); // 设置请求方式
	            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
	            PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
	            pw.write(param);
	            pw.flush();
	            pw.close();
	            br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
	            String line = null;
	            StringBuilder result = new StringBuilder();
	            while ((line = br.readLine()) != null){ // 读取数据
	                result.append(line + "\n");
	            }
	            connection.disconnect();
	            return result.toString();
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw e;
	        }finally {
				if( br!=null )try{br.close();}catch (IOException e){e.printStackTrace();}
			}
	    }

	static String  TAG = "requestGet";

	public void requestGet(HashMap<String, String> paramsMap) {
		try {
			String baseUrl = "http://47.111.11.222:8081/zld/whitelist.do?";
			StringBuilder tempParams = new StringBuilder();
			int pos = 0;
			for (String key : paramsMap.keySet()) {
				if (pos > 0) {
					tempParams.append("&");
				}
				tempParams.append(String.format("%s=%s", key, URLEncoder.encode(paramsMap.get(key),"utf-8")));
				pos++;
			}
			String requestUrl = baseUrl + tempParams.toString();
			// 新建一个URL对象
			URL url = new URL(requestUrl);
			// 打开一个HttpURLConnection连接
			HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
			// 设置连接主机超时时间
			urlConn.setConnectTimeout(5 * 1000);
			//设置从主机读取数据超时
			urlConn.setReadTimeout(5 * 1000);
			// 设置是否使用缓存  默认是true
			urlConn.setUseCaches(true);
			// 设置为Post请求
			urlConn.setRequestMethod("GET");
			//urlConn设置请求头信息
			//设置请求中的媒体类型信息。
			urlConn.setRequestProperty("Content-Type", "application/json");
			//设置客户端与服务连接类型
			urlConn.addRequestProperty("Connection", "Keep-Alive");
			// 开始连接
			urlConn.connect();
			// 判断请求是否成功
			if (urlConn.getResponseCode() == 200) {
				// 获取返回的数据
				String result = streamToString(urlConn.getInputStream());
				Log.e(TAG, "Get方式请求成功，result--->" + result);
			} else {
				Log.e(TAG, "Get方式请求失败");
			}
			// 关闭连接
			urlConn.disconnect();
		} catch (Exception e) {
			Log.e(TAG, e.toString());
		}
	}

	/**
	 * 将输入流转换成字符串
	 *
	 * @param is 从网络获取的输入流
	 * @return
	 */
	public String streamToString(InputStream is) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = is.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
			baos.close();
			is.close();
			byte[] byteArray = baos.toByteArray();
			return new String(byteArray);
		} catch (Exception e) {
			Log.e(TAG, e.toString());
			return null;
		}
	}



	public void ss (){


		HttpURLConnection conn = null;
		try {
			/*登录时输入ip则Ping本地,默认Ping线上*/
			URL url = new URL(Constant.PING_TEST_LOCAL);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(8000);
			conn.setDoInput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "text/html");
			conn.setRequestProperty("Accept-Charset", "utf-8");
			conn.setRequestProperty("contentType", "utf-8");
			conn.connect();
			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {

				Log.e("wangluo判断","DetectionInternet是true是:"+url);
			}else{
				int a = conn.getContentLength();

				Log.e("wangluo判断","DetectionInternet是false是:"+url);
			}
//					}

		}catch (Exception e) {


			Log.e("wangluo判断","DetectionInternet的Exception是result:");
		}finally{
			conn.disconnect();
		}
	}










}