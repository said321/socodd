package com.socodd.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socodd.entities.Usine;
import com.socodd.services.IUsineService;
import com.socodd.services.ILocaliteService;


@Controller
@RequestMapping(value = "/u/usine")
public class UsineController {

	@Autowired
	private IUsineService usineService;
	
	@Autowired
	private ILocaliteService localiteService;
	
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<Usine> usines = usineService.selectAll();
		if (usines == null) {
			usines = new ArrayList<Usine>();
		}
		
		
		for(int i=0 ; i<usines.size(); i++) {
			
			usines.get(i).setLocalite(localiteService.getById(usines.get(i).getLocalite().getId()));
			
		}
		
		
		model.addAttribute("usines", usines);
		return "pages/usine/usinePage";
		
	}
	
	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		Usine usine = new Usine();
		
		
		model.addAttribute("localites", localiteService.selectAll());
		model.addAttribute("ttt", "nouveau");
		model.addAttribute("usine", usine);
		
		return "pages/usine/addUpUsine";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, Usine usine, HttpServletRequest request) {
		
		int loc_id = Integer.parseInt(request.getParameter("loc_id"));
		
		if(usine != null) {
			
			usine.setLocalite(localiteService.getById(loc_id));
			
			if (usine.getId() != null) {
				usineService.update(usine);
			} else {
				usineService.save(usine);
				usine.setCode("US"+String.valueOf(usine.getId()));
				usineService.update(usine);
			}
		}
		
		return "redirect:/usine";
		
	}
	
	@RequestMapping(value = "/modifier/{idUsine}")
	public String modifier(Model model, @PathVariable Integer idUsine) {
		if (idUsine != null) {
			Usine usine = usineService.getById(idUsine);
			if (usine != null) {
				
				
				model.addAttribute("localites", localiteService.selectAll());
				
				usine.setLocalite(localiteService.getById(usine.getLocalite().getId()));
				
				
				model.addAttribute("ttt", "modifier");
				
				model.addAttribute("usine", usine);
			}
		}
		return "pages/usine/addUpUsine";
	}
	
	@RequestMapping(value = "/supprimer/{idUsine}")
	public String supprimer(Model model, @PathVariable Integer idUsine) {
		if (idUsine != null) {
			Usine usine = usineService.getById(idUsine);
			if (usine != null) {
				usineService.remove(idUsine);
			}
		}
		return "redirect:/usine";
	}

}
