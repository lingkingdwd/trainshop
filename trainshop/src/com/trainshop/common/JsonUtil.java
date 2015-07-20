package com.trainshop.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
public class JsonUtil {
	public static String obj2Json(Object obj)
	{
		return JSON.toJSONString(obj);
	}
	
	 public static String bean2Json(Object obj,String dateFormat) {
        return JSON.toJSONStringWithDateFormat(obj, dateFormat, SerializerFeature.PrettyFormat);
   }
 
    public static <T> T json2Bean(String jsonStr, Class<T> objClass) {
        return JSON.parseObject(jsonStr, objClass);
    }
}
