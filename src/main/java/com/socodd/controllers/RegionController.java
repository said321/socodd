package com.socodd.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socodd.entities.Region;
import com.socodd.services.IRegionService;


@Controller
@RequestMapping(value = "/region")
public class RegionController {

	@Autowired
	private IRegionService regionService;
	
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<Region> regions = regionService.selectAll();
		if (regions == null) {
			regions = new ArrayList<Region>();
		}
		model.addAttribute("regions", regions);
		return "pages/region/regionPage";
		
	}
	
	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		Region region = new Region();
		model.addAttribute("region", region);
		
		return "pages/region/addUpRegion";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, Region region) {
		
		if(region != null) {
			if (region.getId() != null) {
				regionService.update(region);
			} else {
				regionService.save(region);
				region.setCode("RG"+String.valueOf(region.getId()));
				regionService.update(region);
			}
		}
		
		return "redirect:/region";
		
	}
	
	@RequestMapping(value = "/modifier/{idRegion}")
	public String modifier(Model model, @PathVariable Integer idRegion) {
		if (idRegion != null) {
			Region region = regionService.getById(idRegion);
			if (region != null) {
				model.addAttribute("region", region);
			}
		}
		return "pages/region/addUpRegion";
	}
	
	@RequestMapping(value = "/supprimer/{idRegion}")
	public String supprimer(Model model, @PathVariable Integer idRegion) {
		if (idRegion != null) {
			Region region = regionService.getById(idRegion);
			if (region != null) {
				regionService.remove(idRegion);
			}
		}
		return "redirect:/region";
	}

}
