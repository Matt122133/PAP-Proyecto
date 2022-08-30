package datatypes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import logic.Clase;

public class DtProfesor extends DtUsuario{
	private String descripcion;
	private String biografia;
	private String sitioWeb;
	private String instDep;
	private List<Clase> clases = new ArrayList<Clase>();
	
	public DtProfesor(String nickname, String nombre, String apellido, String email, Calendar fechaNac, String descripcion, String biografia, String sitioWeb, String instDep) {
		super(nickname, nombre, apellido, email, fechaNac);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioWeb = sitioWeb;
		this.instDep = instDep;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public String getBiografia() {
		return biografia;
	}
	public String getSitioWeb() {
		return sitioWeb;
	}
	public String getInstDep() {
		return instDep;
	}
	public List<Clase> getClases() {
		return clases;
	}
	
	
}
