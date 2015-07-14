package com.trainshop.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trainshop.common.util.JsonPluginsUtil;
import com.trainshop.dao.IOrderGoodsDao;
import com.trainshop.model.Goods;
import com.trainshop.model.OrderGoods;
import com.trainshop.model.OrderInfo;
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
			return "shop/goods/list";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error";
		}
	}

	@ResponseBody
	@RequestMapping(value = "orderCount", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String goodssCount() {

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

		List<OrderInfo> list = orderInfoService.findAll();

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
		
		List<OrderGoods> list = entity.getOrderGoods();

		orderInfoService.create(entity);
		
		orderGoodsService.saveOrUpdateList(list);

		return super.returnData(result);
	}
}
