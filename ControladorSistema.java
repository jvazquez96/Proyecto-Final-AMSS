import java.io.IOException;

public class ControladorSistema {

	private ReadFile file = new ReadFile("archivo.txt");

	public void readFile() throws IOException {
		try {
			String [] aryLines = this.file.OpenFile();
			for (int i = 0; i < aryLines.length; ++i) {
				System.out.println(aryLines[i]);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}	
	
	public void writeFile(String Phrase) {
		try {
			this.file.WriteFile(Phrase);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}		

	
	public Usuario registro(String nombre, int edad, String correo, String contraseña, String tipo) {
		Usuario nuevoUsuario = new Usuario(nombre,edad,correo,contraseña,tipo);
		writeFile(nombre + " " + edad + " " + correo + " " + contraseña + " " + tipo);
		return nuevoUsuario;
	}

}
