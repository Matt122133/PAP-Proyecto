package datatypes;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtClase {
	private String nombre;
	private Calendar fecha;
	private Integer horaInicio;
	private String url;
	private Calendar fechaReg;
	private String imagenClaseURL;
	
	//private List<Registro> registros = new ArrayList<Registro>();
	
	public String getNombre() {
		return nombre;
	}
	
	public Calendar getFecha() {
		return fecha;
	}
	
	public Integer getHoraInicio() {
		return horaInicio;
	}
	
	public String getUrl() {
		return url;
	}
	
	public Calendar getFechaReg() {
		return fechaReg;
	}
	
	public String getImagenClaseURL() {
		return imagenClaseURL;
	}

	/*public List<Registro> getRegistros() {
		return registros;
	}*/
	
	
	public DtClase(String nombre, Calendar fecha, Integer horaInicio, String url, Calendar fechaReg, String imagenClaseURL/*, List<Registro> registros*/) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.url = url;
		this.fechaReg = fechaReg;
		this.imagenClaseURL = imagenClaseURL;
		//this.registros = registros;
	}

	public DtClase() {
		super();
	}
	
	
}