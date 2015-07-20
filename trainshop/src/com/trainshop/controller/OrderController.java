package com.trainshop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trainshop.common.util.JsonPluginsUtil;
import com.trainshop.common.util.PageTools;
import com.trainshop.dao.IOrderGoodsDao;
import com.trainshop.model.Goods;
import com.trainshop.model.OrderGoods;
import com.trainshop.model.OrderInfo;
import com.trainshop.model.Users;
import com.trainshop.service.IGoodsService;
import com.trainshop.service.IOrderActionService;
import com.trainshop.service.IOrderGoodsService;
import com.trainshop.service.IOrderInfoService;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {

	@Resource(name = "orderInfoService")
	private IOrderInfoService orderInfoService;
	
	@Resource(name = "orderActionService")
	private IOrderActionService orderActionService;
	
	@Resource(name = "orderGoodsService")
	private IOrderGoodsService orderGoodsService;
	
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String init(HttpServletRequest request, HttpSession session) {
		try {
			return "shop/order/list";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error";
		}
	}

	@ResponseBody
	@RequestMapping(value = "orderCount", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String orderCount() {

		int count = orderInfoService.findAll().size();

		return super.returnData(count);
	}

	/**
	 * 获取订单列表
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getlist", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String getlist(HttpServletRequest request, HttpSession session) {
		String result = null;
		
		String data = request.getParameter("data");
		int start = 0;
		int limit = 10;
		/*if(!request.getParameter("start").equals(null)){
			start = new Integer(request.getParameter("start"));
		}
		if(!request.getParameter("limit").equals(null)){
			limit = new Integer(request.getParameter("limit"));
		}*/
		
		OrderInfo order = JsonPluginsUtil.jsonToBean(data, OrderInfo.class);
		start = order.getStart();
		limit = order.getLimit();
		
		PageTools page = new PageTools();
		
		Map Parameters = new HashMap();
		StringBuffer hql = new StringBuffer();
		hql.append(" From OrderInfo as model ");
		
		if(!session.getAttribute("trainNumber").equals(null)){
			String trainNumber = session.getAttribute("trainNumber").toString();
			hql.append(" where model.trainNumber = '" + trainNumber + "'");
		}
		else{
			result = "{\"flag\":\"0\",\"message\":\"请先登录！\"}";
			return result;
		}
		if(!session.getAttribute("startTime").equals(null)){
			String startTime = session.getAttribute("startTime").toString();
			hql.append(" and model.startTime = " + startTime);
		}
		
		if (order == null || order.equals("")) {
			int sum = orderInfoService.getCountByHql(hql.toString(), null);
			List<OrderInfo> list = orderInfoService.searchByHql(hql.toString(), null, start, limit);
			
			page.setDataList(list);
			page.setTotalProperty(sum);
			
			result = JsonPluginsUtil.beanListToJson(list);
			
			return super.returnData(result);
		} else {
			if (order != null) {
				hql.append(" and model.userId =:userId");
				Parameters.put("userId", order.getUserId());

			}
			if (order.getPayStatus() != 0) {
				hql.append(" and model.payStatus =:payStatus");
				Parameters.put("payStatus", order.getPayStatus());
			}
			if (order.getOrderStatus() != 0) {
				hql.append(" and model.orderStatus =:orderStatus");
				Parameters.put("orderStatus", order.getOrderStatus());
			}
			
			int sum = orderInfoService.getCountByHql(hql.toString(), null);
			List<OrderInfo> list = orderInfoService.searchByHql(hql.toString(), null, start, limit);
			
			page.setDataList(list);
			page.setTotalProperty(sum);
			
			result = JsonPluginsUtil.beanToJson(page);
			
			return super.returnData(result);
		}
	}
	
	/**
	 * 获取订单商品列表
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getOrderGoods", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String getOrderGoods(HttpServletRequest request, HttpSession session) {
		String result = null;
		
		String orderId = request.getParameter("orderId");
		
		List<OrderGoods> list = orderGoodsService.findOne(orderId);

		result = JsonPluginsUtil.beanListToJson(list);
		
		return super.returnData(result);
	}
	
	/**
	 * 订单创建
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "create", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String create(HttpServletRequest request, HttpSession session) {
		String result = "";
		
		String data = request.getParameter("data");
		
		OrderInfo entity = JsonPluginsUtil.jsonToBean(data, OrderInfo.class);
		if(session.getAttribute("CurrentUserID").equals(null)){
			result = "{\"flag\":\"0\",\"message\":\"请先登录！\"}";
			return result;
		}
		if(session.getAttribute("CurrentUserID").equals(null)){
			result = "{\"flag\":\"0\",\"message\":\"请先登录！\"}";
			return result;
		}

		entity.setOrderStatus(0);
		entity.setShippingStatus(0);
		entity.setPayStatus(0);
		entity.setShippingStatus(0);
		entity.setShippingStatus(0);
		entity.setShippingStatus(0);
		entity.setShippingStatus(0);
		entity.setShippingStatus(0);
		
		//订单号
		String orderSn = entity.getTrainNumber() + entity.getCarriage() +  System.currentTimeMillis();
		entity.setOrderSn(orderSn);
		
		orderInfoService.create(entity);
		
		orderGoodsService.saveOrUpdateList(entity.getOrderGoods());

		return super.returnData(orderSn);
	}
}
