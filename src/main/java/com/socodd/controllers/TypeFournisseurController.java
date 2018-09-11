package com.socodd.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socodd.entities.TypeFournisseur;
import com.socodd.services.ITypeFournisseurService;


@Controller
@RequestMapping(value = "/u/typeFournisseur")
public class TypeFournisseurController {

	@Autowired
	private ITypeFournisseurService typeFournisseurService;
	
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<TypeFournisseur> typeFournisseurs = typeFournisseurService.selectAll();
		if (typeFournisseurs == null) {
			typeFournisseurs = new ArrayList<TypeFournisseur>();
		}
		model.addAttribute("typeFournisseurs", typeFournisseurs);
		return "pages/typeFournisseur/typeFournisseurPage";
		
	}
	
	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		TypeFournisseur typeFournisseur = new TypeFournisseur();
		model.addAttribute("typeFournisseur", typeFournisseur);
		
		return "pages/typeFournisseur/addUpTypeFournisseur";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, TypeFournisseur typeFournisseur) {
		
		if(typeFournisseur != null) {
			if (typeFournisseur.getId() != null) {
				typeFournisseurService.update(typeFournisseur);
			} else {
				typeFournisseurService.save(typeFournisseur);
				typeFournisseur.setCode("TF"+String.valueOf(typeFournisseur.getId()));
				typeFournisseurService.update(typeFournisseur);
			}
		}
		
		return "redirect:/typeFournisseur";
		
	}
	
	@RequestMapping(value = "/modifier/{idTypeFournisseur}")
	public String modifier(Model model, @PathVariable Integer idTypeFournisseur) {
		if (idTypeFournisseur != null) {
			TypeFournisseur typeFournisseur = typeFournisseurService.getById(idTypeFournisseur);
			if (typeFournisseur != null) {
				model.addAttribute("typeFournisseur", typeFournisseur);
			}
		}
		return "pages/typeFournisseur/addUpTypeFournisseur";
	}
	
	@RequestMapping(value = "/supprimer/{idTypeFournisseur}")
	public String supprimer(Model model, @PathVariable Integer idTypeFournisseur) {
		if (idTypeFournisseur != null) {
			TypeFournisseur typeFournisseur = typeFournisseurService.getById(idTypeFournisseur);
			if (typeFournisseur != null) {
				typeFournisseurService.remove(idTypeFournisseur);
			}
		}
		return "redirect:/typeFournisseur";
	}

}
