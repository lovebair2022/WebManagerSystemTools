package com.mxsm.commontool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mxsm.easyui.vo.ComboBox;
import com.mxsm.easyui.vo.DataGrid;

import junit.framework.TestCase;

public class JSONToolTest extends TestCase {

	public void testToJSONString() {
		//fail("Not yet implemented");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("a", "1");
		
		
		//System.out.println(JSONTool.toJSONString(map));
		
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		map.put("2", list);
		
		System.out.println(JSONTool.toJSONString(map));
	}

	public void testTo_EasyUIDataGrid_JSONString(){
		//JSONTool.isNull(String.class);
		List<Person> list = new ArrayList<Person>();
		list.add(new Person("a", 1));
		list.add(new Person("b", 1));
		list.add(new Person("c", 1));
		list.add(new Person("d", 1));
		
		DataGrid<Person> d = new DataGrid<Person>(4L, list);
		//String st = JSONTool.to_EasyUIDataGrid_JSONString(list, list.size());
		System.out.println(JSONTool.toJSONString(d));
		
	}
	
	public void testToJSONArrayString(){
		ComboBox vo = new ComboBox("111", "222", "");
		ComboBox vo1 = new ComboBox("111", "222", "");
		ComboBox vo2 = new ComboBox("111", "222", "");
		
		List<ComboBox> l = new ArrayList<ComboBox>();
		l.add(vo);
		l.add(vo1);
		l.add(vo2);
		
		System.out.println(JSONTool.toJSONArrayString(l));
	}
	
}
