package com.socodd.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socodd.entities.Port;
import com.socodd.services.IPortService;


@Controller
@RequestMapping(value = "/u/port")
public class PortController {

	@Autowired
	private IPortService portService;
	
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<Port> ports = portService.selectAll();
		if (ports == null) {
			ports = new ArrayList<Port>();
		}
		model.addAttribute("ports", ports);
		return "pages/port/portPage";
		
	}
	
	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		Port port = new Port();
		model.addAttribute("port", port);
		
		return "pages/port/addUpPort";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, Port port) {
		
		if(port != null) {
			if (port.getId() != null) {
				portService.update(port);
			} else {
				portService.save(port);
				port.setCode("PO"+String.valueOf(port.getId()));
				portService.update(port);
			}
		}
		
		return "redirect:/port";
		
	}
	
	@RequestMapping(value = "/modifier/{idPort}")
	public String modifier(Model model, @PathVariable Integer idPort) {
		if (idPort != null) {
			Port port = portService.getById(idPort);
			if (port != null) {
				model.addAttribute("port", port);
			}
		}
		return "pages/port/addUpPort";
	}
	
	@RequestMapping(value = "/supprimer/{idPort}")
	public String supprimer(Model model, @PathVariable Integer idPort) {
		if (idPort != null) {
			Port port = portService.getById(idPort);
			if (port != null) {
				portService.remove(idPort);
			}
		}
		return "redirect:/port";
	}

}
