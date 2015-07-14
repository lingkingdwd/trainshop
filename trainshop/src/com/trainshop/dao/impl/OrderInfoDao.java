package com.trainshop.dao.impl;

import org.springframework.stereotype.Repository;

import com.trainshop.dao.IOrderInfoDao;
import com.trainshop.dao.common.AbstractHibernateDao;
import com.trainshop.model.OrderInfo;

@Repository("orderInfoDao")
public class OrderInfoDao extends AbstractHibernateDao<OrderInfo> implements IOrderInfoDao {

	public OrderInfoDao() {
		super();

		setClazz(OrderInfo.class);
	}
}