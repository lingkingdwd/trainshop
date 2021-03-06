package com.trainshop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trainshop.common.HtReturnData;
import com.trainshop.common.util.JsonPluginsUtil;
import com.trainshop.model.Goods;
import com.trainshop.model.Train;
import com.trainshop.model.TrainGoods;
import com.trainshop.service.ITrainService;

@Controller
@RequestMapping("/train")
public class TrainController extends BaseController {

	@Resource(name = "trainService")
	private ITrainService trainService;

	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String init(HttpServletRequest request, HttpSession session) {
		try {
			return "shop/train/list";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error";
		}
	}

	@ResponseBody
	@RequestMapping(value = "count", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String count() {

		int count = trainService.findAll().size();

		return super.returnData(count);
	}
	
	/**
	 * 获取商品列表
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getAllList", method = RequestMethod.GET, produces = { "text/json;charset=UTF-8" })
	public String getAllList(HttpServletRequest request, HttpSession session) {
		String result = null;

		List<Train> list = trainService.findAll();

		result = JsonPluginsUtil.beanListToJson(list);

		return super.returnData(result);
	}

	/**
	 * 获取列表
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getlist", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String getlist(HttpServletRequest request, HttpSession session) {
		String jsondata = request.getParameter("data");
		
		String sEcho = "";// 记录操作的次数  每次加1
		Integer iDisplayStart = 0;// 起始
		Integer iDisplayLength = 10;// size
		String sSearch = "";// 搜索的关键字
		int count = 0 ;  //查询出来的数量
		JSONArray jsonarray = JSONArray.fromObject(jsondata);
		//分别为关键的参数赋值
		for (int i = 0; i < jsonarray.size(); i++) {
			JSONObject obj = (JSONObject) jsonarray.get(i);
			if (obj.get("name").equals("sEcho"))
				sEcho = obj.get("value").toString();
			if (obj.get("name").equals("iDisplayStart"))
				iDisplayStart = Integer.parseInt(obj.get("value").toString());
			if (obj.get("name").equals("iDisplayLength"))
				iDisplayLength = Integer.parseInt(obj.get("value").toString());
			if (obj.get("name").equals("sSearch"))
				sSearch = obj.get("value").toString();
		}
		
		StringBuffer hql = new StringBuffer();
		hql.append(" From Train as model ");
		
		//为操作次数加1
		int  initEcho = Integer.parseInt(sEcho)+1;
		List<Train> list = trainService.searchByHql(hql.toString(), null, iDisplayStart, iDisplayLength);
		count = trainService.getCountByHql(hql.toString(), null);
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("recordsTotal", count);
		dataMap.put("draw",1);
		dataMap.put("recordsFiltered", count);
		dataMap.put("data", list);
		

		//List<Train> list = trainService.findAll();

		//result = JsonPluginsUtil.beanListToJson(dataMap);
		
		//JSONArray re = jsonarray.toJSONObject(dataMap); 
		JSONObject jsonObject = JSONObject.fromObject(dataMap);

		return jsonObject.toString();
	}
	/**
	 * 获取所有列车
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getAllTrains", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String getAllTrains(HttpServletRequest request, HttpSession session) {
		String result = null;
		
		List<Train> list=trainService.findAll();
		
		result=JsonPluginsUtil.beanListToJson(list);

		return super.returnData(result);
	}

	
	/**
	 * 获取某局下的列车
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getListByOrg", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String getListByOrg(HttpServletRequest request, HttpSession session) {
		String jsondata = request.getParameter("id");
		long param = Long.parseLong(jsondata);
		List<Train> data = new ArrayList<Train>();
		if(param != 0){
			data = trainService.findObjectsByPerptey(Train.class, "orgId", param);
		}
		else{
			data = trainService.findAll();
		}
		HtReturnData returnData = new HtReturnData(1, data.size(), data.size(), data);
		return returnData.toJson();
	}
	/**
	 * 添加
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "create", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String create(HttpServletRequest request, HttpSession session) {
		String data = request.getParameter("data");

		Train entity = JsonPluginsUtil.jsonToBean(data, Train.class);
		entity.setCreatetime(System.currentTimeMillis());
		if (session.getAttribute("CurrentUserID") != null) {
			entity.setCreateuser(new Long(session.getAttribute("CurrentUserID")
					.toString()));
		}
		
		entity.setUpdatetime(System.currentTimeMillis());

		trainService.create(entity);

		return super.returnSucess("保存成功！");
	}

	/**
	 * 删除
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "delete", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String delete(HttpServletRequest request, HttpSession session) {
		Short entityId = Short.valueOf(request.getParameter("data"));

		trainService.delete(trainService.find(entityId));

		return super.returnSucess("删除成功！");
	}
}
