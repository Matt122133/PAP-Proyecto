package logic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Query;

import datatypes.DtActividadDeportiva;
import persistencia.Conexion;

@Entity
public class InstitucionDeportiva {
	@Id
	private String nombre;
	private String descripcion;
	private String url;
	@OneToMany(cascade = CascadeType.ALL)
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
	
	@SuppressWarnings("unchecked")
	public ActividadDeportiva tengoActDep(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM= conexion.getEntityManager();
		
		Query query = eM.createQuery("select a from ActividadDeportiva a");
		List<ActividadDeportiva> actDeportivas = (List<ActividadDeportiva>) query.getResultList();
		
		ActividadDeportiva actDep = null;
		for(ActividadDeportiva i: actDeportivas) {
			if(i.getNombre().equals(nombre))
			actDep = i;
		}
		return actDep;
	}
	
	public ArrayList<String> listarActividadesDeportivas() {
		ArrayList<String> retorno = new ArrayList<String>();
		for(ActividadDeportiva i: actDeportivas) {
				retorno.add(i.getNombre());
		}
		return retorno;
	}
	
	public ArrayList<ActividadDeportiva> listarAct(){
		ArrayList<ActividadDeportiva> retorno = new ArrayList<ActividadDeportiva>();
		for(ActividadDeportiva i: actDeportivas) {
			retorno.add(i);
	}
		return retorno;
	}
	
	public ArrayList<DtActividadDeportiva> listarDtActDeportiva(){
		ArrayList<DtActividadDeportiva> retorno = new ArrayList<DtActividadDeportiva>();
		for(ActividadDeportiva i: actDeportivas) {
			retorno.add(i.obtenerDt());
		}
		return retorno;
	}
	
	public DtActividadDeportiva obtenerDtActDep(String actividad) {
		ActividadDeportiva encontrada = buscarActividadDeportiva(actividad);
		return encontrada.obtenerDt();
	}

}
