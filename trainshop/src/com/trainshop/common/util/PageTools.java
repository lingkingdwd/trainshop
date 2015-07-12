package com.trainshop.common.util;

import java.util.List;

/**
 * 
 * @author qzhl
 *
 */

public class PageTools {
	private Object[] data;
	private List dataList;
	private int totalProperty;
	
	public Object[] getData() {
		return data;
	}
	public void setData(Object[] data) {
		this.data = data;
	}
	public int getTotalProperty() {
		return totalProperty;
	}
	public void setTotalProperty(int totalProperty) {
		this.totalProperty = totalProperty;
	}
	public List getDataList() {
		return dataList;
	}
	public void setDataList(List dataList) {
		this.dataList = dataList;
	}
}

