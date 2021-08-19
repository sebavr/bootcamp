package com.codingdojo.web.models;

public class Perro extends Animal implements Mascota{
	
	
	public void prueba() {
		System.out.println("prueba lalala");
	}

	@Override
	public String mostrarAfecto() {
		
		return "Tú perro es muy cariñoso.";
	}

	public Perro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Perro(String nombre, String raza, int peso) {
		super(nombre, raza, peso);
		// TODO Auto-generated constructor stub
	}


	

	
	}
	


