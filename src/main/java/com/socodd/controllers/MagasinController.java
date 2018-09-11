package com.socodd.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socodd.entities.Magasin;
import com.socodd.services.ILocaliteService;
import com.socodd.services.IMagasinService;


@Controller
@RequestMapping(value = "/u/magasin")
public class MagasinController {

	@Autowired
	private IMagasinService magasinService;
	
	@Autowired
	private ILocaliteService localiteService;
	
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<Magasin> magasins = magasinService.selectAll();
		if (magasins == null) {
			magasins = new ArrayList<Magasin>();
		}
		
		
		for(int i=0 ; i<magasins.size(); i++) {
			
			magasins.get(i).setLocalite(localiteService.getById(magasins.get(i).getLocalite().getId()));
			
		}
		
		
		model.addAttribute("magasins", magasins);
		return "pages/magasin/magasinPage";
		
	}

	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		Magasin magasin = new Magasin();
		
		model.addAttribute("localites", localiteService.selectAll());
		model.addAttribute("magasin", magasin);
		
		model.addAttribute("ttt", "nouveau");
		
		return "pages/magasin/addUpMagasin";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, Magasin magasin, HttpServletRequest request) {
		
		
		
		int loc_id = Integer.parseInt(request.getParameter("loc_id"));
		
		
		if(magasin != null) {
			
			magasin.setLocalite(localiteService.getById(loc_id));
			
			if (magasin.getId() != null) {
				magasinService.update(magasin);
			} else {
				
				magasinService.save(magasin);
				magasin.setCode("MG"+String.valueOf(magasin.getId()));
				magasinService.update(magasin);
			}
		}
		
		return "redirect:/magasin";
		
	}
	
	@RequestMapping(value = "/modifier/{idMagasin}")
	public String modifier(Model model, @PathVariable Integer idMagasin) {
		if (idMagasin != null) {
			Magasin magasin = magasinService.getById(idMagasin);
			if (magasin != null) {
			
				
				model.addAttribute("localites", localiteService.selectAll());
				
				
				
				magasin.setLocalite(localiteService.getById(magasin.getLocalite().getId()));
				
				
				model.addAttribute("ttt", "modifier");
				
				model.addAttribute("magasin", magasin);
			}
		}
		return "pages/magasin/addUpMagasin";
	}
	
	@RequestMapping(value = "/supprimer/{idMagasin}")
	public String supprimer(Model model, @PathVariable Integer idMagasin) {
		if (idMagasin != null) {
			Magasin magasin = magasinService.getById(idMagasin);
			if (magasin != null) {
				magasinService.remove(idMagasin);
			}
		}
		return "redirect:/magasin";
	}

}
