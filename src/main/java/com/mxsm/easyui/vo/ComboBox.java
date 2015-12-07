package com.mxsm.easyui.vo;

import java.io.Serializable;

import com.mxsm.commontool.StringTool;

/**
 * easyui combobox data vo
 * @author mxsm
 *
 */

public class ComboBox implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 848294750307746448L;

	private String value;
	
	private String text;
	
	private String group;
	
	public ComboBox(){
		
		this.value = "";
		this.text = "";
		this.group = "";
	}

	public ComboBox(String value, String text, String group) {
		super();
		this.value = StringTool.isEmpty(value)? "" : value;
		this.text = StringTool.isEmpty(text)? "" : text;
		this.group = StringTool.isEmpty(group)? "" : group;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "ComboBox [value=" + value + ", text=" + text + ", group="
				+ group + "]";
	}
	
}
