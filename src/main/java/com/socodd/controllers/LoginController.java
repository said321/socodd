package com.socodd.controllers;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.socodd.entities.ContratAchat;
import com.socodd.services.IContratAchatService;

import com.socodd.entities.Client;
import com.socodd.services.IClientService;

@Controller
public class LoginController {
	
	@Autowired
	private IContratAchatService contratAchatService;
	
	@Autowired
	private IClientService clientService;
	
	@RequestMapping(value = {"/", "/login"})
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		
		if (error != null) {
			model.addAttribute("error", "Invalid Username or Password!");
		}

		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}

		
		return "login/login";
		
	}
	
	@RequestMapping(value = "/home")
	public String home(Model model) throws Exception{
		
		model = getAchatProduiChart(model);
		//model = getClientChart(model);
		
		return "home/home";
		
	}
	
	
	public Model getAchatProduiChart(Model model) throws JsonGenerationException, JsonMappingException, IOException {
		
		int  data_AchatProduit1 = contratAchatService.findCountBy("decision", "attente"); 
		int  data_AchatProduit2 = contratAchatService.findCountBy("decision", "accepte");

		model.addAttribute("data_AchatProduit1", data_AchatProduit1);
		model.addAttribute("data_AchatProduit2", data_AchatProduit2);
		
		return model;
		
	}
	
	public Model getClientChart(Model model) throws JsonGenerationException, JsonMappingException, IOException {
		
		List<Client> clients = clientService.selectAll(); 

		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
		String jsonString = mapper.writeValueAsString(clients);

		model.addAttribute("data_client", jsonString);
		
		return model;
		
	}
	
	@RequestMapping(value = "/admin")
	public String admin() {
		
		return "admin";
		
	}	
	
	
	
	// this part just for test
	

//	
//	@RequestMapping(value = "/chart")
//	public String chart(Model model) throws JsonGenerationException, JsonMappingException, IOException {
//		
//		
//		List<Zone> zones = zoneService.selectAll(); 
////		
////		List<Integer> ids = new ArrayList<Integer>();
////		
////		for (int i = 0; i < zones.size(); i++) {
////			ids.add(zones.get(i).getId());
////		}
////		
//		
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
//		String jsonString = mapper.writeValueAsString(zones);
//
//		model.addAttribute("data", jsonString);
//		
//		model.addAttribute("titre", "Chart Title");
//		
//		return "blank/MyChart";
//		
//	}
//	
//	@RequestMapping(value="/json")
//	public @ResponseBody List<Zone> getZoneInJSON() {
//
////		Zone zone = zoneService.getById(1);
////		Zone zone = new Zone("Z1","ZONE1");
////		zone.setId(1);
//		
//		List<Zone> zones = zoneService.selectAll(); 
////		
////		List<Integer> ids = new ArrayList<Integer>();
////		
////		for (int i = 0; i < zones.size(); i++) {
////			ids.add(zones.get(i).getId());
////		}
////		
//		return zones;
//
//	}
	
	
}
