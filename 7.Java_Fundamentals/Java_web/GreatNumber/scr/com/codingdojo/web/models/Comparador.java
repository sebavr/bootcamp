package com.codingdojo.web.models;

import java.util.Random;

public class Comparador {
	
	Random r1=new Random();
	
public Comparador() {
	}

private int numero;
private boolean playagain=false;

public int generarAleatorio() {
	return r1.nextInt(10)+1;
	
}


public String Comparador(Integer numero, Integer adivinar) {
	
	if(numero<adivinar) {
		
		return "El numero es demasiado bajo";
		
	}else if(numero>adivinar) {
		
		return "El numero es demasiado alto";
	}else
		playagain=true;
	return "El número es el correcto";
	
	
}



public int getNumero() {
	return numero;
}


public void setNumero(int numero) {
	this.numero = numero;
}



public boolean isPlayagain() {
	return playagain;
}

public void setPlayagain(boolean playagain) {
	this.playagain = playagain;
}

}
