package com.trainshop.dao;

import java.util.List;

import com.trainshop.common.IOperations;
import com.trainshop.model.TrainGoods;

public interface ITrainGoodsDao extends IOperations<TrainGoods>{
	public List<TrainGoods> findTrainGoods();
	public void  deleteTrainGoods(long id);
}
