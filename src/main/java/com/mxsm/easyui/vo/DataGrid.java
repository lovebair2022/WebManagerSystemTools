package com.mxsm.easyui.vo;

import java.io.Serializable;
import java.util.List;

/**
 * easyui datagrid
 * @author mxsm
 *
 */

public class DataGrid<E> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4309501957329615698L;

	private long total; //数据条数
	
	private List<E> rows; //数据集

	public DataGrid(long total, List<E> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public DataGrid() {
		super();
		// TODO Auto-generated constructor stub
		this.total = 0L;
	}

	public long getTotal() {
		if(total <= 0){
			if(rows != null && (rows.size() > 0)){
				total = rows.size();
			}
		}
		
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<E> getRows() {
		return rows;
	}

	public void setRows(List<E> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "DataGrid [total=" + total + ", rows=" + rows + "]";
	}
	
}
