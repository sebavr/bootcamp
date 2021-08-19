package Proyecto;

public class Proyecto {

	String nombre;
	String descripcion;
	Double costoInicial;
	
	public Double getCostoInicial() {
		return costoInicial;
	}

	public void setCostoInicial(Double costoInicial) {
		this.costoInicial = costoInicial;
	}

	public String elevatorPitch() {
		return nombre+"( "+costoInicial+" )"+ " : " +descripcion;
	}

	public Proyecto() {
	}
	
	public Proyecto(String nombre) {
	}
	public Proyecto(String nombre,String descripcion) {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	
	
	

}
