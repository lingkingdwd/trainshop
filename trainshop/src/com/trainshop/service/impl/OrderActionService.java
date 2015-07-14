package com.trainshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.trainshop.common.IOperations;
import com.trainshop.dao.IOrderActionDao;
import com.trainshop.model.OrderAction;
import com.trainshop.service.IOrderActionService;
import com.trainshop.service.common.AbstractService;

@Service("orderActionService")
public class OrderActionService extends AbstractService<OrderAction> implements IOrderActionService {

    @Resource(name="orderActionDao")
    private IOrderActionDao orderActionDao;
    
    public OrderActionService() {
        super();
    }

    @Override
    protected IOperations<OrderAction> getDao() {
        return this.orderActionDao;
    }

	@Override
	public List<OrderAction> findOne(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}
}