package com.codingdojo.language.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.language.models.Language;
import com.codingdojo.language.services.LanguageService;


@Controller
public class LanguageController {
	private final LanguageService languageService;
	
	
    
    public LanguageController(LanguageService languageService) {
	
		this.languageService = languageService;
	}
    
   
	@RequestMapping("/languages")
    public String index(@ModelAttribute("lang_nuevo") Language language, Model model){
        List<Language> languages = languageService.allLanguages();
        model.addAttribute("lista", languages);
        return "/languages/index.jsp";
    }
	
	@RequestMapping(value="/languages", method=RequestMethod.POST)
	    public String create(@Valid @ModelAttribute("lang_nuevo") Language language, BindingResult result, Model model) {
		   if (result.hasErrors()) {
			   List <Language> languages = languageService.allLanguages();
				model.addAttribute("lista",languages);
	            return "/languages/index.jsp";
	        } else {
	           languageService.createLanguage(language);
	            return "redirect:/languages";
	        }
		   
		   
	    }
	 @RequestMapping("/languages/{id}")
	    public String show(@PathVariable("id") Long id,Model model) {
	        Language languages = languageService.findLanguage(id);
	        model.addAttribute("lista", languages);
	        return "/languages/show.jsp";
	    }
	
	 @RequestMapping("/languages/edit/{id}")
	    public String edit(@PathVariable("id") Long id, Model model) {
	        Language languages = languageService.findLanguage(id);
	        model.addAttribute("language", languages);
	        return "/languages/edit.jsp";
	    }
	 
	   @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
	    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
	        if (result.hasErrors()) {
	            return "/languages/edit.jsp";
	        } else {
	        	languageService.updateLanguage(language);
	            return "redirect:/languages";
	        }
	    }
	   
	   @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
	    public String destroy(@PathVariable("id") Long id) {
	        languageService.deleteLanguage(id);
	        return "redirect:/languages";
	    }
	 
	
	/*
	
	@RequestMapping("/languages/edit/{id}")
	    public String show(@PathVariable("id") Long id,Model model) {
	        Language language = languageService.findLanguage(id);
	        model.addAttribute("language", language);
	        return "/languages/show.jsp";
	    }
	 
	 
	 * @RequestMapping("/languages/new")
    public String newLanguage(@ModelAttribute("language") Language language) {
        return "/languages/new.jsp";
    }
   
    }
   
    
    @RequestMapping("/languages/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "/languages/edit.jsp";
    }
    
   
   
*/
}
