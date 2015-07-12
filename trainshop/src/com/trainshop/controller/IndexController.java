package com.trainshop.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/indexController")
public class IndexController extends BaseController{

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String initLogin(HttpServletRequest request, HttpSession session) {
		try {
			return "index";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error";
		}
	}
}
