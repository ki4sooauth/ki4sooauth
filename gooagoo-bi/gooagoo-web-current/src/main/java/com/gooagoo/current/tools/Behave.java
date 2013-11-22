package com.gooagoo.current.tools;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Behave {
	public static Map<String, String[]> behaveMap = new HashMap<String, String[]>();
    
    
	/**
	 *  跟据接口编码获取行为类型和行为对像
	 * @param interCode
	 * @return 返回数组下标【0】行为类型【1】行为对象
	 */
	public static String [] getBehaveType(String interCode){
		if(behaveMap.isEmpty()){
			initBehaveType();
		}
		String[] strings = behaveMap.get(interCode);
		return strings;
	}
	
	static {
		initBehaveType();
	}
	
	private static  void initBehaveType(){
		ResourceBundle bundle = ResourceBundle.getBundle("behaveConfig");
		Enumeration<String> keys = bundle.getKeys();
		while(keys.hasMoreElements()){
			String key = keys.nextElement();
			String value = bundle.getString(key);
			String[] values = value.split("_");
			behaveMap.put(key, values);
		}
	}
	
}
