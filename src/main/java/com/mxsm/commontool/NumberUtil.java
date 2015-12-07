package com.mxsm.commontool;

import java.util.Map;

/**
 * 数字工具类
 * @author mxsm
 *
 */
public class NumberUtil {

	public static int getIntFromMap(Map<String, String> map,String key){
		int _value = 0;
		String val = map.get(key);
		
		if(StringTool.isEmpty(val)){
			throw new NumberFormatException(key + "对应的值为空");
		}
		
		try {
			_value = parseInt(val);
		} catch (Exception e) {
			// TODO: handle exception
			throw new NumberFormatException(e.getMessage());
		}
		
		return _value;
	}
	
	public static int parseInt(String value, int _def){
		
		if(StringTool.isEmpty(value)){
			return _def;
		}
		
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
			return _def;
		}
	}
	
	public static int parseInt(String value) throws NumberFormatException{
		
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			// TODO: handle exception
		    throw new NumberFormatException(e.getMessage());
		}
	}
	
}
