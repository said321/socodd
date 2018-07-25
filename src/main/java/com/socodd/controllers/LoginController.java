package com.socodd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {
	
	@RequestMapping(value = {"/", "/login"})
	public String login() {
		
		return "login/login";
		
	}
	
	@RequestMapping(value = "/home")
	public String home(Model model) {
		
		return "blank/blank";
		
	}
	
	@RequestMapping(value = "/error")
	public String error(Model model) {
		
		return "error/errorPage";
		
	}
	
}
