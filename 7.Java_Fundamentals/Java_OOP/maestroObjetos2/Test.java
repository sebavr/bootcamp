package maestroObjetos2;

public class Test {

	public static void main(String[] args) {
		
		
		Wizard w=new Wizard();
		Wizard w2=new Wizard();
		Ninja n1=new Ninja();
		Samurai s1=new Samurai();
		
		n1.robar(w);
		n1.escape();
		w.bolaDeFuego(w2);
		w.curar();
		s1.golpeMortal(w);
		s1.meditar();
		s1.meditar();
		
	}

}
