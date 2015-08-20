package com.trainshop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trainshop.common.util.JsonPluginsUtil;
import com.trainshop.common.util.PageTools;
import com.trainshop.model.UserRank;
import com.trainshop.service.IUserRankService;

@Controller
@RequestMapping("/userRank")
public class UserRankController extends BaseController {

	@Resource(name = "userRankService")
	private IUserRankService userRankService;
	
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String initLogin(HttpServletRequest request, HttpSession session) {
		try {
			return "shop/member/userRank";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error";
		}
	}

	@ResponseBody
	@RequestMapping(value = "count", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String usersCount() {

		int count = userRankService.findAll().size();
		
		return super.returnData(count);
	}

	/**
	 * 获取会员等级信息
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getList", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String getList(HttpServletRequest request, HttpSession session) {
		String result = null;

		String data = request.getParameter("data");

		UserRank ur = JsonPluginsUtil.jsonToBean(data, UserRank.class);

		Map parameters = new HashMap();
		StringBuffer hql = new StringBuffer();
		hql.append(" From UserRank as model where 1=1 ");

		if (ur == null) {
			List<UserRank> list = userRankService.searchByHql(hql.toString(), null);

			result = JsonPluginsUtil.beanListToJson(list);

			return super.returnData(result);
		} else {
			 if (ur.getRankName() != null  && !ur.getRankName().equals("")) { 
				 hql.append(" and model.rankName =:rankName");
				 parameters.put("rankName", ur.getRankName());
			 }
			 
			List<UserRank> list = userRankService.searchByHql(hql.toString(),
					parameters);

			result = JsonPluginsUtil.beanListToJson(list);

			return super.returnData(result);
		}
	}

	/**
	 * 会员等级创建
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "saveOrUpdate", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String saveOrUpdate(HttpServletRequest request, HttpSession session) {
		String result = null;

		String data = request.getParameter("data");
		
		UserRank ur = JsonPluginsUtil.jsonToBean(data, UserRank.class);

		if (!ur.getRankName().trim().equals("")) {
			try {
				List<UserRank> user = userRankService.findObjectsByPerptey(UserRank.class, "rankName", ur.getRankName());
				if(user.size() > 0){
					result = "{\"flag\":\"0\",\"message\":\"会员等级已经存在，请重新输入！\"}";
					return result;
				}
				
				if(ur.getRankId() == null){
					userRankService.save(ur);
				}
				else{
					userRankService.saveOrUpdate(ur);
				}
				result = "{\"flag\":\"1\",\"message\":\"创建成功！\"}";
			} catch (Exception e       ) {
				result = "{\"flag\":\"0\",\"message\":\"创建失败\"}";
				return result;
			}
		}
		else{
			result = "{\"flag\":\"0\",\"message\":\"会员等级名不能为空！\"}";
		}

		return result;
	}
	
	/**
	 * 会员等级名称检查
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "checkName", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String checkName(HttpServletRequest request, HttpSession session) {
		String result = null;

		String data = request.getParameter("data");
		
		UserRank ur = JsonPluginsUtil.jsonToBean(data, UserRank.class);

		if (!ur.getRankName().trim().equals("")) {
			try {
				List<UserRank> user = userRankService.findObjectsByPerptey(UserRank.class, "rankName", ur.getRankName());
				if(user.size() > 0){
					result = "{\"flag\":\"1\",\"message\":\"会员等级已经存在，请重新输入！\"}";
				}
			} catch (Exception e) {
				result = "{\"flag\":\"0\",\"message\":\"会员等级检查失败!\"}";
				return result;
			}
		}
		else{
			result = "{\"flag\":\"0\",\"message\":\"会员等级名称不能为空！\"}";
		}

		return result;
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

		userRankService.delete(userRankService.find(entityId));

		return super.returnSucess("删除成功！");
	}
}
