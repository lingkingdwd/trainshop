package com.trainshop.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class TestHttpClient {
	// 接口地址
	private String ipAddress = "http://192.168.21.217:8080";
	private String apiURL = "";
	private Log logger = LogFactory.getLog(this.getClass());
	private static final String pattern = "yyyy-MM-dd HH:mm:ss:SSS";
	private HttpClient httpClient = null;
	private HttpPost method = null;
	private long startTime = 0L;
	private long endTime = 0L;
	private int status = 0;

	/**
	 * 接口地址
	 * 
	 * @param url
	 */
	public TestHttpClient(String url) {
		if (url != null) {
			this.apiURL = ipAddress + url;
		}
		if (apiURL != null) {
			httpClient = new DefaultHttpClient();
			method = new HttpPost(apiURL);
		}
	}
	
	public static void main(String[] args) throws Exception {
        /*System.out.println(new TestHttpClient("/trainshop/users/loginAction")
        	.post("{\"userName\":\"kele\",\"password\":\"123456\"}"));
        
        System.out.println(new TestHttpClient("/trainshop/users/checkUserName")
    		.post("{\"userName\":\"kele\"}"));
        
        System.out.println(new TestHttpClient("/trainshop/users/register")
    		.post("{\"userName\":\"test\",\"password\":\"123456\",\"email\":\"kele@163.com\",\"question\":"
    				+ "\"kele\",\"answer\":\"kele\",\"sex\":\"0\",\"birthday\":\"1988-01-01\",\"qq\":\"123456\","
    				+ "\"mobilePhone\":\"1311111111111\",\"passwdQuestion\":\"123\",\"passwdAnswer\":\"123\"}"));
        
        System.out.println(new TestHttpClient("/trainshop/users/getUserslist")
    		.post("{\"userName\":\"kele\"}", 0, 10));*/
        
        System.out.println(new TestHttpClient("/trainshop/goods/getlist")
			.post("{\"goodsName\":\"xxx\",\"catId\":\"xxx\",\"brandId\":\"xxx\"}", 0, 10));
    }

	/**
	 * 调用 API
	 * 
	 * @param parameters
	 * @return
	 */
	public String post(String parameters) {
		String body = null;
		logger.info("parameters:" + parameters);

		if (method != null & parameters != null
				&& !"".equals(parameters.trim())) {
			//JSONArray jsonObject = JSONArray.fromObject(parameters);
			//logger.info("json:" + jsonObject.toString());
			try {
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				// 建立一个NameValuePair数组，用于存储欲传送的参数
				params.add(new BasicNameValuePair("data", parameters));
				// 添加参数
				method.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));

				startTime = System.currentTimeMillis();

				// 设置编码
				HttpResponse response = httpClient.execute(method);
				endTime = System.currentTimeMillis();
				int statusCode = response.getStatusLine().getStatusCode();
				logger.info("statusCode:" + statusCode);
				logger.info("调用API 花费时间(单位：毫秒)：" + (endTime - startTime));
				if (statusCode != HttpStatus.SC_OK) {
					logger.error("Method failed:" + response.getStatusLine());
					status = 1;
				}

				// Read the response body
				body = EntityUtils.toString(response.getEntity());

			} catch (IOException e) {
				// 发生网络异常
				logger.error("exception occurred!\n"
						+ ExceptionUtils.getFullStackTrace(e));
				// 网络错误
				status = 3;
			} finally {
				logger.info("调用接口状态：" + status);
			}

		}
		return body;
	}
	
	/**
	 * 调用 API
	 * 
	 * @param parameters
	 * @return
	 */
	public String post(String parameters, Integer start, Integer limit) {
		String body = null;
		logger.info("parameters:" + parameters);

		if (method != null & parameters != null
				&& !"".equals(parameters.trim())) {
			//JSONArray jsonObject = JSONArray.fromObject(parameters);
			//logger.info("json:" + jsonObject.toString());
			try {
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				// 建立一个NameValuePair数组，用于存储欲传送的参数
				params.add(new BasicNameValuePair("data", parameters));
				params.add(new BasicNameValuePair("start", start.toString()));
				params.add(new BasicNameValuePair("limit", limit.toString()));
				// 添加参数
				method.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));

				startTime = System.currentTimeMillis();

				// 设置编码
				HttpResponse response = httpClient.execute(method);
				endTime = System.currentTimeMillis();
				int statusCode = response.getStatusLine().getStatusCode();
				logger.info("statusCode:" + statusCode);
				logger.info("调用API 花费时间(单位：毫秒)：" + (endTime - startTime));
				if (statusCode != HttpStatus.SC_OK) {
					logger.error("Method failed:" + response.getStatusLine());
					status = 1;
				}

				// Read the response body
				body = EntityUtils.toString(response.getEntity());

			} catch (IOException e) {
				// 发生网络异常
				logger.error("exception occurred!\n"
						+ ExceptionUtils.getFullStackTrace(e));
				// 网络错误
				status = 3;
			} finally {
				logger.info("调用接口状态：" + status);
			}

		}
		return body;
	}

	/**
	 * 0.成功 1.执行方法失败 2.协议错误 3.网络错误
	 * 
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the startTime
	 */
	public long getStartTime() {
		return startTime;
	}

	/**
	 * @return the endTime
	 */
	public long getEndTime() {
		return endTime;
	}
}
