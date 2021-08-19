package GuardiaZoo;

public class Bat extends Mammal {
	
	
	
	

	public void fly() {
		System.out.println("Chak chak (murcielago volando)");
		this.setEnergyLevel(this.getEnergyLevel()-50);
	}
	public void eatHumans() {
		System.out.println( "bueno, no importa");
		this.setEnergyLevel(this.getEnergyLevel()+50);
	}
	public void attackTown() {
		System.out.println("Juuuuu chiak chiak juuuuuuu(ciudad quemandose)");
		this.setEnergyLevel(this.getEnergyLevel()-100);
	}
	public Bat() {
		super(300);
		
	}
	

}
