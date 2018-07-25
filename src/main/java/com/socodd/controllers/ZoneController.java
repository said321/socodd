package com.socodd.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socodd.entities.Zone;
import com.socodd.services.IZoneService;


@Controller
@RequestMapping(value = "/zone")
public class ZoneController {

	@Autowired
	private IZoneService zoneService;
	
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<Zone> zones = zoneService.selectAll();
		if (zones == null) {
			zones = new ArrayList<Zone>();
		}
		model.addAttribute("zones", zones);
		return "pages/zone/zonePage";
		
	}
	
	@RequestMapping(value = "/modifier")
	public String modifier(Model model) {
		
		return "pages/zone/addUpZone";
		
	}

	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		Zone zone = new Zone();
		model.addAttribute("zone", zone);
		
		return "pages/zone/addUpZone";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, Zone zone) {
		
		System.out.println(zone.getNom() + " <> " + zone.getCode());
		
		if(zone != null) {
			if (zone.getId() != null) {
				zoneService.update(zone);
			} else {
				zoneService.save(zone);
			}
		}
		
		return "redirect:/zone";
		
	}
	
	@RequestMapping(value = "/modifier/{idZone}")
	public String modifier(Model model, @PathVariable Integer idZone) {
		if (idZone != null) {
			Zone zone = zoneService.getById(idZone);
			if (zone != null) {
				model.addAttribute("zone", zone);
			}
		}
		return "pages/zone/addUpZone";
	}
	
	@RequestMapping(value = "/supprimer/{idZone}")
	public String supprimer(Model model, @PathVariable Integer idZone) {
		if (idZone != null) {
			Zone zone = zoneService.getById(idZone);
			if (zone != null) {
				zoneService.remove(idZone);
			}
		}
		return "redirect:/zone";
	}

}
