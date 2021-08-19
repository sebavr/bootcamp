package com.codingdojo.Consulta_Join.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.Consulta_Join.services.ApiService;





@Controller
public class CountryControllers {
	
private final ApiService apiService;
	

	public CountryControllers(ApiService apiService) {
			
			this.apiService = apiService;
			
		}
	
	
	@RequestMapping("/")
	public String niu(Model model) {
		List<Object[]> pregunta1=apiService.pregunta1("slovene");
	
		model.addAttribute("lista1",pregunta1);
	return "index.jsp";
		}
	
	@RequestMapping("/2")
	public String niu2(Model model) {
		List<Object[]> pregunta2=apiService.pregunta2();
	
		model.addAttribute("lista2",pregunta2);
	return "query2.jsp";
		}
	
	@RequestMapping("/3")
	public String niu3(Model model) {
		List<Object[]> pregunta3=apiService.pregunta3();
	
		model.addAttribute("lista3",pregunta3);
	return "query3.jsp";
		
	}
	@RequestMapping("/4")
	public String niu4(Model model) {
		List<Object[]> pregunta4=apiService.pregunta4();
	
		model.addAttribute("lista4",pregunta4);
	return "query4.jsp";
		
	}
	
	@RequestMapping("/5")
	public String niu5(Model model) {
		List<Object[]> pregunta5=apiService.pregunta5();
	
		model.addAttribute("lista5",pregunta5);
	return "query5.jsp";
		
	}
	
	@RequestMapping("/6")
	public String niu6(Model model) {
		List<Object[]> pregunta6=apiService.pregunta6();
	
		model.addAttribute("lista6",pregunta6);
	return "query6.jsp";
		
	}
	
	@RequestMapping("/7")
	public String niu7(Model model) {
		List<Object[]> pregunta7=apiService.pregunta7();
	
		model.addAttribute("lista7",pregunta7);
	return "query7.jsp";
		
	}
	
	
	
}

