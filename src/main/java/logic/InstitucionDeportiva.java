package logic;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtActividadDeportiva;

public class InstitucionDeportiva {
	private String nombre;
	private String descripcion;
	private String url;
	private List<ActividadDeportiva> actDeportivas = new ArrayList<ActividadDeportiva>();
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<ActividadDeportiva> getActDeportivas() {
		return actDeportivas;
	}

	public InstitucionDeportiva(String nombre, String descripcion, String url) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
	}
	public InstitucionDeportiva() {
		super();
	}
	
	public void agregarActividadDeportiva(ActividadDeportiva actDep) {
		actDeportivas.add(actDep);
	}
	
	public ActividadDeportiva buscarActividadDeportiva(String nombre) {
		ActividadDeportiva retorno = null;
		for(ActividadDeportiva i: actDeportivas) {
			if(i.getNombre().equals(nombre))
				retorno = i;
		}
		return retorno;
	}
	
	public boolean tengoActDep(String nombre) {
		for(ActividadDeportiva i: actDeportivas) {
			if(i.getNombre().equals(nombre))
			return true;
		}
		return false;
	}
	
	public ArrayList<String> listarActividadesDeportivas() {
		ArrayList<String> retorno = new ArrayList<String>();
		for(ActividadDeportiva i: actDeportivas) {
				retorno.add(i.getNombre());
		}
		return retorno;
	}
	
	public DtActividadDeportiva obtenerDtActDep(String actividad) {
		ActividadDeportiva encontrada = buscarActividadDeportiva(actividad);
		return encontrada.obtenerDt();
	}

}
