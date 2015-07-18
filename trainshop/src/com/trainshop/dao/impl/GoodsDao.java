package com.trainshop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.trainshop.dao.IGoodsDao;
import com.trainshop.dao.common.AbstractHibernateDao;
import com.trainshop.model.Goods;

@Repository("goodsDao")
public class GoodsDao extends AbstractHibernateDao<Goods> implements IGoodsDao {

	public GoodsDao() {
		super();
		setClazz(Goods.class);
	}
	
	public List<Goods> findGoods()
	{
		return super.findAll();
	}
}