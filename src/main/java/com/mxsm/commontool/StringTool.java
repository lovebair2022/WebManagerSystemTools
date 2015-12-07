package com.mxsm.commontool;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.UUID;

import com.mxsm.common.consts.StringConst;

/**
 * 字符串工具类
 * @author mxsm
 *
 */

public class StringTool {

	/**
	 * 判断字符串是否为null或者trim后为空字符串
	 * @param st
	 * @return
	 */
	public static boolean isEmpty(String st){
		
		if(st == null || st.trim().length() == 0){
			return true;
		}
		
		return false;
	}
	
	public static String getUUID(){
		
		String uuid = UUID.randomUUID().toString();
		
		return uuid.replace("-", "").toUpperCase();
		
	}
	
	/**
	 * 将数据格式化成固定长度的数据字符串不够前面加0
	 * @param i
	 * @param length
	 * @return
	 */
	public static String formateInt(int num, int length) throws NumberFormatException {
		
		if(num < 0){
			throw new NumberFormatException("number not be negative");
		}
		
		String sum = num + "";
		StringBuffer bf = new StringBuffer();
		
		if(length < sum.length()){
			return sum;
		}
		
		for(int j = 0; j < length - sum.length(); ++j){
			bf.append("0");
		}
		
		return bf.append(sum).toString();
		
	}
	
	/**
	 * 把数字字符串解析成int
	 * @param num 要解析的数字字符
	 * @param _default 解析失败返回默认值
	 * @return 对应解析的数字字符对应的十进制数字或者默认值
	 */
	public static int parseStringToInt(String num, int _default){
		
		if(isEmpty(num)){
			return _default;
		}
		
		try {
			int parse = Integer.parseInt(num);
			return parse;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return _default;
		}
	}
	
	public static int parseStringToInt(String numSt) throws NumberFormatException{
		
		if(isEmpty(numSt)){
			throw new NumberFormatException("paramter is null or empty string");
		}
		
		int _def = 0;
		
		try {
			_def = Integer.parseInt(numSt);
		} catch (Exception e) {
			// TODO: handle exception
			throw new NumberFormatException(e.getMessage());
		}
		
		return _def;
	}
	
	/**
	 * 获取对应Map中给定key值的value 如果value为空值或者null返回默认值_def
	 * @param map
	 * @param key
	 * @param _def
	 * @return _def或者key值对应的value
	 */
	public static String getStringValue(Map<String, Object> map, String key, String _def){
		
		String value = (String)map.get(key);
		
		if(value == null){
			return _def;
		}
		
		value = value.trim();
		
		return (value.length() == 0?_def:value);
		
	}
	
	/**
	 * 获取对应Map中给定key值的value 如果value为空值或者null返回null
	 * @param map
	 * @param key
	 * @return null 或者 key值对应的value
	 */
	public static String getStringValue(Map<String, Object> map, String key){
		
		return getStringValue(map,key,null);
	}
	
	public static <K,V> V getValueFromMap(Map<K, V> map, K key, V _def){
		
		V val = null;
		
		if(key == null){
			
			return _def;
		}
		
		val = map.get(key);
		
		if(val == null){
			
			return _def;
		}
		
		return val;
	}
	
	public static <K,V> V getValueFromMap(Map<K, V> map, K key) {
		return getValueFromMap(map, key, null);
	}
	
	public static String[] split(String val, String regex){
		
		String[] _val;
		
		if(isEmpty(val)){
			
			return null;
			
		}
		
		if(isEmpty(regex)){
			
			return null;
			
		}
		
		try {
			_val = val.split(regex);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
		return _val;
		
	}
	
	public static String deUnicode(String s) {
	    StringBuilder sb = new StringBuilder(s.length());
	    char[] chars = s.toCharArray();
	    for (int i = 0; i < chars.length; i++) {
	        char c = chars[i];
	        if (c == '\\' && chars[i + 1] == 'u') {
	            char cc = 0;
	            for (int j = 0; j < 4; j++) {
	                char ch = Character.toLowerCase(chars[i + 2 + j]);
	                if ('0' <= ch && ch <= '9' || 'a' <= ch && ch <= 'f') {
	                    cc |= (Character.digit(ch, 16) << (3 - j) * 4);
	                } else {
	                    cc = 0;
	                    break;
	                }
	            }
	            if (cc > 0) {
	                i += 5;
	                sb.append(cc);
	                continue;
	            }
	        }
	        sb.append(c);
	    }
	    return sb.toString();
	}
	
	/**
	 * Encryption enString by type if type is null the default MD%
	 * @param enString
	 * @param type
	 * @return
	 */
	public static String Encryption(String enString, String type)
	{
		String _type = null;
		
		if(isEmpty(enString))
		{
			return null;
		}
		
		if(isEmpty(_type)){
			
			_type = StringConst.MD5;
		}
		else
		{
			_type = type;
		}
		
		StringBuffer stBuf = new StringBuffer();
		MessageDigest md = null;
		
		try {
			md = MessageDigest.getInstance(_type); //获取MessageDigest实例
			byte[] bys = md.digest(enString.getBytes());
			
			//转换为32为的密文
			
			int len = bys.length;
			
			for(int i = 0; i < len; ++i)
			{
				//System.out.println(bys[i]);
				if(bys[i] < 0)
				{
					stBuf.append(Integer.toHexString(bys[i] + 256));
				}
				
				if(bys[i] >= 0 && bys[i] < 16)
				{
					stBuf.append("0");
					stBuf.append(Integer.toHexString(bys[i]));
				}
				
				if(bys[i] >= 16)
				{
					stBuf.append(Integer.toHexString(bys[i]));
				}
					
			}
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return stBuf.toString();
	}
	
}
