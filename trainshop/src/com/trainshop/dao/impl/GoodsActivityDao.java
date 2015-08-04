package com.trainshop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.trainshop.dao.IGoodsActivityDao;
import com.trainshop.dao.common.AbstractHibernateDao;
import com.trainshop.model.GoodsActivity;

@Repository("goodsActivityDao")
public class GoodsActivityDao extends AbstractHibernateDao<GoodsActivity> implements IGoodsActivityDao {

	public GoodsActivityDao() {
		super();
		setClazz(GoodsActivity.class);
	}
	
	public List<GoodsActivity> findGoods()
	{
		return super.findAll();
	}
	
	public void  deleteGood(long id)
	{
		super.deleteById(id);
	}
}