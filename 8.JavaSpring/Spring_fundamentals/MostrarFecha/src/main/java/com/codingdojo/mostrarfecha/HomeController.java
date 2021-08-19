package com.codingdojo.mostrarfecha;


import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Controller

public class HomeController {
	@RequestMapping("/")
	public String home(Model model) {
		 
		return "index.jsp";
		
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		date_time d=new date_time();
		model.addAttribute("time",d.showTime() );
		 
		return "time.jsp";
		
	}
	@RequestMapping("/date")
	public String date(Model model) {
		date_time c=new date_time();
		model.addAttribute("date",c.showDate() );
		 
		return "date.jsp";
		
	}
	
	
		
}
