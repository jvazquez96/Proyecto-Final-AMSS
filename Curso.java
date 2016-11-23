import java.util.*;

public class Curso {

	private String Nombre;
	private Date FechaInicio;
	private Date FechaTermino;
	private String Tema;
	private ArrayList<String> Skills;

	public Curso() {
		this.Nombre = "";
		this.FechaInicio = new  Date();
		this.FechaTermino = new Date();
		this.Tema = "";
		this.Skills = new ArrayList<String>();
	}

	public Curso(String Nombre,Date FechaInicio, Date FechaTermino, ArrayList<String> Skills) {
		this.Nombre = Nombre;
		this.FechaInicio = FechaInicio;
		this.FechaTermino = FechaTermino;
		this.Skills = Skills;
	}

	public String getNombre() {
		return this.Nombre;	
	}		 
	
	public void setNombre(String Nombre) {
		this.Nombre = Nombre;	
	}

	public Date getFechaInicio() {
		return this.FechaInicio;
	}

	public void setFechaInicio(Date FechaInicio) {
		this.FechaInicio = FechaInicio;
	}

	public Date getFechaTermino() {
		return this.FechaTermino;
	}

	public void setFechaTermino(Date FechaTermino) {
		this.FechaTermino = FechaTermino;
	}

	public ArrayList<String> getSkills() {
		return this.Skills;
	}

	public void setSkills(ArrayList<String> Skills) {
		this.Skills = Skills;
	}



}
