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
import com.trainshop.model.Category;
import com.trainshop.service.ICategoryService;

@Controller
@RequestMapping("/categoryController")
public class CategoryController {

	@Resource(name = "categoryService")
	private ICategoryService categoryService;
	
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String init(HttpServletRequest request, HttpSession session) {
		try {
			return "list";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error";
		}
	}

	@ResponseBody
	@RequestMapping(value = "count", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public int count() {

		int count = categoryService.findAll().size();

		return count;
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

		List<Category> list = categoryService.findAll();

		result = JsonPluginsUtil.beanListToJson(list);

		return result;
	}
}
