package maestroObjetos;



public class Human {
	
	protected int strength;
	protected int stealth;
	protected int intelligence;
	protected int health;
	
	public Human() {
		super();
		this.strength = 3;
		this.stealth = 3;
		this.intelligence = 3;
		this.health=100;
	}
	
	public void attackHuman(Human humanoAtacado) {
		humanoAtacado.setHealth(getHealth()-this.strength);
		System.out.println("El hombre 1 le tiro un combo al  hombre2  ocasionandole : "+this.strength+" de daño");
		System.out.println("La salud del hombre golpeado es: "+humanoAtacado.health);
	}

	
	// geter y setter
	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getStealth() {
		return stealth;
	}

	public void setStealth(int stealth) {
		this.stealth = stealth;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	
	

}
