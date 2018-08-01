package com.socodd.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socodd.entities.Produit;
import com.socodd.entities.Variete;
import com.socodd.services.IProduitService;
import com.socodd.services.IVarieteService;


@Controller
@RequestMapping(value = "/variete")
public class VarieteController {

	@Autowired
	private IVarieteService varieteService;
	
	@Autowired
	private IProduitService produitService;
	
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<Variete> varietes = varieteService.selectAll();
		if (varietes == null) {
			varietes = new ArrayList<Variete>();
		}
		
		
		for(int i=0 ; i<varietes.size(); i++) {
			
			varietes.get(i).setProduit(produitService.getById(varietes.get(i).getProduit().getId()));
			
		}
		
		
		model.addAttribute("varietes", varietes);
		return "pages/variete/varietePage";
		
	}

	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		Variete variete = new Variete();
		List<Produit> produits = produitService.selectAll();
		
		model.addAttribute("produits", produits);
		model.addAttribute("variete", variete);
		
		model.addAttribute("ttt", "nouveau");
		
		return "pages/variete/addUpVariete";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, Variete variete, HttpServletRequest request) {
		
		
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		System.out.println(pid);
		
		
		if(variete != null) {
			
			variete.setProduit(produitService.getById(pid));
			
			if (variete.getId() != null) {
				varieteService.update(variete);
			} else {
				
				varieteService.save(variete);
			}
		}
		
		return "redirect:/variete";
		
	}
	
	@RequestMapping(value = "/modifier/{idVariete}")
	public String modifier(Model model, @PathVariable Integer idVariete) {
		if (idVariete != null) {
			Variete variete = varieteService.getById(idVariete);
			if (variete != null) {
				
				
				List<Produit> produits = produitService.selectAll();
				
				model.addAttribute("produits", produits);
				
				
				
				variete.setProduit(produitService.getById(variete.getProduit().getId()));
				
				
				model.addAttribute("ttt", "modifier");
				
				model.addAttribute("variete", variete);
			}
		}
		return "pages/variete/addUpVariete";
	}
	
	@RequestMapping(value = "/supprimer/{idVariete}")
	public String supprimer(Model model, @PathVariable Integer idVariete) {
		if (idVariete != null) {
			Variete variete = varieteService.getById(idVariete);
			if (variete != null) {
				varieteService.remove(idVariete);
			}
		}
		return "redirect:/variete";
	}

}
