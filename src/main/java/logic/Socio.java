package logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import datatypes.DtClase;
import datatypes.DtSocio;
import datatypes.DtUsuario;

@Entity
public class Socio extends Usuario{
	
	@OneToMany(mappedBy = "socio",cascade = CascadeType.ALL,orphanRemoval=true)
	private List<Registro> registros = new ArrayList<Registro>();
	
	public Socio(String nickname, String nombre, String apellido, String email, Calendar fechaNac, String password ,String imagenURL) {
		super(nickname, nombre, apellido, email, fechaNac, password, imagenURL);
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
	
	public ArrayList<DtClase> obtenerDtClase(){
		ArrayList<DtClase> arrayRetorno = new ArrayList<DtClase>();
		for(Registro i: registros) {
			arrayRetorno.add(i.getClase().getDtClase());
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
			this.setPassword(actualizado.getPassword());
			this.setImagenURL(actualizado.getImagenURL());
		}
	}
	
	@Override
	public DtUsuario getDtUsuario() {
		return new DtSocio(this.getNickname(), this.getNombre(),this.getApellido(),this.getEmail(),this.getFechaNac(), this.getPassword(), this.getImagenURL());
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
	
	public void borrarRegistroSocio(Clase clase){
		int i = 0;
		Registro registro;
		boolean encontre=false;
		while ((i < registros.size() ) && (!encontre)) {
			registro=registros.get(i);
		    if (registro.getClase()==clase) {
		    	registros.remove(i);
		    	encontre=true;
		    }	
		    i++;
		}
	}
	
}
