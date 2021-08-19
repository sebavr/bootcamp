package com.codingdojo.enrrutamiento;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	
	@RequestMapping("/dojo")
	public String index(@RequestParam(value="q",required=false) String searchQuery) {
		if(searchQuery==null) {
			 return "El nada es increíble";
		}else {
			 return "El "+ searchQuery+" es increíble";
		}
	}
	
	
	@RequestMapping("/burbank-dojo")
	public String lugar(@RequestParam(value="b",required=false) String searchQuery) {
		if(searchQuery==null) {
			 return "El dojo  es fantabulantastico";
		}else {return "El dojo "+searchQuery+" es fantabulantastico";
		
}
}
	@RequestMapping("/san-jose")
	public String aa(@RequestParam(value="c",required=false) String searchQuery) {
		if(searchQuery==null) {
			 return "El Dojo SJ es el cuartel general";
		}else {return "El Dojo SJ es el cuartel general";
		
}
}
}
	
