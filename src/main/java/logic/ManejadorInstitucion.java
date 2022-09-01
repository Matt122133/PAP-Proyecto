package logic;

import java.util.ArrayList;
import java.util.List;


public class ManejadorInstitucion {
	private static ManejadorInstitucion instancia = null;
	private List<InstitucionDeportiva> instituciones = new ArrayList<InstitucionDeportiva>();
	
	public static ManejadorInstitucion getInstancia() {
		if(instancia == null)
			instancia = new ManejadorInstitucion();
		return instancia;
	}
	
	public void agregarInstitucion(InstitucionDeportiva institucion) {
		instituciones.add(institucion);
	}
	
	public InstitucionDeportiva buscarInstitucion(String nombre) {
		InstitucionDeportiva retorno = null;
		for(InstitucionDeportiva i: instituciones) {
			if(i.getNombre().equals(nombre))
				retorno = i;
		}
		return retorno;
	}
	
	public ArrayList<String> obtenerInstituciones(){
		ArrayList<String> aRetornar = new ArrayList<String>();
		for(InstitucionDeportiva i: instituciones) {
			aRetornar.add(i.getNombre());
		}
		return aRetornar;
	}
	
	public ArrayList<InstitucionDeportiva> obtenerInstis(){
		ArrayList<InstitucionDeportiva> aRetornar = new ArrayList<InstitucionDeportiva>();
		for(InstitucionDeportiva i: instituciones) {
			aRetornar.add(i);
		}
		return aRetornar;
	}
}
