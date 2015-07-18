package com.trainshop.common.util;

import java.util.List;

/**
 * 
 * @author qzhl
 *
 */

public class PageTools {
	private List dataList;
	private int totalProperty;
	
	/*private int sEcho = 1;
	private int iDisplayStart  = 1;
	private int iDisplayLength  = 10;
	private int count = 0;*/
	
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

