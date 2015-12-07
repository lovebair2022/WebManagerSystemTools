package com.mxsm.commontool;

import java.util.Properties;

public class PropertiesParser {
public static String DEFAULT_REGEX = ",";
	
	/**
	 * Data members
	 */
	private Properties props = null;
	
	public PropertiesParser(Properties props) {
		// TODO Auto-generated constructor stub
		this.props = props;
	}
	
	public Properties getUnderlyingProperties(){
		return props;
	}
	
	/**
	 * 获取name对应的value值， 如果value不存在返回null
	 * @param name
	 * @return null或者name对应value
	 */
	public String getStringProperty(String name){
		return getStringProperty(name, null);
	}
	
	
	/**
	 * 获取name对应的value值， 如果value不存在返回def默认值
	 * @param name
	 * @param def
	 * @return def或者name对应的value
	 */
	public String getStringProperty(String name, String def){
		String val = props.getProperty(name);
		
		if(val == null ){
			return def;
		}
		
		val = val.trim();
		
		return (val.length() == 0)? def : val;
	}
	
	/**
	 * 获取字符数组根据name,如果name对应的字符数组不存在返回null，存在着返回对应的字符数组
	 * 默认的分割符","
	 * @param name
	 * @return null或者对应name的String数组
	 */
	public String[] getArrayStringProperty(String name){
		return getArrayStringProperty(name, null, DEFAULT_REGEX);
	}
	
	/**
	 * 获取字符数组根据name,如果name对应的字符数组不存在返回def默认值，存在着返回对应的字符数组。
	 * 当regex分割符为空使用默认的","分割符
	 * @param name
	 * @param def 默认值 
	 * @param regex 分割符
	 * @return
	 */
	public String[] getArrayStringProperty(String name, String[] def, String regex){
		
		String val = props.getProperty(name);
		
		if(val == null){
			return def;
		}
		
		val = val.trim();
		
		if(val.length() == 0){
			return def;
		}
		
		return (regex == null || regex.trim().length() == 0) ? val.split(DEFAULT_REGEX):val.split(regex);
	}
	
	/**
	 * name对应的value值不存在返回false
	 * @param name
	 * @return name对应的boolean值或者false
	 */
	public boolean getBooleanProperty(String name){
		
		return getBooleanProperty(name, false);
	}
	
	public boolean getBooleanProperty(String name, boolean def){
		
		String val = props.getProperty(name);
		
		if(val == null){
			return def;
		}
		
		val = val.trim();
		
		return (val.length() == 0)? def : Boolean.valueOf(val);
	}
	
	public byte getByteProperty(String name) throws NumberFormatException{
		
		String val = props.getProperty(name);
		
		if(val == null){
			
			throw new NumberFormatException("null String");
		}
		
		try {
			return Byte.valueOf(val);
		} catch (Exception e) {
			// TODO: handle exception
			throw new NumberFormatException(" '" + val + "'");
		}
		
	}
	
	public byte getByteProperty(String name, byte def) throws NumberFormatException{
		
		String val = props.getProperty(name);
		
		if(val == null){
			return def;
		}
		
		try {
			return Byte.valueOf(val);
		} catch (Exception e) {
			// TODO: handle exception
			throw new NumberFormatException(" '" + val + "'");
		}
	}
	
	/**
	 * name对应的数字不存在默认值返回0
	 * @param name
	 * @return
	 */
	public int getIntProperty(String name){
		
		return getIntProperty(name, 0);
	}
	
	public int getIntProperty(String name, int _def) throws NumberFormatException{
		
		String val = props.getProperty(name);
		
		if(val == null){
			return _def;
		}
		
		val = val.trim();
		
		if(val.length() == 0){
			return _def;
		}
		
		try {
			
			return Integer.parseInt(val);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new NumberFormatException(" '" + val + "'");
		}
		
	}
	
	public float getFloatProperty(String name, float _def) throws NumberFormatException{
		
		String val = props.getProperty(name);
		
		if(val == null){
			return _def;
		}
		
		val = val.trim();
		
		if(val.length() == 0){
			
			return _def;
		}
		
		try {
			return Float.parseFloat(val);
		} catch (Exception e) {
			// TODO: handle exception
			throw new NumberFormatException(" '" + val + "'");
		}
		//return 0f;
	}
	
	/**
	 * if value is null or empty return default value 0f
	 * @param name
	 * @return
	 * @throws NumberFormatException
	 */
	public float getFloatProperty(String name) throws NumberFormatException{
		
		String val = props.getProperty(name);
		
		if(val == null){
			
			return 0f;
		}
		
		val = val.trim();
		
		if(val.length() == 0){
			
			return 0f;
		}
		
		try {
			return Float.parseFloat(val);
		} catch (Exception e) {
			// TODO: handle exception
			throw new NumberFormatException(" '" + val + "'");
		}
	}
	
	
}
