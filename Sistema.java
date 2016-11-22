import java.util.*;
import java.io.IOException;

public class Sistema {
	
	private static  ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();
	private static ReadFile file = new ReadFile("archivo.txt");
	public static void main (String[] args) {
		adminLoggin();
		/*
		try {
			readFile();
		} catch (IOException e) {	
			System.out.println(e.getMessage());
		}*/
	}
	
	private static void readFile() throws IOException {
		String file_name = "archivo.txt";
		try {	
			String[] aryLines = file.OpenFile();
		
			for (int i = 0; i < aryLines.length; ++i) {
				System.out.println(aryLines[i]);
			}
		} catch (IOException e) {
			System.out.println( e.getMessage() );
		}		
	}

	private static void writeFile(String Phrase) throws IOException {
		String file_name = "archivo.txt";
		try {
			file.WriteFile(Phrase);
		} catch (IOException e) {
			System.out.println(e.getMessage());
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
				System.out.println("Empezando registro..");
				registro();
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
	private static void registro() {
		System.out.println("¿Cuál es tu nombre?");
		Scanner in = new Scanner(System.in);
		String nombre;
		nombre = in.nextLine();
		System.out.println("¿Cuál es tu edad?");
		int edad =Integer.parseInt(System.console().readLine());
		System.out.println("¿Cuál es tu correo?");
		String correo = System.console().readLine();
		System.out.println("¿Cual es tu contraseña?");
		String contraseña = System.console().readLine();
		System.out.println("¿Qué tipo de usuario es usted? Primario(1)/Secundario(2)");
		String tipo = System.console().readLine();
		Usuario usuarioNuevo = new Usuario(nombre,edad,correo,contraseña,tipo);
		Usuarios.add(usuarioNuevo);
		System.out.println("Tamaño de lista: " + Usuarios.size());
		Usuario prueba = Usuarios.get(0);
		try {
			writeFile(nombre + " " + edad + " " + correo + " " + contraseña + " " + tipo);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
