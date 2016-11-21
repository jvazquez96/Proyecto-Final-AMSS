public class Usuario {

	private String Nombre;
	private int Edad;
	// private Curriculum File //TODO: Implementación de una clase archivo
	private String Correo_Electronico;
	private String Contraseña;
	private String Tipo;
	 
	public Usuario() {
		this.Nombre = "";
		this.Edad = 0;
		this.Correo_Electronico = "";
		this.Contraseña = "";
		this.Tipo = "";
	}

	public Usuario(String Nombre, int Edad, String CE, String Cont, String Tipo) {
		this.Nombre = Nombre;
		this.Edad = Edad;
		this.Correo_Electronico = CE;
		this.Contraseña = Cont;	
		this.Tipo = Tipo;
	}

	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;	
	}
	
	public int getEdad() {
		return this.Edad;
	}

	public void setEdad(int Edad) {
		this.Edad = Edad;
	}
	
	public String getCorreoElectronico() {
		return this.Correo_Electronico;
	}

	public void setCorreoElectronico(String Correo_Electronico) {
		this.Correo_Electronico = Correo_Electronico;
	}

	public String getContraseña() {
		return this.Contraseña;
	}

	public void setContraseña(String contraseña) {
		this.Contraseña = contraseña;
	}

	public String getTipo() {
		return this.Tipo;
	}

	public void setTipo(String Tipo) {
		this.Tipo = Tipo; 
	}

}
