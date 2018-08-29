package com.socodd.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socodd.entities.Employee;
import com.socodd.entities.Equipe;
import com.socodd.services.IBanqueService;
import com.socodd.services.IDepartementService;
import com.socodd.services.IEmployeeService;
import com.socodd.services.IEquipeService;
import com.socodd.services.INationaliteService;
import com.socodd.utils.FormatingDate;


@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private INationaliteService nationaliteService;
	
	@Autowired
	private IDepartementService departementService;
	
	@Autowired
	private IEquipeService equipeService;
	
	@Autowired
	private IBanqueService banqueService;
	 
	@RequestMapping(value = {"", "/"})
	public String all(Model model) {
		
		List<Employee> employees = employeeService.selectAll();
		if (employees == null) {
			employees = new ArrayList<Employee>();
		}
		
		
		for(int i=0 ; i<employees.size(); i++) {
			
			employees.get(i).setNationalite(nationaliteService.getById(employees.get(i).getNationalite().getId()));
			employees.get(i).setDepartement(departementService.getById(employees.get(i).getDepartement().getId()));
			if(employees.get(i).getEquipe() != null)
				employees.get(i).setEquipe(equipeService.getById(employees.get(i).getEquipe().getId()));
			employees.get(i).setBanque(banqueService.getById(employees.get(i).getBanque().getId()));
			
		}
		
		
		model.addAttribute("employees", employees);
		return "pages/employee/employeePage";
		
	}

	@RequestMapping(value = "/nouveau")
	public String nouveau(Model model) {
		
		Employee employee = new Employee();
		
		model.addAttribute("nationalites", nationaliteService.selectAll());
		model.addAttribute("departements", departementService.selectAll());
		model.addAttribute("equipes", equipeService.selectAll());
		model.addAttribute("banques", banqueService.selectAll());
		
		model.addAttribute("employee", employee);
		
		return "pages/employee/addEmployee";
		
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, Employee employee, HttpServletRequest request) {
		
		
		
		int nationalite_id = Integer.parseInt(request.getParameter("nationalite_id"));
		int departement_id = Integer.parseInt(request.getParameter("departement_id"));
		int equipe_id = Integer.parseInt(request.getParameter("equipe_id"));
		int banque_id = Integer.parseInt(request.getParameter("banque_id"));
		Date dateEntree = FormatingDate.stringToDate(request.getParameter("date_entree"), "yyyy-MM-dd");
		Date dateNaissance = FormatingDate.stringToDate(request.getParameter("date_naissance"), "yyyy-MM-dd");
		
		
		if(employee != null) {
			
			employee.setNationalite(nationaliteService.getById(nationalite_id));
			employee.setDepartement(departementService.getById(departement_id));
			employee.setEquipe(equipeService.getById(equipe_id));
			employee.setBanque(banqueService.getById(banque_id));
			employee.setDateEntree(dateEntree);
			employee.setDateNaissance(dateNaissance);
			
			
			if (employee.getId() != null) {
				employeeService.update(employee);
			} else {
				
				employeeService.save(employee);
				employee.setCode("EP"+String.valueOf(employee.getId()));
				employeeService.update(employee);
			}
		}
		
		return "redirect:/employee";
		
	}
	
	@RequestMapping(value = "/modifier/{idEmployee}")
	public String modifier(Model model, @PathVariable Integer idEmployee) {
		if (idEmployee != null) {
			Employee employee = employeeService.getById(idEmployee);
			if (employee != null) {
			
				
				model.addAttribute("employees", employeeService.selectAll());
				
				employee.setNationalite(nationaliteService.getById(employee.getNationalite().getId()));
				employee.setDepartement(departementService.getById(employee.getDepartement().getId()));
				employee.setEquipe(equipeService.getById(employee.getEquipe().getId()));
				employee.setBanque(banqueService.getById(employee.getBanque().getId()));
				
				model.addAttribute("employee", employee);
			}
		}
		return "pages/employee/upEmployee";
	}
	
	@RequestMapping(value = "/supprimer/{idEmployee}")
	public String supprimer(Model model, @PathVariable Integer idEmployee) {
		if (idEmployee != null) {
			Employee employee = employeeService.getById(idEmployee);
			if (employee != null) {
				employeeService.remove(idEmployee);
			}
		}
		return "redirect:/employee";
	}

}
