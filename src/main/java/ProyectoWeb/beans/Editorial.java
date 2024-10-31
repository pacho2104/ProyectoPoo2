package ProyectoWeb.beans;

public class Editorial {
	
	private int idLibro;
	private String nombre;
	private String contacto;
	private String telefono;
	
	
	public Editorial() {
		super();
	}
	public Editorial(int idLibro, String nombre, String contacto, String telefono) {
		super();
		this.idLibro = idLibro;
		this.nombre = nombre;
		this.contacto = contacto;
		this.telefono = telefono;
	}
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	

}
