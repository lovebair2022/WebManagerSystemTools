package com.mxsm.commontool;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * xml tool class
 * @author mxsm
 *
 */

public class XMLTool {

	public static final String DEFAULT_ENCODE = "UTF-8";
	
	public static Document document = null;
	
	public static void createDocument(String xml) throws DocumentException{
		
		try {
			document = DocumentHelper.parseText(xml);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DocumentException("parse xml error");
		}
		
	}
	
	public static void destroyDocument(){
		
		document = null;
		
	}
	
	/**
	 * in is null or throw exception return is null, the default encode is utf-8
	 * @param in
	 * @return
	 */
	public static final String getXMLString(InputStream in){
		
		return getXMLString(in, DEFAULT_ENCODE);
		
	}
	
	/**
	 * in is null or throw exception return is null
	 * @param in
	 * @param encoding
	 * @return
	 */
	public static String getXMLString(InputStream in, String encoding){
		
		String val;
		String _encoding;
		
		if(in == null){
			
			return null;
		}
		
		if(StringTool.isEmpty(encoding)){
			
			_encoding = DEFAULT_ENCODE;
			
		}
		else{
			
			_encoding = encoding;
			
		}
		
		
		try {
			
			val = IOUtils.toString(in, _encoding);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return val;
		
	}
	
	/**
	 * file is null,file not exist or  throw exception return is null, the default encode is utf-8
	 * @param file
	 * @return
	 */
	public static String getXMLString(File file){
		
		return getXMLString(file, DEFAULT_ENCODE);
	}
	
	/**
	 * file is null,file not exist or  throw exception return is null
	 * if encoding is null use the default encoding utf-8
	 * @param file
	 * @param encoding
	 * @return
	 */
	public static String getXMLString(File file, String encoding){
		List<String> val;
		String _encoding;
		
		if(file == null || !file.exists()){
			
			return null;
		}
		
		if(StringTool.isEmpty(encoding)){
			
			_encoding = DEFAULT_ENCODE;
			
		}else{
			
			_encoding = encoding;
		}
		
		try {
			val = FileUtils.readLines(file, _encoding);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		if(val == null || val.size() == 0){
			
			return null;
			
		}
		
		return getListString(val);
	}
	
	/**
	 * if list is null or list size equal 0 return null
	 * @param list
	 * @return
	 */
	private static String getListString(List<String> list){
		
		StringBuffer val = new StringBuffer();
		
		if(list == null || list.size() == 0){
			return null;
		}
		
		Iterator<String> it = list.iterator();
		
		while(it.hasNext()){
			
			val.append(it.next());
			
		}
		
		return val.toString();
		
	}
	
	/**
	 * if url is null or throw exception return null
	 * if encoding is null or empty
	 * @param url
	 * @param encoding
	 * @return
	 */
	public static String getXMLString (URL url, String encoding){

		String _encoding;
		String val;
		
		
		if(url == null){
			
			return null;
		}
		
		if(StringTool.isEmpty(encoding)){
			
			_encoding = DEFAULT_ENCODE;
			
		}else{
			
			_encoding = encoding;
		}
		
		try {
			val = IOUtils.toString(url, _encoding);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return val;
		
	}
	
	public static String getXMLString(URL url){
		
		return getXMLString(url, DEFAULT_ENCODE);
		
	}
	
	
	public static String getXMLNodeSingleValue(String xpath, String xml) throws IllegalArgumentException, DocumentException{
		
		if(StringTool.isEmpty(xml)){
			
			throw new IllegalArgumentException("xml is null or empty");
		}
		
		if(StringTool.isEmpty(xpath)){
			
			throw new IllegalArgumentException("xpath is null or empty");
		}
		
		return parseXMLNodeSingleValue(xpath,xml);
	}
	
	public static String getXMLNodeSingleValue(String xpath) throws ParseException,IllegalArgumentException{
		
		if(StringTool.isEmpty(xpath)){
			
			throw new IllegalArgumentException("xpath is null or empty");
		}
		
		return parseXMLNodeSingleValue(xpath);
	}
	
	
	public static String[] getXMLNodeListValue(String xpath, String xml){
		
		List<String> list = new ArrayList<String>();
		String[] vals = new String[0];
		
		try {
			List<Element> elist = parseXMLNodeListValue(xpath, xml);
			
			if(elist == null || elist.size() <= 0){
				
				return null;
				
			}
			
			int count = elist.size();
			
			for(int i = 0; i < count; ++i){
				
				list.add(elist.get(i).getTextTrim());
			}
			
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return  list.size() == 0? null : list.toArray(vals);
	}
	
	public static String[] getXMLNodeListValue(String xpath){
		
		List<String> list = new ArrayList<String>();
		String[] vals = new String[0];
		
	    List<Element> elist = parseXMLNodeListValue(xpath);
			
			if(elist == null || elist.size() <= 0){
				
				return null;
			}
			
			int count = elist.size();
			
			for(int i = 0; i < count; ++i){
				
				list.add(elist.get(i).getTextTrim());
			}
		
		return  list.size() == 0? null : list.toArray(vals);
	}
	
	public static String parseXMLNodeSingleValue(String xpath, String xml) throws DocumentException{
		
		String val = null;
		
		if(StringTool.isEmpty(xpath) || StringTool.isEmpty(xml)){
			
			return null;
		}
		
		try {
			
			Document document = DocumentHelper.parseText(xml);
			val = document.selectSingleNode(xpath).getText();
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DocumentException("parse xml error");
		}
		
		return val;
		
	}
	
	public static String parseXMLNodeSingleValue(String xpath) throws ParseException{
		
		String val = null;
		
		if(StringTool.isEmpty(xpath)){
			
			return null;
		}
		
		if(document == null){
			throw new ParseException("document is null, use the XMLTool.createDocument()");
		}
		
		val = document.selectSingleNode(xpath).toString();
		
		return val;
		
	}
	
	
	@SuppressWarnings("unchecked")
	public static List<Element> parseXMLNodeListValue(String xpath, String xml) throws DocumentException{
		
		List<Element> val = null;
		
		if(StringTool.isEmpty(xml) || StringTool.isEmpty(xpath)){
			
			return null;
			
		}
		
		try {
			
			Document document = DocumentHelper.parseText(xml);
			val = document.selectNodes(xpath);
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DocumentException("parse xml error");
		}
		
		return val;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Element> parseXMLNodeListValue(String xpath){
		
		List<Element> val = null;
		
		if(StringTool.isEmpty(xpath)){
			
			return null;
		}
		
		val = document.selectNodes(xpath);
		
		return val;
	}
	
}
