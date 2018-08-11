package com.socodd.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socodd.entities.Equipe;
import com.socodd.services.IEmployeeService;
import com.socodd.services.IEquipeService;


@Controller
@RequestMapping(value = "/equipe")
public class EquipeController {

	@Autowired
	private IEquipeService equipeService;
	
	@Autowired
	private IEmployeeService localiteService;
	
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<Equipe> equipes = equipeService.selectAll();
		if (equipes == null) {
			equipes = new ArrayList<Equipe>();
		}
		
		
		for(int i=0 ; i<equipes.size(); i++) {
			
			equipes.get(i).setEmployee(localiteService.getById(equipes.get(i).getEmployee().getId()));
			
		}
		
		
		model.addAttribute("equipes", equipes);
		return "pages/equipe/equipePage";
		
	}

	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		Equipe equipe = new Equipe();
		
		model.addAttribute("localites", localiteService.selectAll());
		model.addAttribute("equipe", equipe);
		
		model.addAttribute("ttt", "nouveau");
		
		return "pages/equipe/addUpEquipe";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, Equipe equipe, HttpServletRequest request) {
		
		
		
		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		
		
		if(equipe != null) {
			
			equipe.setEmployee(localiteService.getById(emp_id));
			
			if (equipe.getId() != null) {
				equipeService.update(equipe);
			} else {
				
				equipeService.save(equipe);
				equipe.setCode("EQ"+String.valueOf(equipe.getId()));
				equipeService.update(equipe);
			}
		}
		
		return "redirect:/equipe";
		
	}
	
	@RequestMapping(value = "/modifier/{idEquipe}")
	public String modifier(Model model, @PathVariable Integer idEquipe) {
		if (idEquipe != null) {
			Equipe equipe = equipeService.getById(idEquipe);
			if (equipe != null) {
			
				
				model.addAttribute("localites", localiteService.selectAll());
				
				
				
				equipe.setEmployee(localiteService.getById(equipe.getEmployee().getId()));
				
				
				model.addAttribute("ttt", "modifier");
				
				model.addAttribute("equipe", equipe);
			}
		}
		return "pages/equipe/addUpEquipe";
	}
	
	@RequestMapping(value = "/supprimer/{idEquipe}")
	public String supprimer(Model model, @PathVariable Integer idEquipe) {
		if (idEquipe != null) {
			Equipe equipe = equipeService.getById(idEquipe);
			if (equipe != null) {
				equipeService.remove(idEquipe);
			}
		}
		return "redirect:/equipe";
	}

}
