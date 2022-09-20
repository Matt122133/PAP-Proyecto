package datatypes;

import java.util.Calendar;

public class DtActividadDeportiva {
	private String nombre;
	private String descripcion;
	private Integer duracion;
	private Float costo;
	private Calendar fechaReg;
	private String imagenActURL;
	
	
	
	public DtActividadDeportiva(String nombre, String descripcion, Integer duracion, Float costo, Calendar fechaReg, String imagenActURL) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.costo = costo;
		this.fechaReg = fechaReg;
		this.imagenActURL = imagenActURL;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public Float getCosto() {
		return costo;
	}

	public Calendar getFechaReg() {
		return fechaReg;
	}

	public String getImagenActURL() {
		return imagenActURL;
	}

	@Override
	public String toString() {
		return "DtActividadDeportiva [nombre=" + nombre + ", descripcion=" + descripcion + ", duracion=" + duracion
				+ ", costo=" + costo + ", fechaReg=" + fechaReg + "]";
	}
	
	
}
