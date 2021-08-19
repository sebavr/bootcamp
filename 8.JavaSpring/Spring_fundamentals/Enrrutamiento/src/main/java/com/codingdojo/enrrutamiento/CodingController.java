package com.codingdojo.enrrutamiento;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodingController {
	
	
	@RequestMapping("/coding")
	public String hello() {
		return "¡Hola Coding Dojo!";
	}
	
	@RequestMapping("/coding/python")
	public String a() {
		return "¡Python/Django fue increíble!";
	}
	
	@RequestMapping("/coding/java")
	public String b() {
		return "¡Java/Spring es mejor!";
	}
}

