package com.codingdojo.EncuestaDojo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Home {
	@RequestMapping("/")
	public String home() {
	return "index.jsp";
	}

	@RequestMapping(value="/result", method=RequestMethod.POST)
    public String login(@RequestParam(value="nombre") String nombre,@RequestParam(value="ubicacion") String ubicacion,@RequestParam(value="lenguaje") String lenguaje,@RequestParam(value="comentario") String comentario,Model model) {
		model.addAttribute("nombre",nombre );
		model.addAttribute("lenguaje",lenguaje );
		model.addAttribute("ubicacion",ubicacion );
		model.addAttribute("comentario",comentario );
		
		return "result.jsp";
	}
}



