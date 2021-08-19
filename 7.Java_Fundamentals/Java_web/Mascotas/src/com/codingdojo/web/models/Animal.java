package com.codingdojo.web.models;

public  class Animal {

	private String nombre;
	private String Raza;
	private int peso;
	
	public Animal(String nombre, String raza, int peso) {
		super();
		this.nombre = nombre;
		this.Raza = raza;
		this.peso = peso;
	}

	public Animal() {
		super();
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return Raza;
	}

	public void setRaza(String raza) {
		Raza = raza;
	}

	public int getpeso() {
		return peso;
	}

	public void setpeso(int peso) {
		this.peso = peso;
	}

	
	
	
}
