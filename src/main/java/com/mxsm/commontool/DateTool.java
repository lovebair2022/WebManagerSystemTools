package com.mxsm.commontool;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.mxsm.common.consts.DateConst;

/**
 * DateUitl Class
 * @author mxsm
 *
 */

public class DateTool {

	/**
	 * date formate to string, default pattern "yyyy-MM-dd HH:mm:ss"
	 * @param date
	 * @param pattern
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static String dateToString(Date date, String pattern) throws IllegalArgumentException{
		
		DateFormat dateFormat = null;
		String val = null;
		
		if(date == null){
			
			return null;
		}
		
		try {
			
			if(StringTool.isEmpty(pattern)){
				dateFormat = new SimpleDateFormat(DateConst.DEFAULT_DATE_PARTTERN, Locale.CHINA);
			}
			else{
				dateFormat = new SimpleDateFormat(pattern, Locale.CHINA);
			}
			
			val = dateFormat.format(date);
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException("paramter pattern is is invalid");
		}
		
		return val;
	}
	
	public static Date parseStringToDate(String dateSt, String pattern) throws IllegalArgumentException{
		
		DateFormat dateFormat = null;
		Date val = null;
		
		if(StringTool.isEmpty(dateSt) || StringTool.isEmpty(pattern)){
			
			return null;
		}
		
		try {
			dateFormat = new SimpleDateFormat(pattern);
			val = dateFormat.parse(dateSt);
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException("paramter pattern is is invalid");
		}
		
		return val;
	}
	
	/**
	 * get current date time string formate by pattern,if pattern is null or ""
	 * formate by yyyy-MM-dd HH:mm:ss
	 * @param pattern
	 * @return
	 */
	
	public static String getCurrentDateTime(String pattern){
		
		String val = null;
		
		if(StringTool.isEmpty(pattern)){
			
			try {
				val = dateToString(new Date(), DateConst.DEFAULT_DATE_PARTTERN);
				return val;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return null;
			}
		}
		
		try {
			
			val = dateToString(new Date(), pattern);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
		return val;
	}
	
	/**
	 * get current date time string is formated by yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getCurrentDateTime(){
		
		return getCurrentDateTime(null);
	}
	
}
