package com.trainshop.controller;

import java.util.ArrayList;
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

import com.alibaba.fastjson.JSONObject;
import com.trainshop.common.HtReturnData;
import com.trainshop.common.JsonUtil;
import com.trainshop.common.util.JsonPluginsUtil;
import com.trainshop.common.util.PageTools;
import com.trainshop.model.Goods;
import com.trainshop.model.OrderAction;
import com.trainshop.model.OrderGoods;
import com.trainshop.model.OrderInfo;
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
	
	@RequestMapping(value = "/orderInit", method = RequestMethod.GET)
	public String init(HttpServletRequest request, HttpSession session) {
		try {
			return "shop/order/order_list";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error";
		}
	}
	@RequestMapping(value = "/backInit", method = RequestMethod.GET)
	public String backInit(HttpServletRequest request, HttpSession session) {
		try {
			return "shop/order/back_list";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error";
		}
	}
	@RequestMapping(value = "/shipInit", method = RequestMethod.GET)
	public String shipInit(HttpServletRequest request, HttpSession session) {
		try {
			return "shop/order/ship_list";
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
		
		OrderInfo order = JsonPluginsUtil.jsonToBean(data, OrderInfo.class);
		start = order.getStart();
		limit = order.getLimit();
		
		PageTools page = new PageTools();
		
		Map parameters = new HashMap();
		StringBuffer hql = new StringBuffer();
		hql.append(" From OrderInfo as model where 1=1 ");
		
		/*if(session.getAttribute("trainNumber") != null){
			String trainNumber = session.getAttribute("trainNumber").toString();
			hql.append(" where model.trainNumber = '" + trainNumber + "'");
		}
		else{
			result = "{\"flag\":\"0\",\"message\":\"请先登录！\"}";
			return result;
		}
		if(session.getAttribute("startTime") != null){
			String startTime = session.getAttribute("startTime").toString();
			hql.append(" and model.startTime = " + startTime);
		}*/
		
		if (order == null || order.equals("")) {
			int sum = orderInfoService.getCountByHql(hql.toString(), null);
			List<OrderInfo> list = orderInfoService.searchByHql(hql.toString(), null, start, limit);
			
			page.setDataList(list);
			page.setTotalProperty(sum);
			
			result = JsonPluginsUtil.beanListToJson(list);
			
			return super.returnData(result);
		} else {
			/*if (order != null) {
				hql.append(" and model.userId =:userId");
				Parameters.put("userId", order.getUserId());

			}*/
			/*if (order.getPayStatus() != null) {
				hql.append(" and model.payStatus =:payStatus");
				Parameters.put("payStatus", order.getPayStatus());
			}
			if (order.getOrderStatus() != 0) {
				hql.append(" and model.orderStatus =:orderStatus");
				Parameters.put("orderStatus", order.getOrderStatus());
			}*/
			
			int sum = orderInfoService.getCountByHql(hql.toString(), parameters);
			List<OrderInfo> list = orderInfoService.searchByHql(hql.toString(), parameters, start, limit);
			
			for(OrderInfo oi : list){
				oi.setOrderGoods(this.getOrderGoods(oi.getOrderId()));
			}
			
			page.setDataList(list);
			page.setTotalProperty(sum);
			
			result = JsonPluginsUtil.beanToJson(page);
			
			return super.returnData(result);
		}
	}
	
	
	/**
	 * 获取订单列表
	 * 
	 * @param request
	 * @param session
	 * @return
	 * author:lingking
	 */
	@ResponseBody
	@RequestMapping(value = "getOrderlist", method = RequestMethod.GET, produces = { "text/json;charset=UTF-8" })
	public String getOrderlist(HttpServletRequest request, HttpSession session) {
		HtReturnData result = new HtReturnData();
		
		Map parameters = new HashMap();
		StringBuffer hql = new StringBuffer();
		hql.append(" From OrderInfo as model where 1=1 order by model.orderId DESC");
		
		List<OrderInfo> orders = orderInfoService.searchByHql(hql.toString(), null);
		int total = orders.size();
		result.setData(orders);
		result.setDraw(0);
		result.setRecordsFiltered(total);
		result.setRecordsTotal(total);
		
		return result.toJson();
			
	}
	
	/**
	 * 获取退货列表
	 * 
	 * @param request
	 * @param session
	 * @return
	 * author:lingking
	 */
	@ResponseBody
	@RequestMapping(value = "getBacklist", method = RequestMethod.GET, produces = { "text/json;charset=UTF-8" })
	public String getBacklist(HttpServletRequest request, HttpSession session) {
		HtReturnData result = new HtReturnData();

		List<OrderAction> orders = orderActionService.findObjectsByPerptey(OrderAction.class, "orderStatus", 4);
		int total=orders.size();
		result.setData(orders);
		result.setDraw(0);
		result.setRecordsFiltered(total);
		result.setRecordsTotal(total);
		
		return result.toJson();
			
	}
	
	/**
	 * 获取发货列表
	 * 
	 * @param request
	 * @param session
	 * @return
	 * author:lingking
	 */
	@ResponseBody
	@RequestMapping(value = "getShiplist", method = RequestMethod.GET, produces = { "text/json;charset=UTF-8" })
	public String getShiplist(HttpServletRequest request, HttpSession session) {
		HtReturnData result = new HtReturnData();

		List<OrderAction> orders = orderActionService.findObjectsByPerptey(OrderAction.class, "shippingStatus", 1);
		int total=orders.size();
		result.setData(orders);
		result.setDraw(0);
		result.setRecordsFiltered(total);
		result.setRecordsTotal(total);
		
		return result.toJson();
			
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
		String result = "";
		
		String data = request.getParameter("data");

		OrderGoods goods = JsonPluginsUtil.jsonToBean(data, OrderGoods.class);
		
		Map parameters = new HashMap();
		StringBuffer hql = new StringBuffer();
		hql.append(" From OrderGoods as model where 1=1 ");
		
		if (goods != null) {
			hql.append(" and model.orderId =:orderId");
			
			parameters.put("orderId", goods.getOrderId());
			
			
			List<OrderGoods> list = orderGoodsService.searchByHql(hql.toString(), parameters);

			result = JsonPluginsUtil.beanListToJson(list);

			return super.returnData(result);
		}

		return super.returnData(result);
	}
	
	/**
	 * 查询订单列表
	 * 
	 * @param request
	 * @param session
	 * @return
	 * author:lingking
	 */
	@ResponseBody
	@RequestMapping(value = "queryOrderlist", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String queryOrderlist(HttpServletRequest request, HttpSession session) {
		HtReturnData result = new HtReturnData();
		String param = request.getParameter("data");
		JSONObject obj = JSONObject.parseObject(param);
		
		StringBuffer hql = new StringBuffer(" from OrderInfo where 1 = 1");
		
		if(obj != null){
			if(!obj.get("trainNumber").equals("")){
				hql.append(" and trainNumber LIKE '%" + obj.get("trainNumber") + "%'");
			}
			if(!obj.get("orderSn").equals("")){
				hql.append(" and orderSn LIKE '%" + obj.get("orderSn") + "%'");
			}
			if(obj.get("orderStatus") != null){
				hql.append(" and orderStatus ='" + obj.get("orderStatus") + "'");
			}
		}
		
		hql.append("order by orderId DESC");
		
		List<OrderInfo> orders = orderInfoService.searchByHql(hql.toString(),null);
		int total=orders.size();
		result.setData(orders);
		result.setDraw(0);
		result.setRecordsFiltered(total);
		result.setRecordsTotal(total);
		
		return result.toJson();
			
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
		String data = request.getParameter("data");
		
		OrderInfo entity = JsonUtil.json2Bean(data, OrderInfo.class);
		/*if(session.getAttribute("CurrentUserID").equals(null)){
			result = "{\"flag\":\"0\",\"message\":\"请先登录！\"}";
			return result;
		}
		if(session.getAttribute("CurrentUserID").equals(null)){
			result = "{\"flag\":\"0\",\"message\":\"请先登录！\"}";
			return result;
		}*/

		entity.setOrderStatus(0);
		entity.setShippingStatus(0);
		entity.setPayStatus(0);
		entity.setAddTime(System.currentTimeMillis());
		
		entity.setIsSeparate(0);
		
		//订单号
		String orderSn = entity.getTrainNumber() + entity.getCarriage() +  System.currentTimeMillis();
		entity.setOrderSn(orderSn);
		
		orderInfoService.create(entity);
		
		List<OrderInfo> info = orderInfoService.findObjectsByPerptey(OrderInfo.class, "orderSn", orderSn);
		if(info.size() > 0){
			for(OrderGoods og : entity.getOrderGoods()){
				og.setOrderId(info.get(0).getOrderId());
			}
			orderGoodsService.saveOrUpdateList(entity.getOrderGoods());
		}

		return super.returnData(orderSn, "订单创建成功！");
	}
	
	/**
	 * 更新订单状态
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "orderStatus", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String updateOrderStatus(HttpServletRequest request, HttpSession session) {
		String result = "";
		
		String data = request.getParameter("data");
		
		OrderInfo order = JsonPluginsUtil.jsonToBean(data, OrderInfo.class);
		if(order.getOrderStatus() == 0){
			result = "订单未确认！";
		}
		if(order.getOrderStatus() == 1){
			result = "订单已确认！";
		}
		if(order.getOrderStatus() == 2){
			result = "订单已取消！";
		}
		if(order.getOrderStatus() == 3){
			result = "订单无效！";
		}
		if(order.getOrderStatus() == 4){
			result = "订单已退货！";
		}
		
		Map parameters = new HashMap();
		StringBuffer hql = new StringBuffer();
		hql.append(" update OrderInfo set orderStatus =:orderStatus where orderSn =:orderSn ");
		parameters.put("orderStatus", order.getOrderStatus());
		parameters.put("orderSn", order.getOrderSn());
			
		orderInfoService.updateByHql(hql.toString(), parameters);
		
		return super.returnSucess(result);
	}
	
	/**
	 * 商品配送情况
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "shippingStatus", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String updateShippingStatus(HttpServletRequest request, HttpSession session) {
		String result = "";
		
		String data = request.getParameter("data");
		
		OrderInfo order = JsonPluginsUtil.jsonToBean(data, OrderInfo.class);
		if(order.getOrderStatus() == 0){
			result = "未发货！";
		}
		if(order.getOrderStatus() == 1){
			result = "已发货！";
		}
		if(order.getOrderStatus() == 2){
			result = "已收货！";
		}
		if(order.getOrderStatus() == 4){
			result = "退货！";
		}
		
		Map parameters = new HashMap();
		StringBuffer hql = new StringBuffer();
		hql.append(" update OrderInfo set shippingStatus =:shippingStatus where orderSn =:orderSn ");
		parameters.put("shippingStatus", order.getShippingStatus());
		parameters.put("orderSn", order.getOrderSn());
			
		orderInfoService.updateByHql(hql.toString(), parameters);
		
		return super.returnSucess(result);
	}
	
	/**
	 * 付款状态
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "payStatus", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String updatePayStatus(HttpServletRequest request, HttpSession session) {
		String result = "";
		
		String data = request.getParameter("data");
		
		OrderInfo order = JsonPluginsUtil.jsonToBean(data, OrderInfo.class);
		if(order.getOrderStatus() == 0){
			result = "未付款！";
		}
		if(order.getOrderStatus() == 1){
			result = "付款中！";
		}
		if(order.getOrderStatus() == 2){
			result = "已付款！";
		}
		
		Map parameters = new HashMap();
		StringBuffer hql = new StringBuffer();
		hql.append(" update OrderInfo set payStatus =:payStatus where orderSn =:orderSn ");
		parameters.put("payStatus", order.getPayStatus());
		parameters.put("orderSn", order.getOrderSn());
			
		orderInfoService.updateByHql(hql.toString(), parameters);
		
		return super.returnSucess(result);
	}
	
	private List<OrderGoods> getOrderGoods(Long orderId) {
		Map parameters = new HashMap();
		StringBuffer hql = new StringBuffer();
		hql.append(" From OrderGoods as model where 1=1 ");
		
		if (orderId != null) {
			hql.append(" and model.orderId =:orderId");
			
			parameters.put("orderId", orderId);
			
			
			return orderGoodsService.searchByHql(hql.toString(), parameters);
		}

		return new ArrayList<OrderGoods>();
	}
}
