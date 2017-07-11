package com.cand.source.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	private static final String HOME_PAGE = "home/index";
	private static final String LOGIN_PAGE = "home/login";
	private static final String NO_PERMISSION = "home/noPermission";

	@RequestMapping(value = { "/", "/home", "/index" }, method = RequestMethod.GET)
	public String showHome(@RequestParam(value = "login", required = false) String loginRequest, ModelMap map) {
		
		if (loginRequest != null && !"".equals(loginRequest))
			map.put("loginAlert", loginRequest);

		return HOME_PAGE;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm() {

		return LOGIN_PAGE;
	}

	@RequestMapping(value = "/nopermission", method = RequestMethod.GET)
	public String showAccessDenied() {

		return NO_PERMISSION;
	}

}
