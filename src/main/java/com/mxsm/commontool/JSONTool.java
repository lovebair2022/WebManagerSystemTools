package com.mxsm.commontool;


import java.util.List;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.mxsm.easyui.vo.ComboBox;
import com.mxsm.easyui.vo.DataGrid;

/**
 * json util
 * @author mxsm
 *
 */

public class JSONTool {

	public static String toJSONString(Object obj){
		
		return JSON.toJSONString(obj);
		
	}
	
	public static <E> String toJSONArrayString(List<E> list){
		
		return JSONArray.toJSONString(list);
	}
	
	
	public static <T> String to_EasyUIDataGrid_JSONString(DataGrid<T> datagrid){
		
		return toJSONString(datagrid);
	}
	
	public static String to_EasyUIComboBox_JSONString(List<ComboBox> list){
		
		return toJSONArrayString(list);
	}
}
