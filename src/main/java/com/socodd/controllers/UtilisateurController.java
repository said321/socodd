package com.socodd.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socodd.entities.Utilisateur;
import com.socodd.services.IProfileUtilisateurService;
import com.socodd.services.IUtilisateurService;


@Controller
@RequestMapping(value = "/utilisateur")
public class UtilisateurController {

	@Autowired
	private IUtilisateurService utilisateurService;
	
	@Autowired
	private IProfileUtilisateurService profileUtilisateurService;
	
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<Utilisateur> utilisateurs = utilisateurService.selectAll();
		if (utilisateurs == null) {
			utilisateurs = new ArrayList<Utilisateur>();
		}
		
		
		for(int i=0 ; i<utilisateurs.size(); i++) {
			
			utilisateurs.get(i).setProfileUtilisateur(profileUtilisateurService.getById(utilisateurs.get(i).getProfileUtilisateur().getId()));
			
		}
		
		model.addAttribute("utilisateurs", utilisateurs);
		return "pages/utilisateur/utilisateurPage";
		
	}
	
	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		Utilisateur utilisateur = new Utilisateur();
		
		
		model.addAttribute("profileUtilisateurs", profileUtilisateurService.selectAll());
		model.addAttribute("utilisateur", utilisateur);
		
		model.addAttribute("ttt", "nouveau");
		
		return "pages/utilisateur/addUpUtilisateur";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, Utilisateur utilisateur, HttpServletRequest request) {
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		
		if(utilisateur != null) {
			
			utilisateur.setProfileUtilisateur(profileUtilisateurService.getById(pid));
			
			if (utilisateur.getId() != null) {
				utilisateurService.update(utilisateur);
			} else {
				utilisateurService.save(utilisateur);
				utilisateur.setCode("US"+String.valueOf(utilisateur.getId()));
				utilisateurService.update(utilisateur);
			}
		}
		
		return "redirect:/utilisateur";
		
	}
	
	@RequestMapping(value = "/modifier/{idUtilisateur}")
	public String modifier(Model model, @PathVariable Integer idUtilisateur) {
		if (idUtilisateur != null) {
			Utilisateur utilisateur = utilisateurService.getById(idUtilisateur);
			if (utilisateur != null) {
				
				model.addAttribute("profileUtilisateurs", profileUtilisateurService.selectAll());
				
				utilisateur.setProfileUtilisateur(profileUtilisateurService.getById(utilisateur.getProfileUtilisateur().getId()));
				
				model.addAttribute("utilisateur", utilisateur);
				
				model.addAttribute("ttt", "modifier");
				
			}
		}
		return "pages/utilisateur/addUpUtilisateur";
	}
	
	@RequestMapping(value = "/supprimer/{idUtilisateur}")
	public String supprimer(Model model, @PathVariable Integer idUtilisateur) {
		if (idUtilisateur != null) {
			Utilisateur utilisateur = utilisateurService.getById(idUtilisateur);
			if (utilisateur != null) {
				utilisateurService.remove(idUtilisateur);
			}
		}
		return "redirect:/utilisateur";
	}

}
