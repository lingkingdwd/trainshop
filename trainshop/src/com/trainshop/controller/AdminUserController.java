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
import com.trainshop.model.AdminUser;
import com.trainshop.model.Train;
import com.trainshop.service.IAdminUserService;
import com.trainshop.service.ITrainService;

@Controller
@RequestMapping("/adminUserController")
public class AdminUserController extends BaseController {

	@Resource(name = "adminUserService")
	private IAdminUserService adminUserService;
	
	@Resource(name = "trainService")
	private ITrainService trainService;
	
	@RequestMapping(value = "/initLogin", method = RequestMethod.GET)
	public String initLogin(HttpServletRequest request, HttpSession session) {
		try {
			return "login";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error";
		}
	}

	@ResponseBody
	@RequestMapping(value = "usersCount", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String usersCount() {

		int count = adminUserService.findAll().size();

		return super.returnData(count);
	}

	/**
	 * 获取用户信息
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getUserslist", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String getUserslist(HttpServletRequest request, HttpSession session) {
		String result = null;

		List<AdminUser> userList = adminUserService.findAll();

		result = JsonPluginsUtil.beanListToJson(userList);

		return super.returnData(result);
	}

	/**
	 * 登录
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "loginAction", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String loginAction(HttpServletRequest request, HttpSession session) {
		String result = null;

		String data = request.getParameter("data");
		
		AdminUser paraUser = JsonPluginsUtil.jsonToBean(data, AdminUser.class);

		if (!paraUser.getUserName().trim().equals("")) {
			if(!paraUser.getPassword().trim().equals("")){
				try {
					List<AdminUser> users = adminUserService.findOne(paraUser.getUserName(), paraUser.getPassword());
					if (users.size() > 0) {
						result = "{\"flag\":\"1\",\"message\":\"登录成功！\"}";

						AdminUser user = users.get(0);
						request.getSession(true).setAttribute("CurrentUser", user);
						request.getSession().setAttribute("CurrentUserID", "" + user.getUserId());
						request.getSession().setAttribute("CurrentUserName", user.getUserName());
						
						Train train = trainService.find(user.getTrainId());
						request.getSession().setAttribute("trainNumber", train.getTrainNumber());
						request.getSession().setAttribute("startTime", train.getStartTime());
					}
					else{
						result = "{\"flag\":\"0\",\"message\":\"用户名或密码不对！\"}";
					}
				} catch (Exception e) {
					result = "{\"flag\":\"0\",\"message\":\"登录失败\"}";
					return result;
				}
			}
			else{
				result = "{\"flag\":\"0\",\"message\":\"密码不能为空！\"}";
			}
		}
		else{
			result = "{\"flag\":\"0\",\"message\":\"用户名不能为空！\"}";
		}

		return result;
	}
}
