package maestroObjetos2;
import maestroObjetos.*;

public class Wizard extends Human {
	
	

	public Wizard() {
		super();
		this.nombre="Wizard";
		this.strength = 3;
		this.stealth = 3;
		this.intelligence = 8;
		this.health=50;
	}
	
	public void bolaDeFuego(Human humanoAtacado) {
		humanoAtacado.setHealth(getHealth()-3*this.intelligence);
		System.out.println("El "+this.nombre+" 1 lanzo una bola de fuego al  "+humanoAtacado.getNombre()+"  ocasionandole : "+3*this.intelligence+" de daño");
		System.out.println("La salud del hombre golpeado es: "+humanoAtacado.getHealth());
	}
	
	public void curar() {
		this.setHealth(getHealth()+this.intelligence);
		System.out.println("El "+this.nombre+" se ha recuperado un total de  "+this.intelligence);
		System.out.println("La salud actual del "+this.nombre+" es de: "+this.getHealth());
	
	}
	
	
	
	
	

}