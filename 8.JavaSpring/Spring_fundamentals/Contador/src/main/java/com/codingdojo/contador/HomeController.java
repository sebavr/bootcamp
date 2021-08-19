package com.codingdojo.contador;



import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;





@Controller
public class HomeController {
	@RequestMapping("/")
	public String home(HttpSession session) {
		
		if(session.isNew()) {
			session.setAttribute("counter", 0);
		}else {
			Integer count = (Integer) session.getAttribute("counter");
			count++;
			session.setAttribute("counter", count);
		}
			 
			return "index.jsp";
			
		}
	
	@RequestMapping("/counter")
	public String i() {
		 
		 
		 
		 
			return "counter.jsp";
			
		}
	
	@RequestMapping("/counter2")
	public String o(HttpSession session) {
		Integer count = (Integer) session.getAttribute("counter");
		count++;
		
		session.setAttribute("counter", count);
		 
		 
		 
			return "counter.jsp";
			
		}
	
	
	@RequestMapping("/reset")
	public String u(HttpSession session) {
		session.setAttribute("counter", 0);
		 
		 
		 
			return "counter.jsp";
			
		}
		

}
	
