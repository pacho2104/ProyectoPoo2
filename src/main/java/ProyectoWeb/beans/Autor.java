package ProyectoWeb.beans;

public class Autor {
	
	
	private int idAutor;
	private String nacionalidad;
	private String nombre;
	
	
	public int getIdAutor() {
		return idAutor;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Autor(int idAutor, String nacionalidad, String nombre) {
		super();
		this.idAutor = idAutor;
		this.nacionalidad = nacionalidad;
		this.nombre = nombre;
	}
	
	
	
	
	

}
