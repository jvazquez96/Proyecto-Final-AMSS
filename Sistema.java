import java.util.*;
import java.io.IOException;

public class Sistema {
	
	private static  ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();
	private static ControladorSistema ContrSistema = new ControladorSistema();	
	private static Usuario mainUsuario = new Usuario();	
	
	public static void main (String[] args) {
		readUsers();
		adminLoggin();		
	}
	
	
	private static void readUsers() {
		Usuarios = ContrSistema.getUsuarios();
	}

	private static void showMenu() {
		System.out.println("Bienvenido " + mainUsuario.getNombre());
		if (mainUsuario.getTipo().equals("2")) {
			System.out.println("¿Qué deseas hacer?");
			System.out.println("Introduce el numero de la opción");
			System.out.println("1. Dar de alta un curso");
			System.out.println("2. Dar de alta una vacante");
			String input = System.console().readLine();
		}
	}		
	
	private static void getMainUsuario(String Correo, String Contraseña) {
		mainUsuario = ContrSistema.getUsuario(Correo,Contraseña);
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
		Usuario usuarioCheck = new Usuario();
		usuarioCheck.setCorreoElectronico(usuario);
		usuarioCheck.setContraseña(contraseña);
		if (usuario.equals("usuario") && contraseña.equals("contraseña")) {
			System.out.println("Admin logged in");
			showMenu();
		} else if (verify(usuarioCheck)) {
			System.out.println("User logged in");
			getMainUsuario(usuario,contraseña);
			showMenu();
		} else {
			System.out.println("Asegurese de tener una cuenta o si desea registre una nueva cuenta");
			System.out.println("¿Desea registrar una nueva cuenta? Y/N");
			String answer = System.console().readLine();
			if (answer.equals("Y")) {
				System.out.println("Empezando registro..");
				registro();
			} else {
				System.out.println("Autentificación de usuario falló :( Si deseas salir escribe la letra E ");
				System.out.println("Usuario");
				usuario = System.console().readLine();
				if (usuario.equals("E")) {
					System.exit(0);
				}
				System.out.println("Contraseña");
				contraseña = System.console().readLine();
				usuarioCheck.setCorreoElectronico(usuario);
				usuarioCheck.setContraseña(contraseña);
				while (!verify(usuarioCheck)) {
					System.out.println("Autentificación de usuario falló :( Si deseas salir escribe la letra E");
					System.out.println("Usuario");
					usuario = System.console().readLine();
					if (usuario.equals("E")) {
						System.exit(0);
					}
					System.out.println("Contraseña");
					contraseña = System.console().readLine();
					usuarioCheck.setCorreoElectronico(usuario);
					usuarioCheck.setContraseña(contraseña);
				} 
				System.out.println("User logged in");
				getMainUsuario(usuario,contraseña);
			}
		}	
	}


	private static boolean verify (Usuario usuarioVerificar) {
		return ContrSistema.usuarioExistente(usuarioVerificar);
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
		Usuario nuevoUsuario = ContrSistema.registro(nombre,edad,correo,contraseña,tipo);
		if (nuevoUsuario != null) {
			System.out.println("Nuevo Usuario");
			Usuarios.add(nuevoUsuario);
			mainUsuario = nuevoUsuario;
			showMenu();
		}				
	}
}
