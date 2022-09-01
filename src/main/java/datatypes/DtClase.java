package datatypes;

import java.util.Calendar;

public class DtClase {
	private String nombre;
	private Calendar fecha;
	private Integer horaInicio;
	private String url;
	private Calendar fechaReg;
	
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
	public DtClase(String nombre, Calendar fecha, int horaInicio, String url, Calendar fechaReg) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.url = url;
		this.fechaReg = fechaReg;
	}
	public DtClase() {}
	
	
}
