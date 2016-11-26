import java.util.*;
import java.io.IOException;

public class Sistema {

    private static  ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();
    private static ControladorSistema ContrSistema = new ControladorSistema();
    private static Usuario mainUsuario = new Usuario();
    private static ArrayList<Curso> Cursos= new ArrayList<Curso>();
    private static ArrayList<Vacante> Vacantes= new ArrayList<Vacante>();
    public static void main (String[] args) {
      mainUsuario = new Usuario("admin", 20, "admin@admin.com", "admin", "2");
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
	    System.out.println("4. Ver cursos");
            System.out.println("5. Log-out");
            String input = System.console().readLine();
            if (input.equals("1")) {
                darAltaCurso();
            } else if (input.equals("2")) {
                darAltaVacante();
            } else if (input.equals("5")) {
                adminLoggin();
            } else if (input.equals("4")) {
	   	showCursos(); 
	   }
        }
    }

    private static void showCursos() {
    	for (int i = 0; i < Cursos.size(); ++i) {
		Curso curso = new Curso();
		curso = Cursos.get(i);
		System.out.println("Nombre: " + curso.getNombre());		
	}
	showMenu();
    }

    private static void showVacantes() {
    	for (int i = 0; i < Vacantes.size(); ++i) {
		Vacante vacante = new Vacante();
		vacante = Vacantes.get(i);
		System.out.println("Nombre: " + vacante.getNombre());
	}
	showMenu();	
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
            showMenu();
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
		showMenu();
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

   

    private static void darAltaCurso() {
        String nombre;
        Date FechaInicio;
        Date FechaTermino;
        String Tema;
        ArrayList<String> Skills = new ArrayList<String>();

        String resp = null;
        String skill= null;


        System.out.println("¿Cuál es el nombre del curso?");
        Scanner in = new Scanner(System.in);
        nombre = in.nextLine();
        if(!Cursos.isEmpty() && ContrSistema.verificarCurso(nombre, Cursos)){
                System.out.println("El curso ya existe");
            showMenu();
        }else{
            System.out.println("¿Cuál es el año en el que se llevará acabo el curso?");
            int ano =Integer.parseInt(System.console().readLine());
            System.out.println("¿Cuál es el mes en el que se llevará acabo el curso? (Numero ej. Diciembre = 12)");
            int mes =Integer.parseInt(System.console().readLine());
            System.out.println("¿Cuál es el día en el que se llevará acabo el curso?");
            int dia =Integer.parseInt(System.console().readLine());
            System.out.println("¿Cuál es la hora en la que iniciará el curso?");
            int hra =Integer.parseInt(System.console().readLine());
            FechaInicio = new Date(ano,mes,dia,hra,0);
            System.out.println("¿Cuál es la hora en la que terminará el curso?");
            hra =Integer.parseInt(System.console().readLine());
            FechaTermino = new Date(ano,mes,dia,hra,0);
            System.out.println("¿Cual es el tema?");
            Tema = System.console().readLine();
            System.out.println("¿Desea agregar skills? (si/no)");
            resp =System.console().readLine();
            while (resp.equals("si")){
                System.out.println("introduzca el skill");
                //skill =System.console().readLine();
                skill = in.nextLine();
                Skills.add(skill);
                System.out.println("¿Desea agregar otro skill? (si/no)");
                resp =System.console().readLine();
            }
            Curso curso = new Curso(nombre,FechaInicio,FechaTermino, Skills);
            Cursos.add(curso);
            System.out.println("Curso agregado correctamente");
            showMenu();
        }

    }

    private static void darAltaVacante() {
        String nombre;
        String Descripcion;
        String Contacto;

        System.out.println("¿Cuál es el nombre de la vacante?");
        Scanner in = new Scanner(System.in);
        nombre = in.nextLine();
        System.out.println("¿Cual es la descripción?");
        Descripcion = System.console().readLine();
        if(!Vacantes.isEmpty() && ContrSistema.verificarVacante(Descripcion, Vacantes)){
            System.out.println("La vacante ya se dio de alta anteriormente");
            showMenu();
        } else{
            System.out.println("¿Cual es el contacto?");
            Contacto = System.console().readLine();
            Vacante vacante = new Vacante(nombre,Descripcion,Contacto);
            Vacantes.add(vacante);
            System.out.println("Vacante agregada correctamente");
            showMenu();
        }

    }
}
