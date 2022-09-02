package logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import datatypes.DtActividadDeportiva;

public class ActividadDeportiva {
	private String nombre;
	private String descripcion; 
	private Integer duracion;
	private Float costo;
	private Calendar fechaReg;
	private List<Clase> clases = new ArrayList<Clase>();
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getDuracion() {
		return duracion;
	}
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	public Float getCosto() {
		return costo;
	}
	public void setCosto(Float costo) {
		this.costo = costo;
	}
	public Calendar getFechaReg() {
		return fechaReg;
	}
	public void setFechaReg(Calendar fechaReg) {
		this.fechaReg = fechaReg;
	}
	public List<Clase> getClases() {
		return clases;
	}
	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}
	public ActividadDeportiva(String nombre, String descripcion, Integer duracion, Float costo, Calendar fechaReg) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.costo = costo;
		this.fechaReg = fechaReg;
	}
	public ActividadDeportiva() {
		super();
	}
	
	public boolean existeClase(String nombreClase) {
		boolean retorno = false;
		for(Clase i: clases) {
			if(i.getNombre().equals(nombreClase))
				retorno = true;
		}
		return retorno;
	}
	
	public void agregarClase(Clase clase) {
		clases.add(clase);
	}
	
	public DtActividadDeportiva obtenerDt() {
		return new DtActividadDeportiva(this.getNombre(),this.getDescripcion(), this.getDuracion(), this.getCosto(), this.getFechaReg());
	}
	
	
	public ArrayList<String> listarClases() {
		ArrayList<String> retorno = new ArrayList<String>();
		for(Clase i: clases) {
			retorno.add(i.getNombre());
		}
		return retorno;
	}

	public Clase buscarClase(String nombreClase) {
		Clase claseRetorno = null;
		for(Clase i: clases) {
			if(i.getNombre().equals(nombreClase)) {
				claseRetorno = i;
			}
		}
		return claseRetorno;
	}
}
