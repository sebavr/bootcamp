package maestroObjetos2;
import maestroObjetos.*;

public class Ninja extends Human {
	
	public Ninja() {
		super();
		this.nombre="Ninja";
		this.strength = 3;
		this.stealth = 10;
		this.intelligence = 3;
		this.health=100;
	}
	
	public void robar(Human humanoAtacado) {
		humanoAtacado.setHealth(getHealth()-this.stealth);
		this.setHealth(getHealth()+this.stealth);
		System.out.println("El "+this.nombre+" 1 robo salud al  "+humanoAtacado.getNombre()+"  ocasionandole : "+this.stealth+" de daño");
		System.out.println("La salud del "+this.nombre+" se recuperó en: "+this.stealth+", su salud ahora es "+this.health);
		System.out.println("La salud del hombre golpeado es: "+humanoAtacado.getHealth());
	}
	
	public void escape() {
		System.out.println("El "+this.nombre+" se escapo. Su salud es "+this.getHealth());
	}
	

}
