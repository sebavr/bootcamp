package com.codingdojo_pokemon;

import java.util.ArrayList;

public abstract class AbstractPokemon implements PokemonInterface{
	
	ArrayList<Pokemon> mispokemones= new ArrayList<Pokemon>();

	@Override
	public Pokemon createPokemon(String name, int health, String type) {
		Pokemon poke=new Pokemon(name,health,type);
		mispokemones.add(poke);
		return poke;
	}

	@Override
	public String pokemonInfo(Pokemon pokemon) {
		
		return pokemon.getName()+pokemon.getHealth()+pokemon.getType();
		
	}
	
	

	
	
	
	

}
