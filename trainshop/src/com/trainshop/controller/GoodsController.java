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
import com.trainshop.model.Goods;
import com.trainshop.service.IGoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Resource(name = "goodsService")
	private IGoodsService goodsService;
	
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String init(HttpServletRequest request, HttpSession session) {
		try {
			return "goodList";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error";
		}
	}

	@ResponseBody
	@RequestMapping(value = "goodsCount", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public int goodssCount() {

		int count = goodsService.findAll().size();

		return count;
	}

	/**
	 * 获取用户信息
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getlist", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String getlist(HttpServletRequest request, HttpSession session) {
		String result = null;

		List<Goods> userList = goodsService.findAll();

		result = JsonPluginsUtil.beanListToJson(userList);

		return result;
	}
}
