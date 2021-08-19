package com.codingdojo_pokemon;

public interface PokemonInterface {
	
	public abstract Pokemon  createPokemon(String name, int health, String type);
	public abstract String pokemonInfo(Pokemon pokemon);
	void listPokemon();

}
