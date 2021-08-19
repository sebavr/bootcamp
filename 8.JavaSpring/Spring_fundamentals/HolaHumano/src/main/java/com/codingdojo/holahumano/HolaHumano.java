package com.codingdojo.holahumano;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaHumano {
	
	
	
	@RequestMapping("/")
	public String index(@RequestParam(value="name",required=false) String searchName,@RequestParam(value="lname",required=false) String apellido) {
		if(searchName==null) {
			 return "<h1>Hola Humano </h1><br><br><h2>Bienvenido a Springboot</h2>";
		}else {
			
			 return "<h1>Hola "+searchName.concat(" ")+apellido+  "!</h1><br><br><h2>Bienvenido a Springboot</h2>";
		}
	}

}
