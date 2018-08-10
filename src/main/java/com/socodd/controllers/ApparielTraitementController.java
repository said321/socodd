package com.socodd.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socodd.entities.ApparielTraitement;
import com.socodd.services.IApparielTraitementService;


@Controller
@RequestMapping(value = "/apparielTraitement")
public class ApparielTraitementController {

	@Autowired
	private IApparielTraitementService apparielTraitementService;
	
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<ApparielTraitement> apparielTraitements = apparielTraitementService.selectAll();
		if (apparielTraitements == null) {
			apparielTraitements = new ArrayList<ApparielTraitement>();
		}
		model.addAttribute("apparielTraitements", apparielTraitements);
		return "pages/apparielTraitement/apparielTraitementPage";
		
	}
	
	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		ApparielTraitement apparielTraitement = new ApparielTraitement();
		model.addAttribute("apparielTraitement", apparielTraitement);
		
		return "pages/apparielTraitement/addUpApparielTraitement";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, ApparielTraitement apparielTraitement) {
		
		if(apparielTraitement != null) {
			if (apparielTraitement.getId() != null) {
				apparielTraitementService.update(apparielTraitement);
			} else {
				apparielTraitementService.save(apparielTraitement);
				apparielTraitement.setCode("AP"+String.valueOf(apparielTraitement.getId()));
				apparielTraitementService.update(apparielTraitement);
			}
		}
		
		return "redirect:/apparielTraitement";
		
	}
	
	@RequestMapping(value = "/modifier/{idApparielTraitement}")
	public String modifier(Model model, @PathVariable Integer idApparielTraitement) {
		if (idApparielTraitement != null) {
			ApparielTraitement apparielTraitement = apparielTraitementService.getById(idApparielTraitement);
			if (apparielTraitement != null) {
				model.addAttribute("apparielTraitement", apparielTraitement);
			}
		}
		return "pages/apparielTraitement/addUpApparielTraitement";
	}
	
	@RequestMapping(value = "/supprimer/{idApparielTraitement}")
	public String supprimer(Model model, @PathVariable Integer idApparielTraitement) {
		if (idApparielTraitement != null) {
			ApparielTraitement apparielTraitement = apparielTraitementService.getById(idApparielTraitement);
			if (apparielTraitement != null) {
				apparielTraitementService.remove(idApparielTraitement);
			}
		}
		return "redirect:/apparielTraitement";
	}

}
