package logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import datatypes.DtSocio;
import datatypes.DtUsuario;

@Entity
public class Socio extends Usuario{
	
	@OneToMany(mappedBy = "socio",cascade = CascadeType.ALL,orphanRemoval=true)
	private List<Registro> registros = new ArrayList<Registro>();
		
	public Socio(String nickname, String nombre, String apellido, String email, Calendar fechaNac) {
		super(nickname, nombre, apellido, email, fechaNac);
	}
	
	public Socio() {
		super();
	}
	
	public List<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}
	
	public void agregarRegistro(Registro registro) {
		registros.add(registro);
	}
	
	public boolean buscarRegistro(Clase clase) {
		boolean aretornar = false;
		for (Registro i: registros) {
			if(i.getClase().equals(clase)) {
				aretornar=true;
				return aretornar;
			}
		}
		return aretornar;
	}
	
	public ArrayList<String> obtenerClases(){
		ArrayList<String> arrayRetorno = new ArrayList<String>();
		for(Registro i: registros) {
			arrayRetorno.add(i.getClase().getNombre());
		}
		return arrayRetorno;
	}
	
	public void actualizarSocio(DtUsuario actualizado) {
		if (actualizado instanceof DtSocio) {
			this.setNombre(actualizado.getNombre());
			this.setApellido(actualizado.getApellido());
			this.setEmail(actualizado.getEmail());
			this.setFechaNac(actualizado.getFechaNac());
			this.setNickname(actualizado.getNickname());
		}
	}
	
	@Override
	public DtUsuario getDtUsuario() {
		return new DtSocio(this.getNickname(), this.getNombre(),this.getApellido(),this.getEmail(),this.getFechaNac());
	}
	
	public Clase buscarPorNombre(String nombre) {
		Clase c = new Clase();
		for (Registro i: registros) {
			if(i.getClase().getNombre().equals(nombre)) {
				c=i.getClase();
				return c;
			}
		}
		return c;
	}
}
