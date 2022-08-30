package logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import datatypes.DtClase;

public class Clase {
	private String nombre;
	private Calendar fecha;
	private Integer horaInicio;
	private String url;
	private Calendar fechaReg;
	private List<Registro> registros = new ArrayList<Registro>();
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	public Integer getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Calendar getFechaReg() {
		return fechaReg;
	}
	public void setFechaReg(Calendar fechaReg) {
		this.fechaReg = fechaReg;
	}
	public List<Registro> getRegistros() {
		return registros;
	}
	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}
	public Clase(String nombre, Calendar fecha, int horaInicio, String url, Calendar fechaReg) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.url = url;
		this.fechaReg = fechaReg;
	}
	public Clase() {
		super();
	}

	public DtClase getDtClase() {
		return new DtClase(this.getNombre(), this.getFecha(), this.getHoraInicio(), this.getUrl(), this.getFechaReg());
	}
	
	public void agregarRegistro(Registro registro) {
		registros.add(registro);
	}
}
