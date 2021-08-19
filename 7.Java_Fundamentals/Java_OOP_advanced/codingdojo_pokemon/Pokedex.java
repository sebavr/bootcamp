package com.codingdojo_pokemon;

import java.util.ArrayList;

public class Pokedex extends AbstractPokemon {
	
	
	
	
	
	public Pokedex() {
		super();
		mispokemones= new ArrayList<Pokemon>();
	}



//lista de pokemon creados
public void listPokemon(){
	for(int i=0; i<mispokemones.size();i++) {
		System.out.println("Nombre: "+mispokemones.get(i).getName()+" salud: "+mispokemones.get(i).getHealth()+" tipo: "+mispokemones.get(i).getType());
		
	}
	
	
	
}

	
	
	

}
