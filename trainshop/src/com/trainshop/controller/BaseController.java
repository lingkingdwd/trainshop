package com.trainshop.controller;

public class BaseController {
	
	public String returnData(String data){
		String result = "{\"flag\":\"1\",\"DATA\":\"" + data + "\",\"message\":\"\"}";
		
		return result;
	}
	
	public String returnData(int data){
		String result = "{\"flag\":\"1\",\"DATA\":\"" + data + "\",\"message\":\"\"}";
		
		return result;
	}
}
