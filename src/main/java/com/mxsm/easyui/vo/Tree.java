package com.mxsm.easyui.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mxsm.commontool.StringTool;

/**
 * easy ui tree
 * @author mxsm
 *
 */

public class Tree implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6076705948649548785L;

	public static final String TREE_NODE_CLOSED = "closed";
	
	public static final String TREE_NODE_OPENED = "open";
	
	private String id;
	
	private String text;
	
	private String state;
	
	private List<Tree> children;

	public Tree() {
		super();
		// TODO Auto-generated constructor stub
		this.id = "";
		this.text = "";
		this.state = "";
		this.children = new ArrayList<Tree>();
	}

	public Tree(String id, String text, String state, List<Tree> children) {
		super();
		this.id = StringTool.isEmpty(id)? "" : id;
		this.text = StringTool.isEmpty(text)? "" : text;
		this.state = StringTool.isEmpty(state)? "" : state;
		this.children = children == null? new ArrayList<Tree>() : children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Tree> getChildren() {
		return children;
	}

	public void setChildren(List<Tree> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Tree [id=" + id + ", text=" + text + ", state=" + state
				+ ", children=" + children + "]";
	}
	
}
