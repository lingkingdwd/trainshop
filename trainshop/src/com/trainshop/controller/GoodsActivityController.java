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
import com.trainshop.model.GoodsActivity;
import com.trainshop.service.IGoodsActivityService;

@Controller
@RequestMapping("/goodsActivity")
public class GoodsActivityController extends BaseController {

	@Resource(name = "goodsActivityService")
	private IGoodsActivityService goodsActivityService;

	@RequestMapping(value = "/snatch", method = RequestMethod.GET)
	public String init(HttpServletRequest request, HttpSession session) {
		try {
			return "shop/activity/snatch";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error";
		}
	}

	/**
	 * 获取促销列表
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getAllList", method = RequestMethod.GET, produces = { "text/json;charset=UTF-8" })
	public String getAllList(HttpServletRequest request, HttpSession session) {
		String result = null;

		String data = request.getParameter("data");
		int start = 0;
		int limit = 99999;

		GoodsActivity activity = JsonPluginsUtil.jsonToBean(data,
				GoodsActivity.class);
		PageTools page = new PageTools();

		Map parameters = new HashMap();
		StringBuffer hql = new StringBuffer("");

		hql.append(" From GoodsActivity as ga where 1=1 ");

		if (activity == null) {
			int sum = goodsActivityService.getCountByHql(hql.toString(), parameters);
			List<GoodsActivity> list = goodsActivityService.searchByHql(hql.toString(), null,
					start, limit);

			page.setDataList(list);
			page.setTotalProperty(sum);

			result = JsonPluginsUtil.beanListToJson(list);

			return super.returnData(result);
		} else {
			start = activity.getStart();
			limit = activity.getLimit();
			
			if (activity.getGoodsName() != null && activity.getGoodsName() != "") {
				hql.append(" and ga.goodsName =:goodsName");
				parameters.put("goodsName", activity.getGoodsName());
			}

			int sum = goodsActivityService.getCountByHql(hql.toString(), parameters);
			List<GoodsActivity> list = goodsActivityService.searchByHql(hql.toString(), parameters,
					start, limit);

			page.setDataList(list);
			page.setTotalProperty(sum);

			result = JsonPluginsUtil.beanToJson(page);

			return super.returnData(result);
		}
	}

	/**
	 * 添加、修改促销活动
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "saveOrUpdate", method = RequestMethod.POST, produces = { "text/html;charset=UTF-8" })
	public String saveOrUpdate(HttpServletRequest request, HttpSession session) {
		String result = "";
		String data = request.getParameter("data");
		GoodsActivity entity = JsonPluginsUtil.jsonToBean(data, GoodsActivity.class);

		if (entity != null) {
			if (activityExist(entity.getGoodsName(), entity.getActName())) {
				return super.returnFail("活动已经存在！");
			}
		}

		goodsActivityService.saveOrUpdate(entity);

		return super.returnSucess(result);
	}

	/**
	 * 更新
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String update(HttpServletRequest request, HttpSession session) {
		String data = request.getParameter("data");

		GoodsActivity entity = JsonPluginsUtil.jsonToBean(data, GoodsActivity.class);

		goodsActivityService.update(entity);

		return super.returnSucess("修改成功！");
	}

	/**
	 * 删除
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String delete(HttpServletRequest request, HttpSession session) {
		String data = request.getParameter("data");

		GoodsActivity entity = JsonPluginsUtil.jsonToBean(data, GoodsActivity.class);

		goodsActivityService.deleteById(entity.getActId());

		return super.returnSucess("删除成功！");
	}

	/**
	 * 活动是否存在
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	private boolean activityExist(String actName, String actType) {
		boolean result = false;

		StringBuffer hql = new StringBuffer();
		Map parameters = new HashMap();

		hql.append(" From GoodsActivity as ga where 1=1 ");

		if (actName != null && actName != "") {
			hql.append(" and ga.actName =:actName");
			parameters.put("actName", actName);
		}
		if (actType != null && actType != "") {
			hql.append(" and ga.actType =:actType");
			parameters.put("actType", actType);
		}

		int sum = goodsActivityService.getCountByHql(hql.toString(), parameters);
		if (sum > 0) {
			result = true;
		}

		return result;
	}
}
