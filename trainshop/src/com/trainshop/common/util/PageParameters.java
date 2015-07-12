package com.trainshop.common.util;

import java.io.Serializable;

/**
 * 
 * @author qzhl
 *
 */

public class PageParameters<T extends Serializable> implements java.io.Serializable{
	
	private int start;
	private int limit;
	private T entity;
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public T getEntity() {
		return entity;
	}
	public void setEntity(T entity) {
		this.entity = entity;
	}
	
}

