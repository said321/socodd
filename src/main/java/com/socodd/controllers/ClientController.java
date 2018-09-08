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
import com.socodd.services.IBanqueService;
import com.socodd.services.IClientService;


@Controller
@RequestMapping(value = "/client")
public class ClientController {

	@Autowired
	private IClientService clientService;
	
	@Autowired
	private ITypeClientService typeClientService;
	
	@Autowired
	private IBanqueService banqueService;
	
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<Client> clients = clientService.selectAll();
		if (clients == null) {
			clients = new ArrayList<Client>();
		}
		
		
		for(int i=0 ; i<clients.size(); i++) {
			
			clients.get(i).setTypeClient(typeClientService.getById(clients.get(i).getTypeClient().getId()));
			clients.get(i).setBanque(banqueService.getById(clients.get(i).getBanque().getId()));
			
		}
		
		
		model.addAttribute("clients", clients);
		return "pages/client/clientPage";
		
	}

	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		Client client = new Client();
		
		model.addAttribute("typeClients", typeClientService.selectAll());
		model.addAttribute("client", client);
		model.addAttribute("banques", banqueService.selectAll());
		
		return "pages/client/addClient";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, Client client, HttpServletRequest request) {
		
		
		
		int t_client_id = Integer.parseInt(request.getParameter("t_client_id"));
		Date dateEntree = FormatingDate.stringToDate(request.getParameter("date_entree"), "yyyy-MM-dd");
		String import_bic = request.getParameter("import_bic");	
		int banque_id = Integer.parseInt(request.getParameter("banque_id"));
		
		
		if(client != null) {
			
			client.setTypeClient(typeClientService.getById(t_client_id));
			client.setDateEntree(dateEntree);
			client.setNumBic(import_bic);
			client.setBanque(banqueService.getById(banque_id));
			
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
				client.setBanque(banqueService.getById(client.getBanque().getId()));
				
				model.addAttribute("banques", banqueService.selectAll());
				
				
				model.addAttribute("client", client);
			}
		}
		return "pages/client/upClient";
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
