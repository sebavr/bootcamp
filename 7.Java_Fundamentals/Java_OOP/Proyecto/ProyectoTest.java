package Proyecto;

public class ProyectoTest {

	public static void main(String[] args) {
		
		Proyecto p1=new Proyecto();
		p1.setNombre("Instalacion red electrica");
		p1.setDescripcion("Se instalará una red electrica por toda la cuadra");
		p1.setCostoInicial(1000.0);
		System.out.println(p1.elevatorPitch());
		
		Proyecto p2=new Proyecto();
		p2.setNombre("Parque");
		p2.setDescripcion("Parque de 50 m2 para el barrio Los leones");
		p2.setCostoInicial(4000.0);
		System.out.println(p2.elevatorPitch());
	}

}
