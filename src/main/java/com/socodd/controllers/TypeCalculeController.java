package com.socodd.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socodd.entities.TypeCalcule;
import com.socodd.services.ITypeCalculeService;


@Controller
@RequestMapping(value = "/u/typeCalcule")
public class TypeCalculeController {

	@Autowired
	private ITypeCalculeService typeCalculeService;
	
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<TypeCalcule> typeCalcules = typeCalculeService.selectAll();
		if (typeCalcules == null) {
			typeCalcules = new ArrayList<TypeCalcule>();
		}
		model.addAttribute("typeCalcules", typeCalcules);
		return "pages/typeCalcule/typeCalculePage";
		
	}
	
	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		TypeCalcule typeCalcule = new TypeCalcule();
		model.addAttribute("typeCalcule", typeCalcule);
		
		return "pages/typeCalcule/addUpTypeCalcule";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, TypeCalcule typeCalcule) {
		
		if(typeCalcule != null) {
			if (typeCalcule.getId() != null) {
				typeCalculeService.update(typeCalcule);
			} else {
				typeCalculeService.save(typeCalcule);
				typeCalcule.setCode("D"+String.valueOf(typeCalcule.getId()));
				typeCalculeService.update(typeCalcule);
			}
		}
		
		return "redirect:/typeCalcule";
		
	}
	
	@RequestMapping(value = "/modifier/{idTypeCalcule}")
	public String modifier(Model model, @PathVariable Integer idTypeCalcule) {
		if (idTypeCalcule != null) {
			TypeCalcule typeCalcule = typeCalculeService.getById(idTypeCalcule);
			if (typeCalcule != null) {
				model.addAttribute("typeCalcule", typeCalcule);
			}
		}
		return "pages/typeCalcule/addUpTypeCalcule";
	}
	
	@RequestMapping(value = "/supprimer/{idTypeCalcule}")
	public String supprimer(Model model, @PathVariable Integer idTypeCalcule) {
		if (idTypeCalcule != null) {
			TypeCalcule typeCalcule = typeCalculeService.getById(idTypeCalcule);
			if (typeCalcule != null) {
				typeCalculeService.remove(idTypeCalcule);
			}
		}
		return "redirect:/typeCalcule";
	}

}
