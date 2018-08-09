package com.socodd.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socodd.entities.Nationalite;
import com.socodd.services.INationaliteService;


@Controller
@RequestMapping(value = "/nationalite")
public class NationaliteController {

	@Autowired
	private INationaliteService nationaliteService;
	
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<Nationalite> nationalites = nationaliteService.selectAll();
		if (nationalites == null) {
			nationalites = new ArrayList<Nationalite>();
		}
		model.addAttribute("nationalites", nationalites);
		return "pages/nationalite/nationalitePage";
		
	}
	
	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		Nationalite nationalite = new Nationalite();
		model.addAttribute("nationalite", nationalite);
		
		return "pages/nationalite/addUpNationalite";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, Nationalite nationalite) {
		
		if(nationalite != null) {
			if (nationalite.getId() != null) {
				nationaliteService.update(nationalite);
			} else {
				nationaliteService.save(nationalite);
				nationalite.setCode("NA"+String.valueOf(nationalite.getId()));
				nationaliteService.update(nationalite);
			}
		}
		
		return "redirect:/nationalite";
		
	}
	
	@RequestMapping(value = "/modifier/{idNationalite}")
	public String modifier(Model model, @PathVariable Integer idNationalite) {
		if (idNationalite != null) {
			Nationalite nationalite = nationaliteService.getById(idNationalite);
			if (nationalite != null) {
				model.addAttribute("nationalite", nationalite);
			}
		}
		return "pages/nationalite/addUpNationalite";
	}
	
	@RequestMapping(value = "/supprimer/{idNationalite}")
	public String supprimer(Model model, @PathVariable Integer idNationalite) {
		if (idNationalite != null) {
			Nationalite nationalite = nationaliteService.getById(idNationalite);
			if (nationalite != null) {
				nationaliteService.remove(idNationalite);
			}
		}
		return "redirect:/nationalite";
	}

}
