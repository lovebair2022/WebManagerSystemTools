package com.mxsm.commontool;

/**
 * Class 工具类
 * @author mxsm
 *
 */
public class ClassUtil {

	/**
	 * 判断给定Class名称是否存在
	 * @param className
	 * @return  
	 */
	public static boolean classIsExist(String className){
		
		if(StringTool.isEmpty(className)){
			return false;
		}
		
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * 类名
	 * @param className
	 * @throws ClassNotFoundException 
	 */
	public static  Class<? extends Object> classForName(String className) throws ClassNotFoundException{
			return Class.forName(className);
	}
}
