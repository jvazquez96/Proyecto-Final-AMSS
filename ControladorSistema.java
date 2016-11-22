import java.io.IOException;
import java.util.*;

public class ControladorSistema {

	private ReadFile file = new ReadFile("archivo.txt");

	private String[] readFile() {
		try {
			String [] aryLines = this.file.OpenFile();
			for (int i = 0; i < aryLines.length; ++i) {
				//System.out.println(aryLines[i]);
			}
			return aryLines;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}	
	
	private void writeFile(String Phrase) {
		try {
			this.file.WriteFile(Phrase);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}		

	
	public Usuario registro(String nombre, int edad, String correo, String contraseña, String tipo) {
		Usuario nuevoUsuario = new Usuario(nombre,edad,correo,contraseña,tipo);
		if (!this.usuarioExistente(nuevoUsuario)){
			writeFile(nombre + " " + edad + " " + correo + " " + contraseña + " " + tipo+"\n");
			return nuevoUsuario;
		} 
		return null;
	}

	public ArrayList<Usuario> getUsuarios() {
		ArrayList<Usuario> listOfUsers = new ArrayList<Usuario>();
		String [] splittedString;
		String nombre, correo, contraseña, tipo;
		int edad;
		String [] data = this.readFile();
		for (int i = 0; i < data.length; ++i) {
			Usuario nuevo = new Usuario();
			splittedString = data[i].split(" ");
			nombre = splittedString[0];
			edad = Integer.parseInt(splittedString[1]);
			correo = splittedString[2];
			contraseña = splittedString[3];	
			tipo = splittedString[4];
			nuevo.setNombre(nombre);
			nuevo.setEdad(edad);
			nuevo.setCorreoElectronico(correo);
			nuevo.setContraseña(contraseña);
			nuevo.setTipo(tipo);
			listOfUsers.add(nuevo);
		}
		return listOfUsers;
	}	
	
	public Usuario getUsuario(String Usuario, String Contraseña) {
		String nombre, correo, contraseña, tipo;
		int edad;
		String [] data = this.readFile();
		String [] splittedString;
		for (int i = 0; i < data.length; ++i) {
			Usuario nuevo = new Usuario();
			splittedString = data[i].split(" ");
			nombre = splittedString[0];
			edad = Integer.parseInt(splittedString[1]);
			correo = splittedString[2];
			contraseña = splittedString[3];	
			tipo = splittedString[4];
			nuevo.setNombre(nombre);
			nuevo.setEdad(edad);
			nuevo.setCorreoElectronico(correo);
			nuevo.setContraseña(contraseña);
			nuevo.setTipo(tipo);
			if (Usuario.equals(correo) && Contraseña.equals(contraseña)) {
				return nuevo;
			}	
		}
		return null;	
	}
	
	public boolean usuarioExistente(Usuario usuario) {
		String correoElectronico = usuario.getCorreoElectronico();
		String contraseña = usuario.getContraseña();
		String []  splittedString;
		String nombre, correo, contra, tipo;
		int edad;
		String []  data = null;
		data = this.readFile();
		for (int i = 0; i < data.length; ++i) {
			splittedString = data[i].split(" ");
			nombre = splittedString[0];
			edad = Integer.parseInt(splittedString[1]);
			correo = splittedString[2];
			contra = splittedString[3];
			tipo = splittedString[4];
			if (usuario.getCorreoElectronico().equals(correo) && usuario.getContraseña().equals(contra)) {
				return true;
			}
		}
		return false;
	}
	
	

}
