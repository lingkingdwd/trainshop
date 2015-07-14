package com.trainshop.service;

import java.util.List;

import com.trainshop.common.IOperations;
import com.trainshop.model.OrderInfo;

public interface IOrderInfoService extends IOperations<OrderInfo> {

	List<OrderInfo> findOne(String orderId);
}