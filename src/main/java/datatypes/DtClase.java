package datatypes;

import java.util.Calendar;

public class DtClase {
	private String nombre;
	private Calendar fecha;
	private Integer horaInicio;
	private String url;
	private Calendar fechaReg;
	private byte[] imagenClase;
	
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
	
	public byte[] getImagenClase() {
		return imagenClase;
	}

	
	
	public DtClase(String nombre, Calendar fecha, Integer horaInicio, String url, Calendar fechaReg,
			byte[] imagenClase) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.url = url;
		this.fechaReg = fechaReg;
		this.imagenClase = imagenClase;
	}

	public DtClase() {}
	
	
}
