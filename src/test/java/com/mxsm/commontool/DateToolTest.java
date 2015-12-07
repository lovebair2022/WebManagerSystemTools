package com.mxsm.commontool;

import java.util.Date;

import com.mxsm.common.consts.DateConst;

import junit.framework.TestCase;

public class DateToolTest extends TestCase {

	public void testDateToString() {
		//fail("Not yet implemented");
		System.out.println(DateTool.dateToString(new Date(), ""));
		System.out.println(DateTool.dateToString(new Date(), DateConst.DATE_PATTERN_1));
		System.out.println(DateTool.dateToString(new Date(), DateConst.DATE_PATTERN_2));
		System.out.println(DateTool.dateToString(new Date(), DateConst.DATE_PATTERN_3));
		System.out.println(DateTool.dateToString(new Date(), DateConst.DATE_PATTERN_4));
	}

	public void testParseStringToDate(){
		
		System.out.println(DateTool.parseStringToDate("2015-07-05 22:52:41", ""));
		System.out.println(DateTool.parseStringToDate("2015-07-05", DateConst.DATE_PATTERN_1));
		System.out.println(DateTool.parseStringToDate("20150705225241", DateConst.DATE_PATTERN_2));
		System.out.println(DateTool.parseStringToDate("2015-07-05 22:52:41", DateConst.DATE_PATTERN_3));
		System.out.println(DateTool.parseStringToDate("2015-07-05 22:52:41 426", DateConst.DATE_PATTERN_4));
		
	}
	
	public void testGetCurrentDateTime(){
		System.out.println(DateTool.getCurrentDateTime());
		System.out.println(DateTool.getCurrentDateTime(DateConst.DATE_PATTERN_2));
	}
}
