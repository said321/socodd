package com.socodd.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socodd.entities.Zone;
import com.socodd.services.IZoneService;

@Controller
@RequestMapping(value = "/zone")
public class ZoneController {

	@Autowired
	private IZoneService zoneService;
	
	@RequestMapping(value = "/")
	public String all(Model model) {
		
		List<Zone> zones = zoneService.selectAll();
		if (zones == null) {
			zones = new ArrayList<Zone>();
		}
		model.addAttribute("zones", zones);
		return "blank/blank";
		
	}
	
	@RequestMapping(value = "/one")
	public String one(Model model) {
		
		int id = 1;
		
		Zone zone = zoneService.getById(id);
		
		ArrayList<Zone> zones = new ArrayList<Zone>();
		zones.add(zone);

		model.addAttribute("zones", zones);
		return "blank/blank";
		
	}
	
	@RequestMapping(value = "/add")
	public String add(Model model) {
		
		Zone zone = new Zone("Z1","Casa");
		zoneService.save(zone);
		return "blank/blank";
		
	}
	

}
