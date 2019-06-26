package cl.model;

public class Cliente {

	private String nombre;
	private String apellido;
	private String rut;
	
	public String getRut() {
		return rut;
	}


	public void setRut(String rut) {
		this.rut = rut;
	}


	public Cliente(String nombre, String apellido, String rut) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido=" + apellido + " , rut=" + rut + " ]";
	}

	public void mensaje(){
		System.out.println("Hola Mundo");
	}
}
