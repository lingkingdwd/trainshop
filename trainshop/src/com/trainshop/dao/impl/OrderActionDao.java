package com.trainshop.dao.impl;

import org.springframework.stereotype.Repository;

import com.trainshop.dao.IOrderActionDao;
import com.trainshop.dao.common.AbstractHibernateDao;
import com.trainshop.model.OrderAction;

@Repository("orderActionDao")
public class OrderActionDao extends AbstractHibernateDao<OrderAction> implements IOrderActionDao {

	public OrderActionDao() {
		super();

		setClazz(OrderAction.class);
	}
}