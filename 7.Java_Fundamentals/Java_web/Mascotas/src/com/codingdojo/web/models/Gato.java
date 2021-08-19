package com.codingdojo.web.models;

public  class Gato extends Animal implements Mascota{

	public Gato() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gato(String nombre, String raza, int peso) {
		super(nombre, raza, peso);
		// TODO Auto-generated constructor stub
	}

	@Override
public String mostrarAfecto() {
		
		return "Tú Gato es muy tierno.";
	}

	

	

}
