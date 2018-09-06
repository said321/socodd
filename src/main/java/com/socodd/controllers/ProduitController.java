package com.socodd.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socodd.entities.Produit;
import com.socodd.services.IProduitService;
import com.socodd.services.ITypeSacService;
import com.socodd.entities.TypeSac;


@Controller
@RequestMapping(value = "/produit")
public class ProduitController {

	@Autowired
	private IProduitService produitService;
	@Autowired
	private ITypeSacService typeSacService;
	
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<Produit> produits = produitService.selectAll();
		if (produits == null) {
			produits = new ArrayList<Produit>();
		}
		
		
		for (int i = 0; i < produits.size(); i++) {
			
			produits.get(i).setTypeSacBySacBrousse(typeSacService.getById(produits.get(i).getTypeSacBySacBrousse().getId()));
			produits.get(i).setTypeSacBySacExport(typeSacService.getById(produits.get(i).getTypeSacBySacExport().getId()));
			
		}
		
		
		model.addAttribute("produits", produits);
		
		return "pages/produit/produitPage";
		
	}
	
	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		Produit produit = new Produit();
		model.addAttribute("produit", produit);
		
		List<TypeSac> typeSac  = typeSacService.selectAll();
		
		model.addAttribute("typeSac", typeSac);
		
		return "pages/produit/addProduit";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, Produit produit, HttpServletRequest request) {
		
		int sac_br = Integer.parseInt(request.getParameter("sac_br"));
		int sac_ex = Integer.parseInt(request.getParameter("sac_ex"));
		
		produit.setTypeSacBySacBrousse(typeSacService.getById(sac_br));
		produit.setTypeSacBySacExport(typeSacService.getById(sac_ex));
		
		
		if(produit != null) {
			if (produit.getId() != null) {
				produitService.update(produit);
			} else {
				produitService.save(produit);
				produit.setCode("PR"+String.valueOf(produit.getId()));
				produitService.update(produit);
			}
		}
		
		return "redirect:/produit";
		
	}
	
	@RequestMapping(value = "/modifier/{idProduit}")
	public String modifier(Model model, @PathVariable Integer idProduit) {
		if (idProduit != null) {
			Produit produit = produitService.getById(idProduit);
			if (produit != null) {
				
				
				produit.setTypeSacBySacBrousse(typeSacService.getById(produit.getTypeSacBySacBrousse().getId()));
				produit.setTypeSacBySacExport(typeSacService.getById(produit.getTypeSacBySacExport().getId()));
				
				List<TypeSac> typeSac  = typeSacService.selectAll();
				
				model.addAttribute("typeSac", typeSac);
				model.addAttribute("produit", produit);
			}
		}
		return "pages/produit/upProduit";
	}
	
	@RequestMapping(value = "/supprimer/{idProduit}")
	public String supprimer(Model model, @PathVariable Integer idProduit) {
		if (idProduit != null) {
			Produit produit = produitService.getById(idProduit);
			if (produit != null) {
				produitService.remove(idProduit);
			}
		}
		return "redirect:/produit";
	}

}
