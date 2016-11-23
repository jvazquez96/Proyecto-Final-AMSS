public class Vacante {
	private String Nombre;
	private String Descripcion;
	private String Contacto;
	
	public Vacante() {
		this.Nombre = "";
		this.Descripcion = "";
		this.Contacto = "";
	}

	public Vacante(String Nombre, String Descripcion, String Contacto) {
		this.Nombre = Nombre;
		this.Descripcion = Descripcion;
		this.Contacto = Contacto;
	}

	public String getNombre() {
		return this.Nombre;
	}
	
	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}	
	
	public String getDescripcion() {
		return this.Descripcion;
	}	

	public void setDescripcion(String Descripcion) {
		this.Descripcion = Descripcion;
	}

	public String getContacto() {
		return this.Contacto;
	}

	public void setContacto(String Contacto) {
		this.Contacto = Contacto;
	}
	

}
