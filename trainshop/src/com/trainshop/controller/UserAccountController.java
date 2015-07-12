package com.trainshop.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.trainshop.common.util.JsonPluginsUtil;
import com.trainshop.model.UserAccount;
import com.trainshop.service.IUserAccountService;

@Controller
@RequestMapping("/userAccount")
public class UserAccountController extends BaseController {

    @Resource(name="userAccountService")
    private IUserAccountService userAccountService;
    
    @ResponseBody
	@RequestMapping(value = "accountCount", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8"})
    public String userAccountCount() {
        
        int count = userAccountService.findAll().size();
        
        return super.returnData(count);
    }
    
    /**
	 * 获取用户账户信息
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getUserAccountlist", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8"})
	public String getUserAccountlist(HttpServletRequest request, HttpSession session) {
		String result = null;
		
		List<UserAccount> userList = userAccountService.findAll();
		
		result = JsonPluginsUtil.beanListToJson(userList);
		
		return super.returnData(result);
	}
}
