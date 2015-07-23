package com.trainshop.controller;

public class BaseController {
	
	public String returnData(String data){
		String result = "{\"flag\":\"1\",\"DATA\":" + data + ",\"message\":\"\"}";
		
		return result;
	}
	
	public String returnData(String data, String message){
		String result = "{\"flag\":\"1\",\"DATA\":" + data + ",\"message\":\"" + message +"\"}";
		
		return result;
	}
	
	public String returnData(int data){
		String result = "{\"flag\":\"1\",\"DATA\":" + data + ",\"message\":\"\"}";
		
		return result;
	}
	
	public String returnSucess(String message){
		String result = "{\"flag\":\"1\",\"message\":\"" + message + "\"}";
		
		return result;
	}
	
	public String returnFail(String message){
		String result = "{\"flag\":\"0\",\"message\":\"" + message + "\"}";
		
		return result;
	}
}
