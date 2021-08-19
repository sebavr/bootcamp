package com.codingdojo.firstproyect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CadenasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadenasApplication.class, args);
	}

	@RequestMapping("/")
	public String hello() {
		return "Hola cliente, ¿Que estás haciendo?";
	}
	
	@RequestMapping("/Random")
	public String chao() {
			return "Spring boot es asombroso! Es muy fácil responder con cadenas";
		}
}
