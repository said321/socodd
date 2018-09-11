package com.socodd.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socodd.entities.SousPrefecture;
import com.socodd.services.ISousPrefectureService;
import com.socodd.services.IPrefectureService;


@Controller
@RequestMapping(value = "/u/sousPrefecture")
public class SousPrefectureController {

	@Autowired
	private ISousPrefectureService sousPrefectureService;
	
	@Autowired
	private IPrefectureService prefectureService;
	
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<SousPrefecture> sousPrefectures = sousPrefectureService.selectAll();
		if (sousPrefectures == null) {
			sousPrefectures = new ArrayList<SousPrefecture>();
		}
		
		
		for(int i=0 ; i<sousPrefectures.size(); i++) {
			
			sousPrefectures.get(i).setPrefecture(prefectureService.getById(sousPrefectures.get(i).getPrefecture().getId()));
			
		}
		
		
		model.addAttribute("sousPrefectures", sousPrefectures);
		return "pages/sousPrefecture/sousPrefecturePage";
		
	}
	
	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		SousPrefecture sousPrefecture = new SousPrefecture();
		
		
		model.addAttribute("prefectures", prefectureService.selectAll());
		model.addAttribute("ttt", "nouveau");
		model.addAttribute("sousPrefecture", sousPrefecture);
		
		return "pages/sousPrefecture/addUpSousPrefecture";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, SousPrefecture sousPrefecture, HttpServletRequest request) {
		
		int pref_id = Integer.parseInt(request.getParameter("pref_id"));
		
		if(sousPrefecture != null) {
			
			sousPrefecture.setPrefecture(prefectureService.getById(pref_id));
			
			if (sousPrefecture.getId() != null) {
				sousPrefectureService.update(sousPrefecture);
			} else {
				sousPrefectureService.save(sousPrefecture);
				sousPrefecture.setCode("SP"+String.valueOf(sousPrefecture.getId()));
				sousPrefectureService.update(sousPrefecture);
			}
		}
		
		return "redirect:/sousPrefecture";
		
	}
	
	@RequestMapping(value = "/modifier/{idSousPrefecture}")
	public String modifier(Model model, @PathVariable Integer idSousPrefecture) {
		if (idSousPrefecture != null) {
			SousPrefecture sousPrefecture = sousPrefectureService.getById(idSousPrefecture);
			if (sousPrefecture != null) {
				
				
				model.addAttribute("prefectures", prefectureService.selectAll());
				
				sousPrefecture.setPrefecture(prefectureService.getById(sousPrefecture.getPrefecture().getId()));
				
				
				model.addAttribute("ttt", "modifier");
				
				model.addAttribute("sousPrefecture", sousPrefecture);
			}
		}
		return "pages/sousPrefecture/addUpSousPrefecture";
	}
	
	@RequestMapping(value = "/supprimer/{idSousPrefecture}")
	public String supprimer(Model model, @PathVariable Integer idSousPrefecture) {
		if (idSousPrefecture != null) {
			SousPrefecture sousPrefecture = sousPrefectureService.getById(idSousPrefecture);
			if (sousPrefecture != null) {
				sousPrefectureService.remove(idSousPrefecture);
			}
		}
		return "redirect:/sousPrefecture";
	}

}
