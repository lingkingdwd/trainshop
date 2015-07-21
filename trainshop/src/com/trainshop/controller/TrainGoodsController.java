package com.trainshop.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trainshop.common.HtReturnData;
import com.trainshop.common.util.JsonPluginsUtil;
import com.trainshop.model.TrainGoods;
import com.trainshop.service.ITrainGoodsService;

@Controller
@RequestMapping("/trainGoods")
public class TrainGoodsController extends BaseController {

	@Resource(name = "trainGoodsService")
	private ITrainGoodsService trainGoodsService;

	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String init(HttpServletRequest request, HttpSession session) {
		try {
			return "shop/trainManage/list";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error";
		}
	}

	
	/**
	 * 获取某列车的商品列表
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getListByTrain", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String getListByTrain(HttpServletRequest request, HttpSession session) {
		String jsondata = request.getParameter("id");
		List data=trainGoodsService.findObjectsByPerptey(TrainGoods.class, "trainId", Long.parseLong(jsondata));
		HtReturnData returnData=new HtReturnData(1, data.size(), data.size(), data);
		return returnData.toJson();
	}
	/**
	 * 上架商品
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/onGood", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String onGood(HttpServletRequest request, HttpSession session) {
		String data = request.getParameter("data");
		TrainGoods entity = JsonPluginsUtil.jsonToBean(data, TrainGoods.class);
		trainGoodsService.create(entity);
		return super.returnSucess("上架成功！");
	}

	/**
	 * 下架商品
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/offGood", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String offGood(HttpServletRequest request, HttpSession session) {
		String jsondata = request.getParameter("id");
		trainGoodsService.deleteById(Long.parseLong(jsondata));
		return super.returnSucess("下架成功！");
	}
}
