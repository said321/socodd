package com.socodd.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.socodd.entities.Zone;
import com.socodd.services.IZoneService;


@Controller
public class LoginController {
	
	@Autowired
	private IZoneService zoneService;
	
	@RequestMapping(value = "/")
	public String login() {
		
		return "login";
		
	}
	
	@RequestMapping(value = "/home")
	public String home(Model model, @RequestParam(defaultValue="2") int id) {
		
		
		Zone zone = zoneService.getById(id);
		
		ArrayList<Zone> zones = new ArrayList<Zone>();
		zones.add(zone);

		model.addAttribute("zones", zones);
		
		return "blank/blank";
		
	}
	
}
