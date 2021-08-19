package com.codingdojo.relationships.controllers;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.services.PersonService;
@Controller
public class HomeController {
	
	
	private final PersonService personService;

	public HomeController(PersonService personService) {
			
			this.personService = personService;
		}
	
	@RequestMapping("/index")
	public String nisu() {
		 return "index.jsp";
	}
	
	@RequestMapping("/")
	public String niu() {
		 return "redirect:persons/new";
	}


	@GetMapping("persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
	    return "person/newPerson.jsp";
	}
	
	
	/*@RequestMapping(value="/index", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("p") Person person, BindingResult result, Model model) {
	   if (result.hasErrors()) {
		   List <Person> persons = personService.allPersons();
			model.addAttribute("persons",persons);
	        return "persons/new.jsp";
	    } else {
	       personService.createPerson(person);
	        return "redirect:/licenses/new";
	    }
	}*/
	
	@PostMapping("persons/new") 
	public String processAddPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "newPerson.jsp";
		}
		else {
			personService.createPerson(person);
			return "redirect:/license/new";
		}
	}
	
	@GetMapping("license/new")
	public String addLicense(@ModelAttribute("license")License license, Model model) {
		List<Person> persons = personService.allPersons();
		model.addAttribute("persons",persons);
		return"license/newLicense.jsp";
		
	}
	
	@PostMapping("license/new")
	public String processLicense(@Valid @ModelAttribute("license") License license, BindingResult result,Model model) {
		if(result.hasErrors()) {
			List<Person> persons = personService.allPersons();
			model.addAttribute("persons",persons);
			return "license/newLicense.jsp";
		}
		else {
			String number = personService.generateLicenseNumber();
			license.setNumber(number);
//		
		personService.createLicense(license);
			//return"redirect:/persons/"+license.getId();
		return"redirect:/persons/"+license.getId();
			
		}
	}
	
	@RequestMapping("/persons/{personId}")
	public String setUpView(@PathVariable("personId")Long id,Model model) {
		Date date = personService.getLicense(id).get().getExpirationDate();
		String pattern ="MM/dd/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		model.addAttribute("date",simpleDateFormat.format(date));
		model.addAttribute("license",personService.getLicense(id).get());
		return"info.jsp";
	}
	
	
	}
