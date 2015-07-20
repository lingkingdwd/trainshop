package com.trainshop.common;

import java.util.List;

import com.trainshop.common.util.JsonPluginsUtil;

public class HtReturnData {
	
	private int draw;
	private int recordsTotal;
	private int recordsFiltered;
	private List data;
	private String error;
	
	public String getError() {
		if(this.recordsFiltered<1)
			this.error="系统无数据";
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public HtReturnData()
	{
		
	}
	
	public HtReturnData(int draw, int recordsTotal, int recordsFiltered,
			List data) {
		super();
		this.draw = draw;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsFiltered;
		this.data = data;
	}
	
	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}
	public String toJson()
	{
		return JsonUtil.obj2Json(this);
	}

}
