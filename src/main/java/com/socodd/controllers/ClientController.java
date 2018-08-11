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

import com.socodd.entities.Client;
import com.socodd.services.ITypeClientService;
import com.socodd.utils.FormatingDate;
import com.socodd.services.IClientService;


@Controller
@RequestMapping(value = "/client")
public class ClientController {

	@Autowired
	private IClientService clientService;
	
	@Autowired
	private ITypeClientService typeClientService;
	
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<Client> clients = clientService.selectAll();
		if (clients == null) {
			clients = new ArrayList<Client>();
		}
		
		
		for(int i=0 ; i<clients.size(); i++) {
			
			clients.get(i).setTypeClient(typeClientService.getById(clients.get(i).getTypeClient().getId()));
			
		}
		
		
		model.addAttribute("clients", clients);
		return "pages/client/clientPage";
		
	}

	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		Client client = new Client();
		
		model.addAttribute("typeClients", typeClientService.selectAll());
		model.addAttribute("client", client);
		
		model.addAttribute("ttt", "nouveau");
		
		return "pages/client/addUpClient";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, Client client, HttpServletRequest request) {
		
		
		
		int t_client_id = Integer.parseInt(request.getParameter("t_client_id"));
		Date dateEntree = FormatingDate.stringToDate(request.getParameter("date_entree"), "yyyy-MM-dd");
		String import_bic = request.getParameter("import_bic");	
		
		
		if(client != null) {
			
			client.setTypeClient(typeClientService.getById(t_client_id));
			client.setDateEntree(dateEntree);
			client.setNumBic(import_bic);
			
			if (client.getId() != null) {
				clientService.update(client);
			} else {
				
				clientService.save(client);
				client.setCode("CL"+String.valueOf(client.getId()));
				clientService.update(client);
			}
		}
		
		return "redirect:/client";
		
	}
	
	@RequestMapping(value = "/modifier/{idClient}")
	public String modifier(Model model, @PathVariable Integer idClient) {
		if (idClient != null) {
			Client client = clientService.getById(idClient);
			if (client != null) {
			
				
				model.addAttribute("typeClients", typeClientService.selectAll());
				
				
				
				client.setTypeClient(typeClientService.getById(client.getTypeClient().getId()));
				
				
				model.addAttribute("ttt", "modifier");
				
				model.addAttribute("client", client);
			}
		}
		return "pages/client/addUpClient";
	}
	
	@RequestMapping(value = "/supprimer/{idClient}")
	public String supprimer(Model model, @PathVariable Integer idClient) {
		if (idClient != null) {
			Client client = clientService.getById(idClient);
			if (client != null) {
				clientService.remove(idClient);
			}
		}
		return "redirect:/client";
	}

}
