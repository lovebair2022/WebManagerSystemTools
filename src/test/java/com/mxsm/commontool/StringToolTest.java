package com.mxsm.commontool;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

public class StringToolTest extends TestCase {

	public void testIsEmpty() {
		//fail("Not yet implemented");
		assertEquals(true, StringTool.isEmpty(""));
		assertEquals(true, StringTool.isEmpty("     "));
		assertEquals(true, StringTool.isEmpty(null));
		assertEquals(true, StringTool.isEmpty("  aaa"));
		
	}

	public void testGetUUID() {
		//fail("Not yet implemented");
		for(int i = 0; i < 10; ++i){
			
			System.out.println(StringTool.getUUID());
		}
	}

	public void testFormateInt() {
		//fail("Not yet implemented");
		System.out.println(StringTool.formateInt(-123, 12));
		
	}

	public void testParseStringToInt() {
		fail("Not yet implemented");
	}

	public void testGetStringValueMapOfStringObjectStringString() {
		fail("Not yet implemented");
	}

	public void testGetStringValueMapOfStringObjectString() {
		fail("Not yet implemented");
	}

	public  void  testGetValue(){
		
		Map<String, String> ob = new HashMap<String, String>();
		ob.put("1", "aaa");
		
		System.out.println(StringTool.getValueFromMap(ob, "2","22"));
		
	}
	
	 
	
	
}
