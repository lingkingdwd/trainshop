package com.trainshop.controller;

import java.util.List;
import java.io.Serializable;
import java.lang.reflect.Field;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trainshop.common.util.JsonPluginsUtil;
import com.trainshop.common.util.PageParameters;
import com.trainshop.common.util.PageTools;
import com.trainshop.model.UserTrain;
import com.trainshop.model.Users;
import com.trainshop.service.IUserTrainService;
import com.trainshop.service.IUsersService;

@Controller
@RequestMapping("/users")
public class UsersController extends BaseController {

	@Resource(name = "usersService")
	private IUsersService usersService;
	
	@Resource(name = "userTrainService")
	private IUserTrainService userTrainService;
	
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

		int count = usersService.findAll().size();
		
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
		
		String data = request.getParameter("data");
		int start = 0;
		int limit = 10;
		if(!request.getParameter("start").equals(null)){
			start = new Integer(request.getParameter("start"));
		}
		if(!request.getParameter("limit").equals(null)){
			limit = new Integer(request.getParameter("limit"));
		}
		
		Users user = JsonPluginsUtil.jsonToBean(data, Users.class);
		
		DetachedCriteria dc = DetachedCriteria.forClass(Users.class);  
		
		Field[] fields = Users.class.getDeclaredFields();
		for(Field f : fields){
			f.getName();
		}
		
		PageTools page = new PageTools();
		page.setDataList(usersService.searchByDetachedCriteria(dc, start, limit));
		page.setTotalProperty(usersService.getCountByDetachedCriteria(dc));
		
		result = JsonPluginsUtil.beanToJson(page);

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
						
						List utList = userTrainService.findObjectsByPerptey(UserTrain.class, "userId", user.getUserId());
						if(utList.size() > 0){
							UserTrain uTrain  = (UserTrain)utList.get(0);
							request.getSession().setAttribute("trainNumber", uTrain.getTrainNumber());
							request.getSession().setAttribute("startTime", uTrain.getStartTime());
							request.getSession().setAttribute("seatNumber", uTrain.getSeatNumber());
						}
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
	
	/**
	 * 会员注册
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "register", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String register(HttpServletRequest request, HttpSession session) {
		String result = null;

		String data = request.getParameter("data");
		
		Users paraUser = JsonPluginsUtil.jsonToBean(data, Users.class);

		if (!paraUser.getUserName().trim().equals("")) {
			if(!paraUser.getPassword().trim().equals("")){
				try {
					paraUser.setFlag(new Integer("1"));
					paraUser.setRegTime(System.currentTimeMillis());
					paraUser.setVisitCount(new Integer("0"));
					usersService.create(paraUser);
					result = "{\"flag\":\"1\",\"message\":\"注册成功！\"}";

					request.getSession(true).setAttribute("CurrentUser", paraUser);
					request.getSession().setAttribute("CurrentUserID", "" + paraUser.getUserId());
					request.getSession().setAttribute("CurrentUserName", paraUser.getUserName());
				} catch (Exception e       ) {
					result = "{\"flag\":\"0\",\"message\":\"注册失败\"}";
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
	
	/**
	 * 会员注册用户名检查
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "checkUserName", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String checkUserName(HttpServletRequest request, HttpSession session) {
		String result = null;

		String data = request.getParameter("data");
		
		Users paraUser = JsonPluginsUtil.jsonToBean(data, Users.class);

		if (!paraUser.getUserName().trim().equals("")) {
			try {
				List<Users> user = usersService.findOne(paraUser.getUserName());
				if(user.size() > 0){
					result = "{\"flag\":\"1\",\"message\":\"用户名已经存在，请重新输入！\"}";
				}
			} catch (Exception e) {
				result = "{\"flag\":\"0\",\"message\":\"用户名检查失败!\"}";
				return result;
			}
		}
		else{
			result = "{\"flag\":\"0\",\"message\":\"用户名不能为空！\"}";
		}

		return result;
	}
}
