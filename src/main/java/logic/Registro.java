package logic;

import java.util.Calendar;

public class Registro {
	private Calendar fechaReg;
	private Socio socio;
	private Clase clase;
	
	public Calendar getFechaReg() {
		return fechaReg;
	}
	public void setFechaReg(Calendar fechaReg) {
		this.fechaReg = fechaReg;
	}
	public Socio getSocio() {
		return socio;
	}
	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	public Clase getClase() {
		return clase;
	}
	public void setClase(Clase clase) {
		this.clase = clase;
	}
	public Registro(Calendar fechaReg, Socio socio, Clase clase) {
		super();
		this.fechaReg = fechaReg;
		this.socio = socio;
		this.clase = clase;
	}
	public Registro() {
		super();
	}
	
	
	
}
