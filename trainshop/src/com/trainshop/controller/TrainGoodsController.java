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
	 * 获取所有列车的所有列表
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getList", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String getList(HttpServletRequest request, HttpSession session) {
		String result = null;
		
		List<TrainGoods> list=trainGoodsService.findAll();
		
		result=JsonPluginsUtil.beanListToJson(list);

		return super.returnData(result);
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
		String result = null;
		String jsondata = request.getParameter("param");
		int param=Integer.parseInt(jsondata);
		List data=trainGoodsService.findObjectsByPerptey(TrainGoods.class, "trainId", param);
		HtReturnData returnData=new HtReturnData(1, data.size(), data.size(), data);
		return returnData.toJson();
	}
//	/**
//	 * 添加
//	 * 
//	 * @param request
//	 * @param session
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping(value = "create", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
//	public String create(HttpServletRequest request, HttpSession session) {
//		String data = request.getParameter("data");
//
//		relate entity = JsonPluginsUtil.jsonToBean(data, relate.class);
//		entity.setCreatetime(System.currentTimeMillis());
//		if (session.getAttribute("CurrentUserID").equals(null)) {
//			entity.setCreateuser(new Long(session.getAttribute("CurrentUserID")
//					.toString()));
//		}
//
//		relateService.create(entity);
//
//		return super.returnSucess("保存成功！");
//	}
//
//	/**
//	 * 删除
//	 * 
//	 * @param request
//	 * @param session
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping(value = "delete", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
//	public String delete(HttpServletRequest request, HttpSession session) {
//		Short entityId = Short.valueOf(request.getParameter("data"));
//
//		relateService.delete(relateService.find(entityId));
//
//		return super.returnSucess("删除成功！");
//	}
}
