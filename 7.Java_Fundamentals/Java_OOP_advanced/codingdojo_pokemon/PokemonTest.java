package com.codingdojo_pokemon;

public class PokemonTest {

	public static void main(String[] args) {
		
		/*Pokemon c= new Pokemon("pikachu",100,"electrico");
		
		c.attackPokemon(c2);
		
		*/
		
		
		//Pokemon pikachu=new Pokemon("Pikachu", 220, "Electric");
		//Pokemon bulbasaur= new Pokemon("bulbasaur",100,"planta");
		
		
		Pokedex p=new Pokedex();
		
		Pokemon squirtle = p.createPokemon("Squirtle", 50, "Water");
		Pokemon charmander = p.createPokemon("Charmander", 50, "Fire");
		Pokemon bulbasaur=p.createPokemon("bulbasaur",50,"planta");
		Pokemon pikachu=p.createPokemon("pikachu",50,"electric");
	
		
		//System.out.println(guia.pokemonInfo(squirtle));
		
		pikachu.attackPokemon(charmander);
		bulbasaur.attackPokemon(pikachu);
		pikachu.attackPokemon(squirtle);
		pikachu.attackPokemon(bulbasaur);
		pikachu.attackPokemon(bulbasaur);
		pikachu.attackPokemon(bulbasaur);
		
		
		//System.out.println("numero de pokemon: "+pikachu.getCount());
		p.listPokemon();
		
		
		
		

	}

}
