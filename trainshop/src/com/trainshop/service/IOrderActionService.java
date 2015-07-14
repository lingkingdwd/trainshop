package com.trainshop.service;

import java.util.List;

import com.trainshop.common.IOperations;
import com.trainshop.model.OrderAction;

public interface IOrderActionService extends IOperations<OrderAction> {

	List<OrderAction> findOne(String orderId);
}