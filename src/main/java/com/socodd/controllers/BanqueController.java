package com.socodd.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socodd.entities.Banque;
import com.socodd.services.IBanqueService;


@Controller
@RequestMapping(value = "/u/banque")
public class BanqueController {

	@Autowired
	private IBanqueService banqueService;
	
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<Banque> banques = banqueService.selectAll();
		if (banques == null) {
			banques = new ArrayList<Banque>();
		}
		model.addAttribute("banques", banques);
		return "pages/banque/banquePage";
		
	}
	
	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		Banque banque = new Banque();
		model.addAttribute("banque", banque);
		
		return "pages/banque/addUpBanque";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, Banque banque) {
		
		if(banque != null) {
			if (banque.getId() != null) {
				banqueService.update(banque);
			} else {
				banqueService.save(banque);
				banque.setCode("BK"+String.valueOf(banque.getId()));
				banqueService.update(banque);
			}
		}
		
		return "redirect:/banque";
		
	}
	
	@RequestMapping(value = "/modifier/{idBanque}")
	public String modifier(Model model, @PathVariable Integer idBanque) {
		if (idBanque != null) {
			Banque banque = banqueService.getById(idBanque);
			if (banque != null) {
				model.addAttribute("banque", banque);
			}
		}
		return "pages/banque/addUpBanque";
	}
	
	@RequestMapping(value = "/supprimer/{idBanque}")
	public String supprimer(Model model, @PathVariable Integer idBanque) {
		if (idBanque != null) {
			Banque banque = banqueService.getById(idBanque);
			if (banque != null) {
				banqueService.remove(idBanque);
			}
		}
		return "redirect:/banque";
	}

}
