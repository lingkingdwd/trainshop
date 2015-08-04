package com.trainshop.dao;

import java.util.List;

import com.trainshop.common.IOperations;
import com.trainshop.model.GoodsActivity;

public interface IGoodsActivityDao extends IOperations<GoodsActivity>{
	public List<GoodsActivity> findGoods();
	public void  deleteGood(long id);
}
