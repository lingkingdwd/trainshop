package com.trainshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.trainshop.common.IOperations;
import com.trainshop.dao.IOrderGoodsDao;
import com.trainshop.model.OrderGoods;
import com.trainshop.service.IOrderGoodsService;
import com.trainshop.service.common.AbstractService;

@Service("orderGoodsService")
public class OrderGoodsService extends AbstractService<OrderGoods> implements IOrderGoodsService {

    @Resource(name="orderGoodsDao")
    private IOrderGoodsDao orderGoodsDao;
    
    public OrderGoodsService() {
        super();
    }

    @Override
    protected IOperations<OrderGoods> getDao() {
        return this.orderGoodsDao;
    }

	@Override
	public List<OrderGoods> findOne(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}
}