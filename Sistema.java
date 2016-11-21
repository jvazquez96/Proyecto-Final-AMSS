import java.util.*;
import java.io.IOException;


public class Sistema {
	
	private ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();

	public static void main (String[] args) {
		//adminLoggin();
		try {
			readFile();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void readFile() throws IOException {
		String file_name = "archivo.txt";
		try {	
			ReadFile file = new ReadFile(file_name);
			String[] aryLines = file.OpenFile();
		
			for (int i = 0; i < aryLines.length; ++i) {
				System.out.println(aryLines[i]);
			}
		} catch (IOException e) {
			System.out.println( e.getMessage() );
		}		
	}
	
	private static void adminLoggin() {
		System.out.println("Usuario");
		String usuario = System.console().readLine();
		System.out.println("Contraseña");
		String contraseña = System.console().readLine();
		if (usuario.equals("admin") && contraseña.equals("admin")) {
			System.out.println("¡Bienvenido!");
		} else {
			userLoggin(usuario,contraseña);	
		}
	}
	
	private static void userLoggin(String usuario, String contraseña) {
		if (usuario.equals("usuario") && contraseña.equals("contraseña")) {
			System.out.println("User logged in");
		} else {
			System.out.println("Asegurese de tener una cuenta o si desea registre una nueva cuenta");
			System.out.println("¿Desea registrar una nueva cuenta? Y/N");
			String answer = System.console().readLine();
			if (answer.equals("Y")) {
				//TODO(jorge): Implementar registro
				System.out.println("Registrandose..");
			} else {
				//TODO(jorge): Implemtar función para verificar con registro
				System.out.println("Autentificación de usuario falló :(");
				while (true) {
					System.out.println("Usuario");
					usuario = System.console().readLine();
					System.out.println("Contraseña");
					contraseña = System.console().readLine();
				}	
			}
		}	
	}
}
