package com.socodd.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socodd.entities.Fournisseur;
import com.socodd.services.ITypeFournisseurService;
import com.socodd.utils.FormatingDate;
import com.socodd.services.IBanqueService;
import com.socodd.services.IFournisseurService;


@Controller
@RequestMapping(value = "/u/fournisseur")
public class FournisseurController {

	@Autowired
	private IFournisseurService fournisseurService;
	
	@Autowired
	private ITypeFournisseurService typeFournisseurService;
	
	@Autowired
	private IBanqueService banqueService;
	
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<Fournisseur> fournisseurs = fournisseurService.selectAll();
		if (fournisseurs == null) {
			fournisseurs = new ArrayList<Fournisseur>();
		}
		
		
		for(int i=0 ; i<fournisseurs.size(); i++) {
			
			fournisseurs.get(i).setTypeFournisseur(typeFournisseurService.getById(fournisseurs.get(i).getTypeFournisseur().getId()));
			fournisseurs.get(i).setBanque(banqueService.getById(fournisseurs.get(i).getBanque().getId()));
			
		}
		
		
		model.addAttribute("fournisseurs", fournisseurs);
		return "pages/fournisseur/fournisseurPage";
		
	}

	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		Fournisseur fournisseur = new Fournisseur();
		
		model.addAttribute("typeFournisseurs", typeFournisseurService.selectAll());
		model.addAttribute("banques", banqueService.selectAll());
		model.addAttribute("fournisseur", fournisseur);
		
		return "pages/fournisseur/addFournisseur";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, Fournisseur fournisseur, HttpServletRequest request) {
		
		
		
		int t_four_id = Integer.parseInt(request.getParameter("t_four_id"));
		int banque_id = Integer.parseInt(request.getParameter("banque_id"));
		Date dateEntree = FormatingDate.stringToDate(request.getParameter("date_entree"), "yyyy-MM-dd");
		String import_bic = request.getParameter("import_bic");	
		
		
		if(fournisseur != null) {
			
			fournisseur.setTypeFournisseur(typeFournisseurService.getById(t_four_id));
			fournisseur.setDateEntree(dateEntree);
			fournisseur.setNumBic(import_bic);
			fournisseur.setBanque(banqueService.getById(banque_id));
			
			if (fournisseur.getId() != null) {
				fournisseurService.update(fournisseur);
			} else {
				
				fournisseurService.save(fournisseur);
				fournisseur.setCode("FR"+String.valueOf(fournisseur.getId()));
				fournisseurService.update(fournisseur);
			}
		}
		
		return "redirect:/fournisseur";
		
	}
	
	@RequestMapping(value = "/modifier/{idFournisseur}")
	public String modifier(Model model, @PathVariable Integer idFournisseur) {
		if (idFournisseur != null) {
			Fournisseur fournisseur = fournisseurService.getById(idFournisseur);
			if (fournisseur != null) {
			
				
				model.addAttribute("typeFournisseurs", typeFournisseurService.selectAll());

				fournisseur.setTypeFournisseur(typeFournisseurService.getById(fournisseur.getTypeFournisseur().getId()));
				fournisseur.setBanque(banqueService.getById(fournisseur.getBanque().getId()));
				
				model.addAttribute("banques", banqueService.selectAll());
				
				model.addAttribute("fournisseur", fournisseur);
			}
		}
		return "pages/fournisseur/upFournisseur";
	}
	
	@RequestMapping(value = "/supprimer/{idFournisseur}")
	public String supprimer(Model model, @PathVariable Integer idFournisseur) {
		if (idFournisseur != null) {
			Fournisseur fournisseur = fournisseurService.getById(idFournisseur);
			if (fournisseur != null) {
				fournisseurService.remove(idFournisseur);
			}
		}
		return "redirect:/fournisseur";
	}

}
