package com.trainshop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.trainshop.dao.ITrainGoodsDao;
import com.trainshop.dao.common.AbstractHibernateDao;
import com.trainshop.model.TrainGoods;

@Repository("trainGoodsDao")
public class TrainGoodsDao extends AbstractHibernateDao<TrainGoods> implements ITrainGoodsDao {

	public TrainGoodsDao() {
		super();
		setClazz(TrainGoods.class);
	}
	
	public List<TrainGoods> findTrainGoods()
	{
		return super.findAll();
	}
	
	public void  deleteTrainGoods(long id)
	{
		super.deleteById(id);
	}
}