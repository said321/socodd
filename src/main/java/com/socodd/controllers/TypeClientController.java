package com.socodd.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socodd.entities.TypeClient;
import com.socodd.services.ITypeClientService;


@Controller
@RequestMapping(value = "/typeClient")
public class TypeClientController {

	@Autowired
	private ITypeClientService typeClientService;
	
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<TypeClient> typeClients = typeClientService.selectAll();
		if (typeClients == null) {
			typeClients = new ArrayList<TypeClient>();
		}
		model.addAttribute("typeClients", typeClients);
		return "pages/typeClient/typeClientPage";
		
	}
	
	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		TypeClient typeClient = new TypeClient();
		model.addAttribute("typeClient", typeClient);
		
		return "pages/typeClient/addUpTypeClient";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, TypeClient typeClient) {
		
		if(typeClient != null) {
			if (typeClient.getId() != null) {
				typeClientService.update(typeClient);
			} else {
				typeClientService.save(typeClient);
				typeClient.setCode("TCL"+String.valueOf(typeClient.getId()));
				typeClientService.update(typeClient);
			}
		}
		
		return "redirect:/typeClient";
		
	}
	
	@RequestMapping(value = "/modifier/{idTypeClient}")
	public String modifier(Model model, @PathVariable Integer idTypeClient) {
		if (idTypeClient != null) {
			TypeClient typeClient = typeClientService.getById(idTypeClient);
			if (typeClient != null) {
				model.addAttribute("typeClient", typeClient);
			}
		}
		return "pages/typeClient/addUpTypeClient";
	}
	
	@RequestMapping(value = "/supprimer/{idTypeClient}")
	public String supprimer(Model model, @PathVariable Integer idTypeClient) {
		if (idTypeClient != null) {
			TypeClient typeClient = typeClientService.getById(idTypeClient);
			if (typeClient != null) {
				typeClientService.remove(idTypeClient);
			}
		}
		return "redirect:/typeClient";
	}

}
