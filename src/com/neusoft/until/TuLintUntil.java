package com.neusoft.until;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class TuLintUntil {
	//存储apikey
	private static final String APIKEY="975e3f5ebd614041967d319235dd396f";
	//存储url
	private static final String APIURL="http://www.tuling123.com/openapi/api";
	
	public String getResult(String message) {
		//统一编码utf-8
		try {
			message=URLEncoder.encode(message, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//拼接url
		String url=APIURL+"?key="+APIKEY+"&info="+message;
		//封装请求头
		HttpGet request=new HttpGet(url);
		String result="";
		//发送请求
		try {
			HttpResponse response=HttpClients.createDefault().execute(request);
			//获取状态码
			int code=response.getStatusLine().getStatusCode();
			//判断状态码
			if(code==200) {
				//获取相应结果
				result= EntityUtils.toString(response.getEntity());
				//对获得的结果进行渲染，将json字符串转为json对象
				JSONObject sJsonObject=JSON.parseObject(result);
				result=sJsonObject.get("text").toString();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return result;
		
	}

}
