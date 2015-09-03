package com.trainshop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.trainshop.model.Train;
import com.trainshop.model.UserRank;
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
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request, HttpSession session) {
		try {
			return "shop/member/list";
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
		String pay_points_lt =request.getParameter("pay_points_lt");
		String pay_points_gt =request.getParameter("pay_points_gt");

		Users us = JsonPluginsUtil.jsonToBean(data, Users.class);

		Map parameters = new HashMap();
		StringBuffer hql = new StringBuffer();
		hql.append(" From Users as model where 1=1 ");

		if (us == null) {
			List<Users> list = usersService.searchByHql(hql.toString(), null);

			result = JsonPluginsUtil.beanListToJson(list);

			return super.returnData(result);
		} else {
			 if (us.getUserName() != null  && !us.getUserName().equals("")) { 
				 hql.append(" and model.userName like '%" + us.getUserName() +"%'");
			 }
			 
			 if (pay_points_lt != null  && !"".equals(pay_points_lt)) { 
				 hql.append(" and model.payPoints <:pay_points_lt");
				 parameters.put("pay_points_lt", Integer.valueOf(pay_points_lt));
			 }
			 
			 if (pay_points_gt != null  && !"".equals(pay_points_gt)) { 
				 hql.append(" and model.payPoints >=:pay_points_gt");
				 parameters.put("pay_points_gt", Integer.valueOf(pay_points_gt));
			 }
			 
			 if (us.getUserRank() != null  && !us.getUserRank().equals("")) { 
				 hql.append(" and model.userRank >=:userRank");
				 parameters.put("userRank", us.getUserRank());
			 }
			List<Users> list = usersService.searchByHql(hql.toString(),
					parameters);

			result = JsonPluginsUtil.beanListToJson(list);

			return super.returnData(result);
		}
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
					
					List<Users> user = usersService.findOne(paraUser.getUserName());
					if(user.size() > 0){
						result = "{\"flag\":\"0\",\"message\":\"用户名已经存在，请重新输入！\"}";
						return result;
					}
					
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
	
	/**
	 * 用户车次信息添加
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addUserTrain", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String addUserTrain(HttpServletRequest request, HttpSession session) {
		String data = request.getParameter("data");

		UserTrain entity = JsonPluginsUtil.jsonToBean(data, UserTrain.class);
		if (session.getAttribute("CurrentUserID").equals(null)) {
			entity.setUserId(new Long(session.getAttribute("CurrentUserID")
					.toString()));
		}

		userTrainService.create(entity);

		return super.returnSucess("保存成功！");
	}
}
