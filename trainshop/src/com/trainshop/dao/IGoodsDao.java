package com.trainshop.dao;

import java.util.List;

import com.trainshop.common.IOperations;
import com.trainshop.model.Goods;

public interface IGoodsDao extends IOperations<Goods>{
	public List<Goods> findGoods();
	public void  deleteGood(long id);
}
