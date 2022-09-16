package logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import datatypes.DtClase;

@Entity
public class Clase {
	
	@Id
	private String nombre;
	private Calendar fecha;
	private Integer horaInicio;
	private String url;
	private Calendar fechaReg;
	
	@OneToMany(mappedBy = "clase",cascade = CascadeType.ALL,orphanRemoval=true)
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
	
	public boolean socioEstaRegistrado(String socio) {
		int i = 0;
		Registro registro;
		boolean encontre=false;
		while ((i < registros.size()) && (!encontre)) {
			registro=registros.get(i);
		    if (registro.getNicknameSocio().equals(socio)) {
		    	encontre=true;
		    }	
		    i++;
		}
		return encontre;
	}
	
	public void borrarRegistroClase(Socio socio){
		System.out.println(registros.size());
		int i = 0;
		Registro registro;
		boolean encontre=false;
		while ((i < registros.size()) && (!encontre)) {
			registro=registros.get(i);
		    if (registro.getSocio().equals(socio)) {
		    	registros.remove(i);
		    	encontre=true;
		    }	
		    i++;
		}
		
		System.out.println(registros.size());
		System.out.println(socio.getRegistros().size());
		socio.borrarRegistroSocio(this);
		System.out.println(socio.getRegistros().size());
	}
	
	
	
	
}
