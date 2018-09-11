package com.socodd.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socodd.entities.Prefecture;
import com.socodd.services.IPrefectureService;
import com.socodd.services.IRegionService;


@Controller
@RequestMapping(value = "/u/prefecture")
public class PrefectureController {

	@Autowired
	private IPrefectureService prefectureService;
	
	@Autowired
	private IRegionService regionService;
	
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<Prefecture> prefectures = prefectureService.selectAll();
		if (prefectures == null) {
			prefectures = new ArrayList<Prefecture>();
		}
		
		
		for(int i=0 ; i<prefectures.size(); i++) {
			
			prefectures.get(i).setRegion(regionService.getById(prefectures.get(i).getRegion().getId()));
			
		}
		
		
		model.addAttribute("prefectures", prefectures);
		return "pages/prefecture/prefecturePage";
		
	}
	
	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		Prefecture prefecture = new Prefecture();
		
		
		model.addAttribute("regions", regionService.selectAll());
		model.addAttribute("ttt", "nouveau");
		model.addAttribute("prefecture", prefecture);
		
		return "pages/prefecture/addUpPrefecture";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, Prefecture prefecture, HttpServletRequest request) {
		
		int reg_id = Integer.parseInt(request.getParameter("reg_id"));
		
		if(prefecture != null) {
			
			prefecture.setRegion(regionService.getById(reg_id));
			
			if (prefecture.getId() != null) {
				prefectureService.update(prefecture);
			} else {
				prefectureService.save(prefecture);
				prefecture.setCode("P"+String.valueOf(prefecture.getId()));
				prefectureService.update(prefecture);
			}
		}
		
		return "redirect:/prefecture";
		
	}
	
	@RequestMapping(value = "/modifier/{idPrefecture}")
	public String modifier(Model model, @PathVariable Integer idPrefecture) {
		if (idPrefecture != null) {
			Prefecture prefecture = prefectureService.getById(idPrefecture);
			if (prefecture != null) {
				
				
				model.addAttribute("regions", regionService.selectAll());
				
				prefecture.setRegion(regionService.getById(prefecture.getRegion().getId()));
				
				
				model.addAttribute("ttt", "modifier");
				
				model.addAttribute("prefecture", prefecture);
			}
		}
		return "pages/prefecture/addUpPrefecture";
	}
	
	@RequestMapping(value = "/supprimer/{idPrefecture}")
	public String supprimer(Model model, @PathVariable Integer idPrefecture) {
		if (idPrefecture != null) {
			Prefecture prefecture = prefectureService.getById(idPrefecture);
			if (prefecture != null) {
				prefectureService.remove(idPrefecture);
			}
		}
		return "redirect:/prefecture";
	}

}
