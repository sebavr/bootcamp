package com.codingdojo.SelfJoin.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.SelfJoin.models.Employee;
import com.codingdojo.SelfJoin.services.EmployeeService;

@Controller
public class SelfJoinController {
	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	} 
	
	@RequestMapping("/employees")
	public String employeeIndex(Model model) {
		List<Employee> employees = service.findAllEmployees();
		model.addAttribute("employees", employees);
		return "/employees/index.jsp";
	}
	
	@RequestMapping("/employees/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Employee employee = service.findOneEmployee(id);
		model.addAttribute("employee", employee);
		List<Employee> employees = service.findAllEmployees();
		model.addAttribute("employees", employees);
		return "/employees/show.jsp";
	}
	
	@RequestMapping("/employees/new")
	public String newEmployee(@ModelAttribute("employee") Employee employee) {
		return "/employees/new.jsp";
	}
	
	@RequestMapping(value="/employees", method=RequestMethod.POST)
	public String createEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {
		if (result.hasErrors()) {
			return "/employees/new.jsp";
		} else {
			service.createEmployee(employee);
			return "redirect:/employees";
		}
	}
	
	@RequestMapping("/addManager")
	public String addManager(
			@RequestParam(name="managerId") Long managerId,
			@RequestParam(name="employeeId") Long employeeId) {
		service.addManager(managerId, employeeId);
		return "redirect:/employees";
	}
	
}
