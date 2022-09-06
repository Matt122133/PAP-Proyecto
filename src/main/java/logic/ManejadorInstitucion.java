package logic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;


public class ManejadorInstitucion {
	private static ManejadorInstitucion instancia = null;
	
	public static ManejadorInstitucion getInstancia() {
		if(instancia == null)
			instancia = new ManejadorInstitucion();
		return instancia;
	}
	
	public void agregarInstitucion(InstitucionDeportiva institucion) {
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM= conexion.getEntityManager();
		eM.getTransaction().begin();
		eM.persist(institucion);
		eM.getTransaction().commit();
		
	}
	
	public InstitucionDeportiva buscarInstitucion(String nombre) {
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM= conexion.getEntityManager();
		
		InstitucionDeportiva institucion = eM.find(InstitucionDeportiva.class, nombre);
		return institucion;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> obtenerInstituciones(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM= conexion.getEntityManager();
		
		Query query = eM.createQuery("select i from InstitucionDeportiva i");
		List<InstitucionDeportiva> instituciones = (List<InstitucionDeportiva>) query.getResultList();
		
		ArrayList<String> aRetornar = new ArrayList<String>();
		for(InstitucionDeportiva i: instituciones) {
			aRetornar.add(i.getNombre());
		}
		return aRetornar;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<InstitucionDeportiva> obtenerInstis(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM= conexion.getEntityManager();
		
		Query query = eM.createQuery("select i from InstitucionDeportiva i");
		List<InstitucionDeportiva> instituciones = (List<InstitucionDeportiva>) query.getResultList();
		
		ArrayList<InstitucionDeportiva> aRetornar = new ArrayList<InstitucionDeportiva>();
		for(InstitucionDeportiva i: instituciones) {
			aRetornar.add(i);
		}
		return aRetornar;
	}
}
