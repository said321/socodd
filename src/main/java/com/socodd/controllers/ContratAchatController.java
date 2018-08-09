package com.socodd.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socodd.entities.ContratAchat;
import com.socodd.services.IContratAchatService;
import com.socodd.services.IFournisseurService;
import com.socodd.services.IProduitService;
import com.socodd.services.IUniteMesureService;
import com.socodd.utils.FormatingDate;


@Controller
@RequestMapping(value = "/contratAchat")
public class ContratAchatController {

	@Autowired
	private IContratAchatService contratAchatService;
	
	@Autowired
	private IProduitService produitService;
	
	@Autowired
	private IUniteMesureService uniteMesureService;
	
	@Autowired
	private IFournisseurService fournisseurService;
	
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<ContratAchat> contratAchats = contratAchatService.selectAll();
		if (contratAchats == null) {
			contratAchats = new ArrayList<ContratAchat>();
		}
		
		for (int i = 0; i < contratAchats.size(); i++) {
			contratAchats.get(i).setFournisseur(fournisseurService.getById(contratAchats.get(i).getFournisseur().getId()));
			contratAchats.get(i).setProduit(produitService.getById(contratAchats.get(i).getProduit().getId()));
		}
		
		
		model.addAttribute("contratAchats", contratAchats);
		return "pages/contratAchat/contratAchatPage";
		
	}
	
	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		ContratAchat contratAchat = new ContratAchat();
		model.addAttribute("contratAchat", contratAchat);

		model.addAttribute("produits", produitService.selectAll());
		model.addAttribute("fournisseurs", fournisseurService.selectAll());
		model.addAttribute("uniteMesure", uniteMesureService.selectAll());
		
		model.addAttribute("ttt","nouveau");
		
		return "pages/contratAchat/addUpContratAchat";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, ContratAchat contratAchat, HttpServletRequest request) {
		
		int fid = Integer.parseInt(request.getParameter("fid"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		int umid = Integer.parseInt(request.getParameter("umid"));
		String decision = request.getParameter("decision");		
		
		Date dateAchat = FormatingDate.stringToDate(request.getParameter("date_achat"), "yyyy-MM-dd");
		Date au_date = FormatingDate.stringToDate(request.getParameter("au_Date"), "yyyy-MM-dd");
		Date du_date = FormatingDate.stringToDate(request.getParameter("du_Date"), "yyyy-MM-dd");
		
		System.out.println(dateAchat);

		
		if(contratAchat != null) {
			
			contratAchat.setDateAchat(dateAchat);
			contratAchat.setAuDate(au_date);
			contratAchat.setDuDate(du_date);
			contratAchat.setDecision(decision);
			contratAchat.setFournisseur(fournisseurService.getById(fid));
			contratAchat.setProduit(produitService.getById(pid));
			contratAchat.setUniteMesure(uniteMesureService.getById(umid));
			
			
			if (contratAchat.getId() != null) {
				contratAchatService.update(contratAchat);
			} else {
				contratAchatService.save(contratAchat);
				contratAchat.setCode("CP"+String.valueOf(contratAchat.getId()));
				contratAchatService.update(contratAchat);
			}
		}
		
		return "redirect:/contratAchat";
		
	}
	
	@RequestMapping(value = "/modifier/{idContratAchat}")
	public String modifier(Model model, @PathVariable Integer idContratAchat) {
		if (idContratAchat != null) {
			ContratAchat contratAchat = contratAchatService.getById(idContratAchat);
			if (contratAchat != null) {
				
				
				contratAchat.setFournisseur(fournisseurService.getById(contratAchat.getFournisseur().getId()));
				contratAchat.setProduit(produitService.getById(contratAchat.getProduit().getId()));
				contratAchat.setUniteMesure(uniteMesureService.getById(contratAchat.getUniteMesure().getId()));
				
				
				model.addAttribute("contratAchat", contratAchat);
				
				
				model.addAttribute("produits", produitService.selectAll());
				model.addAttribute("fournisseurs", fournisseurService.selectAll());
				model.addAttribute("uniteMesure", uniteMesureService.selectAll());
			
				model.addAttribute("ttt", "modifier");
				
				return "pages/contratAchat/addUpContratAchat";
				
			}
		}

		return "redirect:/contratAchat";
		
	}
	
	@RequestMapping(value = "/supprimer/{idContratAchat}")
	public String supprimer(Model model, @PathVariable Integer idContratAchat) {
		if (idContratAchat != null) {
			ContratAchat contratAchat = contratAchatService.getById(idContratAchat);
			if (contratAchat != null) {
				contratAchatService.remove(idContratAchat);
			}
		}
		return "redirect:/contratAchat";
	}

}
