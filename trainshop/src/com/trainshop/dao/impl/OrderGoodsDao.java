package com.trainshop.dao.impl;

import org.springframework.stereotype.Repository;

import com.trainshop.dao.IOrderGoodsDao;
import com.trainshop.dao.common.AbstractHibernateDao;
import com.trainshop.model.OrderGoods;

@Repository("orderGoodsDao")
public class OrderGoodsDao extends AbstractHibernateDao<OrderGoods> implements IOrderGoodsDao {

	public OrderGoodsDao() {
		super();

		setClazz(OrderGoods.class);
	}
}