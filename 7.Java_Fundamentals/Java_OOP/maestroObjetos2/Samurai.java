package maestroObjetos2;
import maestroObjetos.*;

public class Samurai extends Human {
	
	public Samurai() {
		super();
		this.nombre="Samurai";
		this.strength = 3;
		this.stealth = 3;
		this.intelligence = 3;
		this.health=200;
	}
	
	
	public void golpeMortal(Human humanoAtacado) {
		humanoAtacado.setHealth(getHealth()-getHealth());
		System.out.println("El "+this.nombre+" redujo la vida del "+humanoAtacado.getNombre()+" a 0");
		this.setHealth(getHealth()/2);
		System.out.println("Sin embargo, su salud se ha reducido a la mitad. Ahora es :"+this.getHealth());
	}
	
	
	public void meditar() {
		this.setHealth(getHealth()*3/2);
		System.out.println("El "+this.nombre+" se ha curado :"+this.getHealth()*1/3);
		System.out.println(" Su salud  Ahora es :"+this.getHealth());
		
		
		
		
	}

}