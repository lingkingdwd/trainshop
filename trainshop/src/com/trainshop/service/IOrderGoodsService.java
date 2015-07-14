package com.trainshop.service;

import java.util.List;

import com.trainshop.common.IOperations;
import com.trainshop.model.OrderGoods;

public interface IOrderGoodsService extends IOperations<OrderGoods> {

	List<OrderGoods> findOne(String orderId);
}