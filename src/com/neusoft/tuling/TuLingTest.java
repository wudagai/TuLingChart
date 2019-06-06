package com.neusoft.tuling;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class TuLingTest {
	//975e3f5ebd614041967d319235dd396f
	//存储apikey 还有接口地址
	private static final String APIKEY="975e3f5ebd614041967d319235dd396f";
	private static final String APIURL="http://www.tuling123.com/openapi/api";
	public static void main(String[] args) {
	//需求传参数"http://www.tuling123.com/openapi/api?key="+APIKEY+"&info="+message
	/*
	 * 接收控制台输入
	 */
	while(true) {
	Scanner scanner=new Scanner(System.in);
	String message=scanner.nextLine();
	try {
		//调用图灵API的各个环节的编码方式均为UTF-8
		message=URLEncoder.encode(message, "utf-8");
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}
	//拼接url
	String url=APIURL+"?key="+APIKEY+"&info="+message;
	//使用apache的HttpClient 模块开发
	//第一步创建HttpGet对象
	HttpGet request=new HttpGet(url);
	String reslut="";
	try {
		//第二步使用execute发送请求，并且返回HttpResponse对象
		HttpResponse response=HttpClients.createDefault().execute(request);
		//第三步获取状态码
		int code=response.getStatusLine().getStatusCode();
		//第四步判断状态码
		if(code==200) {
		//第五步获取相应结果
			HttpEntity entity=response.getEntity();
			reslut=EntityUtils.toString(entity);
			JSONObject sObject=JSON.parseObject(reslut);
			reslut=sObject.get("text").toString();
			System.out.println(reslut);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

		}
	}
}
