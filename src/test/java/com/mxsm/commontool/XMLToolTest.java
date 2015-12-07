package com.mxsm.commontool;

import org.dom4j.DocumentException;

import junit.framework.TestCase;

public class XMLToolTest extends TestCase {

	public void testGetXMLStringInputStream() {
		fail("Not yet implemented");
	}

	public void testGetXMLStringInputStreamString() {
		fail("Not yet implemented");
	}

	public void testGetXMLStringFile() {
		fail("Not yet implemented");
	}

	public void testGetXMLStringFileString() {
		fail("Not yet implemented");
	}

	public void testGetXMLStringURLString() {
		fail("Not yet implemented");
	}

	public void testGetXMLStringURL() {
		fail("Not yet implemented");
	}

	public void testGetXMLNodeValue() {
		fail("Not yet implemented");
	}

	public void testGetXMLNodeSingleValue() {
		fail("Not yet implemented");
	}

	public void testParseXMLForNodeSingleValue() {
		
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\" ?> <CityWeatherResponse>		  <error>0</error>	    <status>success</status>		    <date>2015-07-16</date>	    <results>              <currentCity>广州</currentCity>        <weather_data>                            <date>周四 07月16日 (实时：29℃)</date>                <dayPictureUrl>http://api.map.baidu.com/images/weather/day/duoyun.png</dayPictureUrl>                <nightPictureUrl>http://api.map.baidu.com/images/weather/night/dayu.png</nightPictureUrl>                <weather>多云转中到大雨</weather>                <wind>微风</wind>                <temperature>35 ~ 26℃</temperature>                            <date>周五</date>                <dayPictureUrl>http://api.map.baidu.com/images/weather/day/dayu.png</dayPictureUrl>                <nightPictureUrl>http://api.map.baidu.com/images/weather/night/leizhenyu.png</nightPictureUrl>                <weather>中到大雨转雷阵雨</weather>                <wind>微风</wind>                <temperature>32 ~ 26℃</temperature>                            <date>周六</date>                <dayPictureUrl>http://api.map.baidu.com/images/weather/day/leizhenyu.png</dayPictureUrl>                <nightPictureUrl>http://api.map.baidu.com/images/weather/night/dayu.png</nightPictureUrl>                <weather>雷阵雨转大雨</weather>                <wind>微风</wind>                <temperature>33 ~ 27℃</temperature>                            <date>周日</date>                <dayPictureUrl>http://api.map.baidu.com/images/weather/day/dayu.png</dayPictureUrl>                <nightPictureUrl>http://api.map.baidu.com/images/weather/night/dayu.png</nightPictureUrl>                <weather>大雨</weather>                <wind>微风</wind>                <temperature>32 ~ 26℃</temperature>                    </weather_data>        <index>                            <title>穿衣</title>                <zs>炎热</zs>                <tipt>穿衣指数</tipt>                <des>天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。</des>                            <title>洗车</title>                <zs>不宜</zs>                <tipt>洗车指数</tipt>                <des>不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。</des>                            <title>旅游</title>                <zs>一般</zs>                <tipt>旅游指数</tipt>                <des>天气较好，同时有微风相伴，但温度较高，天气热，请尽量避免高温时段外出，若外出请注意防暑降温和防晒。</des>                            <title>感冒</title>                <zs>少发</zs>                <tipt>感冒指数</tipt>                <des>各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。</des>                            <title>运动</title>                <zs>适宜</zs>                <tipt>运动指数</tipt>                <des>天气较好，赶快投身大自然参与户外运动，尽情感受运动的快乐吧。</des>                            <title>紫外线强度</title>                <zs>弱</zs>                <tipt>紫外线强度指数</tipt>                <des>紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。</des>                    </index>        <pm25>67</pm25>        </results></CityWeatherResponse>";
		
		try {
			System.out.println(XMLTool.parseXMLNodeSingleValue("CityWeatherResponse/error", xml));
			System.out.println(XMLTool.parseXMLNodeListValue("CityWeatherResponse/results//weather_data/date", xml).get(0).getNodeTypeName());
			System.out.println(XMLTool.getXMLNodeListValue("CityWeatherResponse/results//weather_data/date", xml)[0]);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
