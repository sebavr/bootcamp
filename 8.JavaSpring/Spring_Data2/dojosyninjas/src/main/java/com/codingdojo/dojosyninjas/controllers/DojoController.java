package com.codingdojo.dojosyninjas.controllers;

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

import com.codingdojo.dojosyninjas.models.Dojo;
import com.codingdojo.dojosyninjas.models.Ninja;
import com.codingdojo.dojosyninjas.services.DojoService;
import com.codingdojo.dojosyninjas.services.NinjaService;



@Controller
public class DojoController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;

	public DojoController(DojoService dojoService,NinjaService ninjaService) {
			
			this.dojoService = dojoService;
			this.ninjaService = ninjaService;
		}
	

	
@RequestMapping("/")
public String niu() {
return "redirect:dojos/new";
	}

@GetMapping("dojos/new")
public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
    return "dojos/newDojo.jsp";
}

@PostMapping("dojos/new") 
public String nuevodojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
	if(result.hasErrors()) {
		return "newDojo.jsp";
	}
	else {
		dojoService.createDojo(dojo);
		return "redirect:/ninja/new";
	}
}

@GetMapping("ninja/new")
public String addNinja(@ModelAttribute("ninja")Ninja ninja, Model model) {
	List<Dojo> dojos = dojoService.allDojos();
	model.addAttribute("dojos",dojos);
	return"ninjas/newNinja.jsp";
	
}

@PostMapping("ninja/new")
public String newNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result,Model model) {
	if(result.hasErrors()) {
		
		return "ninjas/newNinja.jsp";
	}
	else {
		
		ninjaService.createNinja(ninja);
	return"redirect:/dojos/"+ninja.getDojo().getId();
		
	}
}

@GetMapping("/dojos/{dojo_id}")
public String setUpView(@PathVariable("dojo_id")Long id,Model model) {
	Dojo  dojo=dojoService.findDojo(id);
	model.addAttribute("dojo",dojo);
	
	return"dojos/infoDojo.jsp";
}
}


