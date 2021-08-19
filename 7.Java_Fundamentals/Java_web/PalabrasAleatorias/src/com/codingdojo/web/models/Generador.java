package com.codingdojo.web.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Generador {
	
	public String letras="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	
	
	public String random() {
		
		StringBuilder sb = new StringBuilder();//para juntar las letras aleatorias
		
		Random r = new Random(); //para generar aleatoriedad
		
		for (int i = 0; i < 10; i++) {
			
			sb.append(letras.charAt(r.nextInt(letras.length())));
			
			
		}
		
		return sb.toString();
	}
	
	
	public String fecha() {
		
		LocalDateTime fecha = LocalDateTime.now();  
		DateTimeFormatter formato=DateTimeFormatter.ofPattern(" MMMM dd,yyyy-HH:mm");
		 String fechaAhora = fecha.format(formato); 
		 return fechaAhora;
	}
	
	
	

}
