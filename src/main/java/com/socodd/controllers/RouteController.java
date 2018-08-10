package com.socodd.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socodd.entities.Route;
import com.socodd.services.IPortService;
import com.socodd.services.IPrefectureService;
import com.socodd.services.IRegionService;
import com.socodd.services.IRouteService;
import com.socodd.services.ISousPrefectureService;


@Controller
@RequestMapping(value = "/route")
public class RouteController {

	@Autowired
	private IRouteService routeService;
	
	@Autowired
	private ISousPrefectureService sousPrefectureService;
	
	@Autowired
	private IPrefectureService prefectureService;
	
	@Autowired
	private IRegionService regionService;

	@Autowired
	private IPortService portService;
	
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<Route> routes = routeService.selectAll();
		if (routes == null) {
			routes = new ArrayList<Route>();
		}
		
		
		for(int i=0 ; i<routes.size(); i++) {
			
			routes.get(i).setSousPrefecture(sousPrefectureService.getById(routes.get(i).getSousPrefecture().getId()));
			routes.get(i).setPrefecture(prefectureService.getById(routes.get(i).getPrefecture().getId()));
			routes.get(i).setRegion(regionService.getById(routes.get(i).getRegion().getId()));
			routes.get(i).setPort(portService.getById(routes.get(i).getPort().getId()));
			
		}
		
		
		model.addAttribute("routes", routes);
		return "pages/route/routePage";
		
	}
	
	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		Route route = new Route();
		
		
		model.addAttribute("sousPrefectures", sousPrefectureService.selectAll());
		model.addAttribute("ports", portService.selectAll());
		
		model.addAttribute("ttt", "nouveau");
		model.addAttribute("route", route);
		
		return "pages/route/addUpRoute";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, Route route, HttpServletRequest request) {
		
		int s_pref_id = Integer.parseInt(request.getParameter("s_pref_id"));
		int port_id = Integer.parseInt(request.getParameter("port_id"));
		
		if(route != null) {
			
			route.setSousPrefecture(sousPrefectureService.getById(s_pref_id));
			route.setPrefecture(prefectureService.getById(route.getSousPrefecture().getPrefecture().getId()));
			route.setRegion(regionService.getById(route.getPrefecture().getRegion().getId()));
			route.setPort(portService.getById(port_id));
			
			if (route.getId() != null) {
				routeService.update(route);
			} else {
				routeService.save(route);
				route.setCode("RT"+String.valueOf(route.getId()));
				routeService.update(route);
			}
		}
		
		return "redirect:/route";
		
	}
	
	@RequestMapping(value = "/modifier/{idRoute}")
	public String modifier(Model model, @PathVariable Integer idRoute) {
		if (idRoute != null) {
			Route route = routeService.getById(idRoute);
			if (route != null) {
				
				
				model.addAttribute("sousPrefectures", sousPrefectureService.selectAll());
				route.setSousPrefecture(sousPrefectureService.getById(route.getSousPrefecture().getId()));
				
				model.addAttribute("ports", portService.selectAll());
				route.setPort(portService.getById(route.getPort().getId()));
				
				
				model.addAttribute("ttt", "modifier");
				
				model.addAttribute("route", route);
			}
		}
		return "pages/route/addUpRoute";
	}
	
	@RequestMapping(value = "/supprimer/{idRoute}")
	public String supprimer(Model model, @PathVariable Integer idRoute) {
		if (idRoute != null) {
			Route route = routeService.getById(idRoute);
			if (route != null) {
				routeService.remove(idRoute);
			}
		}
		return "redirect:/route";
	}

}
