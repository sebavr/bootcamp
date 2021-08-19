package GuardiaZoo;

public class Gorilla extends Mammal {
	
	public void throwSomething() {
		System.out.println("Lanzando cosas a la gente...");
		this.setEnergyLevel(getEnergyLevel()-5);
		
		
	}
	public void eatBananas() {
		System.out.println("Comiendo bananas...");
		this.setEnergyLevel(getEnergyLevel()+10);
	}
	public void climb() {
		System.out.println("Escalando...");
		this.setEnergyLevel(getEnergyLevel()-10);
		
	}

}
