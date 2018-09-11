package com.socodd.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socodd.entities.UniteMesure;
import com.socodd.services.IUniteMesureService;


@Controller
@RequestMapping(value = "/u/unite_mesure")
public class UniteMesureController {

	@Autowired
	private IUniteMesureService unite_mesureService;
	
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<UniteMesure> unite_mesures = unite_mesureService.selectAll();
		if (unite_mesures == null) {
			unite_mesures = new ArrayList<UniteMesure>();
		}
		model.addAttribute("unite_mesures", unite_mesures);
		return "pages/unite_mesure/unite_mesurePage";
		
	}
	
	@RequestMapping(value = "/modifier")
	public String modifier(Model model) {
		
		return "pages/unite_mesure/addUpUniteMesure";
		
	}

	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		UniteMesure unite_mesure = new UniteMesure();
		model.addAttribute("unite_mesure", unite_mesure);
		
		return "pages/unite_mesure/addUpUniteMesure";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, UniteMesure unite_mesure) {
		
		if(unite_mesure != null) {
			if (unite_mesure.getId() != null) {
				unite_mesureService.update(unite_mesure);
			} else {
				unite_mesureService.save(unite_mesure);
				unite_mesure.setCode("UM"+String.valueOf(unite_mesure.getId()));
				unite_mesureService.update(unite_mesure);
			}
		}
		
		return "redirect:/unite_mesure";
		
	}
	
	@RequestMapping(value = "/modifier/{idUniteMesure}")
	public String modifier(Model model, @PathVariable Integer idUniteMesure) {
		if (idUniteMesure != null) {
			UniteMesure unite_mesure = unite_mesureService.getById(idUniteMesure);
			if (unite_mesure != null) {
				model.addAttribute("unite_mesure", unite_mesure);
			}
		}
		return "pages/unite_mesure/addUpUniteMesure";
	}
	
	@RequestMapping(value = "/supprimer/{idUniteMesure}")
	public String supprimer(Model model, @PathVariable Integer idUniteMesure) {
		if (idUniteMesure != null) {
			UniteMesure unite_mesure = unite_mesureService.getById(idUniteMesure);
			if (unite_mesure != null) {
				unite_mesureService.remove(idUniteMesure);
			}
		}
		return "redirect:/unite_mesure";
	}

}
