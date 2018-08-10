package com.socodd.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socodd.entities.Localite;
import com.socodd.services.ILocaliteService;
import com.socodd.services.ISousPrefectureService;


@Controller
@RequestMapping(value = "/localite")
public class LocaliteController {

	@Autowired
	private ILocaliteService localiteService;
	
	@Autowired
	private ISousPrefectureService sousPrefectureService;
	
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<Localite> localites = localiteService.selectAll();
		if (localites == null) {
			localites = new ArrayList<Localite>();
		}
		
		
		for(int i=0 ; i<localites.size(); i++) {
			
			localites.get(i).setSousPrefecture(sousPrefectureService.getById(localites.get(i).getSousPrefecture().getId()));
			
		}
		
		
		model.addAttribute("localites", localites);
		return "pages/localite/localitePage";
		
	}
	
	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		Localite localite = new Localite();
		
		
		model.addAttribute("sousPrefectures", sousPrefectureService.selectAll());
		model.addAttribute("ttt", "nouveau");
		model.addAttribute("localite", localite);
		
		return "pages/localite/addUpLocalite";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, Localite localite, HttpServletRequest request) {
		
		int reg_id = Integer.parseInt(request.getParameter("reg_id"));
		
		if(localite != null) {
			
			localite.setSousPrefecture(sousPrefectureService.getById(reg_id));
			
			if (localite.getId() != null) {
				localiteService.update(localite);
			} else {
				localiteService.save(localite);
				localite.setCode("LC"+String.valueOf(localite.getId()));
				localiteService.update(localite);
			}
		}
		
		return "redirect:/localite";
		
	}
	
	@RequestMapping(value = "/modifier/{idLocalite}")
	public String modifier(Model model, @PathVariable Integer idLocalite) {
		if (idLocalite != null) {
			Localite localite = localiteService.getById(idLocalite);
			if (localite != null) {
				
				
				model.addAttribute("sousPrefectures", sousPrefectureService.selectAll());
				
				localite.setSousPrefecture(sousPrefectureService.getById(localite.getSousPrefecture().getId()));
				
				
				model.addAttribute("ttt", "modifier");
				
				model.addAttribute("localite", localite);
			}
		}
		return "pages/localite/addUpLocalite";
	}
	
	@RequestMapping(value = "/supprimer/{idLocalite}")
	public String supprimer(Model model, @PathVariable Integer idLocalite) {
		if (idLocalite != null) {
			Localite localite = localiteService.getById(idLocalite);
			if (localite != null) {
				localiteService.remove(idLocalite);
			}
		}
		return "redirect:/localite";
	}

}
