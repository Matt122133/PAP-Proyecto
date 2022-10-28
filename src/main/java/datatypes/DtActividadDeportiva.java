package datatypes;

import java.util.Calendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class DtActividadDeportiva {
	private String nombre;
	private String descripcion;
	private Integer duracion;
	private Float costo;
	private Calendar fechaReg;
	private String imagenActURL;
	
	//private List<Clase> clases = new ArrayList<Clase>();
	
	
	public DtActividadDeportiva(String nombre, String descripcion, Integer duracion, Float costo, Calendar fechaReg,
			String imagenActURL/*, List<Clase> clases*/) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.costo = costo;
		this.fechaReg = fechaReg;
		this.imagenActURL = imagenActURL;
		//this.clases = clases;
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
	
	/*public List<Clase> getClases() {
		return clases;
	}*/

	@Override
	public String toString() {
		return "DtActividadDeportiva [nombre=" + nombre + ", descripcion=" + descripcion + ", duracion=" + duracion
				+ ", costo=" + costo + ", fechaReg=" + fechaReg + "]";
	}
	
	
}
