package com.trainshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.trainshop.common.IOperations;
import com.trainshop.dao.IOrderInfoDao;
import com.trainshop.model.OrderInfo;
import com.trainshop.service.IOrderInfoService;
import com.trainshop.service.common.AbstractService;

@Service("orderInfoService")
public class OrderInfoService extends AbstractService<OrderInfo> implements IOrderInfoService {

    @Resource(name="orderInfoDao")
    private IOrderInfoDao orderInfoDao;
    
    public OrderInfoService() {
        super();
    }

    @Override
    protected IOperations<OrderInfo> getDao() {
        return this.orderInfoDao;
    }

	@Override
	public List<OrderInfo> findOne(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}
}