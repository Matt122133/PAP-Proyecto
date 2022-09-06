package logic;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

import persistencia.RegistroID;

@Entity
@IdClass(persistencia.RegistroID.class)
public class Registro {
	
	@Id
	@ManyToOne
	private Socio socio;
	
	@Id
	@ManyToOne
	private Clase clase;
	
	private Calendar fechaReg;
	
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
