package com.socodd.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socodd.entities.Departement;
import com.socodd.services.IDepartementService;


@Controller
@RequestMapping(value = "/u/departement")
public class DepartementController {

	@Autowired
	private IDepartementService departementService;
	
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<Departement> departements = departementService.selectAll();
		if (departements == null) {
			departements = new ArrayList<Departement>();
		}
		model.addAttribute("departements", departements);
		return "pages/departement/departementPage";
		
	}
	
	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		Departement departement = new Departement();
		model.addAttribute("departement", departement);
		
		return "pages/departement/addUpDepartement";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, Departement departement) {
		
		if(departement != null) {
			if (departement.getId() != null) {
				departementService.update(departement);
			} else {
				departementService.save(departement);
				departement.setCode("DP"+String.valueOf(departement.getId()));
				departementService.update(departement);
			}
		}
		
		return "redirect:/departement";
		
	}
	
	@RequestMapping(value = "/modifier/{idDepartement}")
	public String modifier(Model model, @PathVariable Integer idDepartement) {
		if (idDepartement != null) {
			Departement departement = departementService.getById(idDepartement);
			if (departement != null) {
				model.addAttribute("departement", departement);
			}
		}
		return "pages/departement/addUpDepartement";
	}
	
	@RequestMapping(value = "/supprimer/{idDepartement}")
	public String supprimer(Model model, @PathVariable Integer idDepartement) {
		if (idDepartement != null) {
			Departement departement = departementService.getById(idDepartement);
			if (departement != null) {
				departementService.remove(idDepartement);
			}
		}
		return "redirect:/departement";
	}

}
