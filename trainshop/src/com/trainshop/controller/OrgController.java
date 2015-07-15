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
import com.trainshop.model.Org;
import com.trainshop.service.IOrgService;

@Controller
@RequestMapping("/org")
public class OrgController extends BaseController{

	@Resource(name = "orgService")
	private IOrgService orgService;
	
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String init(HttpServletRequest request, HttpSession session) {
		try {
			return "shop/org/list";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error";
		}
	}

	@ResponseBody
	@RequestMapping(value = "count", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String count() {

		int count = orgService.findAll().size();

		return super.returnData(count);
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
		String result = null;

		List<Org> list = orgService.findAll();

		result = JsonPluginsUtil.beanListToJson(list);
		
		return super.returnData(result);
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
		
		Org entity = JsonPluginsUtil.jsonToBean(data, Org.class);
		entity.setCreatetime(System.currentTimeMillis());
		if(session.getAttribute("CurrentUserID").equals(null)){
			entity.setCreateuser(new Long(session.getAttribute("CurrentUserID").toString()));
		}

		orgService.create(entity);

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
		
		orgService.delete(orgService.find(entityId));

		return super.returnSucess("删除成功！");
	}
}
