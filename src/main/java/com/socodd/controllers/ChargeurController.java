package com.socodd.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socodd.entities.Chargeur;
import com.socodd.services.IChargeurService;


@Controller
@RequestMapping(value = "/u/chargeur")
public class ChargeurController {

	@Autowired
	private IChargeurService chargeurService;
	
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<Chargeur> chargeurs = chargeurService.selectAll();
		if (chargeurs == null) {
			chargeurs = new ArrayList<Chargeur>();
		}
		model.addAttribute("chargeurs", chargeurs);
		return "pages/chargeur/chargeurPage";
		
	}
	
	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		Chargeur chargeur = new Chargeur();
		model.addAttribute("chargeur", chargeur);
		
		return "pages/chargeur/addUpChargeur";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, Chargeur chargeur) {
		
		if(chargeur != null) {
			if (chargeur.getId() != null) {
				chargeurService.update(chargeur);
			} else {
				chargeurService.save(chargeur);
				chargeur.setCode("CG"+String.valueOf(chargeur.getId()));
				chargeurService.update(chargeur);
			}
		}
		
		return "redirect:/chargeur";
		
	}
	
	@RequestMapping(value = "/modifier/{idChargeur}")
	public String modifier(Model model, @PathVariable Integer idChargeur) {
		if (idChargeur != null) {
			Chargeur chargeur = chargeurService.getById(idChargeur);
			if (chargeur != null) {
				model.addAttribute("chargeur", chargeur);
			}
		}
		return "pages/chargeur/addUpChargeur";
	}
	
	@RequestMapping(value = "/supprimer/{idChargeur}")
	public String supprimer(Model model, @PathVariable Integer idChargeur) {
		if (idChargeur != null) {
			Chargeur chargeur = chargeurService.getById(idChargeur);
			if (chargeur != null) {
				chargeurService.remove(idChargeur);
			}
		}
		return "redirect:/chargeur";
	}

}
