package com.socodd.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socodd.entities.Devise;
import com.socodd.services.IDeviseService;


@Controller
@RequestMapping(value = "/devise")
public class DeviseController {

	@Autowired
	private IDeviseService deviseService;
	
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<Devise> devises = deviseService.selectAll();
		if (devises == null) {
			devises = new ArrayList<Devise>();
		}
		model.addAttribute("devises", devises);
		return "pages/devise/devisePage";
		
	}
	
	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		Devise devise = new Devise();
		model.addAttribute("devise", devise);
		
		return "pages/devise/addUpDevise";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, Devise devise) {
		
		if(devise != null) {
			if (devise.getId() != null) {
				deviseService.update(devise);
			} else {
				deviseService.save(devise);
				devise.setCode("DV"+String.valueOf(devise.getId()));
				deviseService.update(devise);
			}
		}
		
		return "redirect:/devise";
		
	}
	
	@RequestMapping(value = "/modifier/{idDevise}")
	public String modifier(Model model, @PathVariable Integer idDevise) {
		if (idDevise != null) {
			Devise devise = deviseService.getById(idDevise);
			if (devise != null) {
				model.addAttribute("devise", devise);
			}
		}
		return "pages/devise/addUpDevise";
	}
	
	@RequestMapping(value = "/supprimer/{idDevise}")
	public String supprimer(Model model, @PathVariable Integer idDevise) {
		if (idDevise != null) {
			Devise devise = deviseService.getById(idDevise);
			if (devise != null) {
				deviseService.remove(idDevise);
			}
		}
		return "redirect:/devise";
	}

}
