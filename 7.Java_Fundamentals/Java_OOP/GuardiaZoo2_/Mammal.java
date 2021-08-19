package GuardiaZoo;

public class Mammal {
	
	protected Integer energyLevel;
	
	public void displayEnergy() {
		System.out.println(energyLevel);
}

	
	public Integer getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(Integer energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	/*sobreescritura de constructores
	yo puedo usar ambos constructores, si no esta definido el parametro
	uso el primero, si lo esta uso el segundo.*/
	
	public Mammal() {
		this.energyLevel=100;
	}
	
	public Mammal(int energyLevel) {
		this.energyLevel=energyLevel;
	}

}