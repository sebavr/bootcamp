package com.codingdojo_pokemon;



public class Pokemon {
	
	private int health;
	private String name;
	private String type;
	static int count;
	
	 public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Pokemon.count = count;
	}

	
	
	public Pokemon(String name, int health, String type) {
		super();
		this.health = health;
		this.name = name;
		this.type = type;
		count++;
		
	}
	
	void attackPokemon(Pokemon pokemonAtacado) {
		pokemonAtacado.setHealth(pokemonAtacado.getHealth()-10);
		System.out.println(this.getName()+" atacó a "+pokemonAtacado.name+" ocasionandole 10 puntos de daño");
		
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
}
