package com.cand.source.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/forum")
public class ForumController {

	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String showForumHome(ModelMap map){
		
		
		
		return "forum/home";
	}
}
