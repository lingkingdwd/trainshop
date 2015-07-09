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
import com.trainshop.model.Users;
import com.trainshop.service.IUsersService;

@Controller
@RequestMapping("/users")
public class UsersController {

	@Resource(name = "usersService")
	private IUsersService usersService;
	
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
	public int usersCount() {

		int count = usersService.findAll().size();

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
	@RequestMapping(value = "getUserslist", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String getUserslist(HttpServletRequest request, HttpSession session) {
		String result = null;

		List<Users> userList = usersService.findAll();

		result = JsonPluginsUtil.beanListToJson(userList);

		return result;
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

//		String loginType = request.getParameter("loginType");
//		String userName = request.getParameter("userName");
//		String password = request.getParameter("password");
		
		String data = request.getParameter("data");
		
		Users paraUser = JsonPluginsUtil.jsonToBean(data, Users.class);

		if (!paraUser.getUserName().trim().equals("")) {
			if(!paraUser.getPassword().trim().equals("")){
				try {
					List<Users> users = usersService.findOne(paraUser.getUserName(), paraUser.getPassword());
					if (users.size() > 0) {
						result = "{\"flag\":\"1\",\"message\":\"登录成功！\"}";

						Users user = users.get(0);
						request.getSession(true).setAttribute("CurrentUser", user);
						request.getSession().setAttribute("CurrentUserID", "" + user.getUserId());
						request.getSession().setAttribute("CurrentUserName", user.getUserName());
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
