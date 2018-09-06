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

import com.socodd.entities.ContratVente;
import com.socodd.services.IContratVenteService;
import com.socodd.services.IClientService;
import com.socodd.services.IProduitService;
import com.socodd.services.IDeviseService;
import com.socodd.utils.FormatingDate;


@Controller
@RequestMapping(value = "/contratVente")
public class ContratVenteController {

	@Autowired
	private IContratVenteService contratVenteService;
	
	@Autowired
	private IProduitService produitService;
	
	@Autowired
	private IDeviseService deviseService;
	
	@Autowired
	private IClientService clientService;
	
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<ContratVente> contratVentes = contratVenteService.selectAll();
		if (contratVentes == null) {
			contratVentes = new ArrayList<ContratVente>();
		}
		
		for (int i = 0; i < contratVentes.size(); i++) {
			contratVentes.get(i).setClient(clientService.getById(contratVentes.get(i).getClient().getId()));
			contratVentes.get(i).setProduit(produitService.getById(contratVentes.get(i).getProduit().getId()));
		}
		
		
		model.addAttribute("contratVentes", contratVentes);
		return "pages/contratVente/contratVentePage";
		
	}
	
	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		ContratVente contratVente = new ContratVente();
		model.addAttribute("contratVente", contratVente);

		model.addAttribute("produits", produitService.selectAll());
		model.addAttribute("clients", clientService.selectAll());
		model.addAttribute("devise", deviseService.selectAll());
		
		return "pages/contratVente/addContratVente";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, ContratVente contratVente, HttpServletRequest request) {
		
		int cid = Integer.parseInt(request.getParameter("cid"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		int devid = Integer.parseInt(request.getParameter("devid"));
		String decision = request.getParameter("decision");		
		
		Date dateVente = FormatingDate.stringToDate(request.getParameter("date_vente"), "yyyy-MM-dd");
		
		System.out.println(dateVente);

		
		if(contratVente != null) {
			
			contratVente.setDateVente(dateVente);
			contratVente.setDecision(decision);
			contratVente.setClient(clientService.getById(cid));
			contratVente.setProduit(produitService.getById(pid));
			contratVente.setDevise(deviseService.getById(devid));
			
			
			if (contratVente.getId() != null) {
				contratVenteService.update(contratVente);
			} else {
				contratVenteService.save(contratVente);
				contratVente.setCode("CP"+String.valueOf(contratVente.getId()));
				contratVenteService.update(contratVente);
			}
		}
		
		return "redirect:/contratVente";
		
	}
	
	@RequestMapping(value = "/modifier/{idContratVente}")
	public String modifier(Model model, @PathVariable Integer idContratVente) {
		if (idContratVente != null) {
			ContratVente contratVente = contratVenteService.getById(idContratVente);
			if (contratVente != null) {
				
				
				contratVente.setClient(clientService.getById(contratVente.getClient().getId()));
				contratVente.setProduit(produitService.getById(contratVente.getProduit().getId()));
				contratVente.setDevise(deviseService.getById(contratVente.getDevise().getId()));
				
				
				model.addAttribute("contratVente", contratVente);
				
				
				model.addAttribute("produits", produitService.selectAll());
				model.addAttribute("clients", clientService.selectAll());
				model.addAttribute("devise", deviseService.selectAll());
				
				return "pages/contratVente/upContratVente";
				
			}
		}

		return "redirect:/contratVente";
		
	}
	
	@RequestMapping(value = "/supprimer/{idContratVente}")
	public String supprimer(Model model, @PathVariable Integer idContratVente) {
		if (idContratVente != null) {
			ContratVente contratVente = contratVenteService.getById(idContratVente);
			if (contratVente != null) {
				contratVenteService.remove(idContratVente);
			}
		}
		return "redirect:/contratVente";
	}

}
