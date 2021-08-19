package com.codingdojo.myproyect.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.myproyect.models.Dojo;
import com.codingdojo.myproyect.models.Ninja;
import com.codingdojo.myproyect.services.DojoService;
import com.codingdojo.myproyect.services.NinjaService;

@Controller
public class AppController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	public AppController(NinjaService ninjaService,DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	@RequestMapping(value="/dojos/new",method=RequestMethod.POST)
	public String dojosNew(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
            return "redirect:/dojos/new";
        } else {
            dojoService.createDojo(dojo);
            return "redirect:/dojos/new";
        }
	}
	@RequestMapping(value="/ninjas/new",method=RequestMethod.POST)
	public String ninjasNew(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result,@RequestParam("dojoId") Long dojoId) {
		Dojo dojo=dojoService.findDojo(dojoId);
		ninja.setDojo(dojo);
		ninjaService.createNinja(ninja);
		return "redirect:/ninjas/new";
	}
	//***************Vistas***************
	@RequestMapping(value="/dojos/{id}",method=RequestMethod.GET)
	public String dojos(@PathVariable("id") Long id,Model model) {
		Dojo dojo=dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "dojos.jsp";
	}
	@RequestMapping(value="/dojos/new",method=RequestMethod.GET)
	public String dojosNew(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	@RequestMapping(value="/ninjas/new",method=RequestMethod.GET)
	public String ninjasNew(@ModelAttribute("ninja") Ninja ninja,Model model) {
		List<Dojo> dojos=dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "newNinja.jsp";
	}
	@RequestMapping("/pages/{pageNumber}")
	public String getNinjasPerPage(Model model, @PathVariable("pageNumber") int pageNumber) {
	    //Tenemos que restar 1 porque las páginas iterables empiezan con índice 0. Esto es para que nuestros enlaces puedan mostrarse desde 1...maxPage(última página) 
	    Page<Object[]> result = ninjaService.ninjasPerPage(pageNumber - 1);
	    //Total número de páginas que tenemos
	    int totalPages = result.getTotalPages();
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("result", result);
	    return "ninjas.jsp";
	}
}
