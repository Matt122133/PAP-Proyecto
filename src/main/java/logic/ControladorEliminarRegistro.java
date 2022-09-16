package logic;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import datatypes.DtClase;
import exceptions.SocioNoRegistrado;
import interfaces.IControladorEliminarRegistro;
import persistencia.Conexion;

public class ControladorEliminarRegistro implements IControladorEliminarRegistro {
	
	public String[] listarInstituciones() {
		ArrayList<String> instituciones;
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		instituciones = mI.obtenerInstituciones();
		String[] instituciones_ret = new String[instituciones.size()];
        int a=0;
        for(String i:instituciones) {
        	instituciones_ret[a]=i;
        	a++;
        }
        return instituciones_ret;
	}
	
	public String[] listarActividades(String nombreInsti) {
		InstitucionDeportiva institucion;
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		institucion = mI.buscarInstitucion(nombreInsti);
		ArrayList<String> actDep = institucion.listarActividadesDeportivas();
		String[] actDep_ret = new String[actDep.size()];
        int a=0;
        for(String i:actDep) {
        	actDep_ret[a]=i;
        	a++;
        }
        return actDep_ret;
	}
	
	public String[] listarClases(String nombreInsti, String nombreActividad) {
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		InstitucionDeportiva institucion = mI.buscarInstitucion(nombreInsti);
		ActividadDeportiva actDep = institucion.buscarActividadDeportiva(nombreActividad);
		ArrayList<String> arrayClases = actDep.listarClases();
		String[] arrayClases_ret = new String[arrayClases.size()];
		int a=0;
		for(String i: arrayClases) {
			arrayClases_ret[a]=i;
			a++;
		}
		return arrayClases_ret;
	}
	
	public DtClase obtenerDtClase(String nombreInsti, String nombreActividad, String nombreClase) {
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		InstitucionDeportiva institucion = mI.buscarInstitucion(nombreInsti);
		ActividadDeportiva actDep = institucion.buscarActividadDeportiva(nombreActividad);
		Clase clase = actDep.buscarClase(nombreClase);
		DtClase dtClase = clase.getDtClase();
		return dtClase;
	}
	
	public String[] listarSocios() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ArrayList<String> arraySocios = mU.obtenerSocios();
		String[] arraySocios_ret = new String[arraySocios.size()];
		int a=0;
		for (String i: arraySocios) {
			arraySocios_ret[a] = i;
			a++;
		}
		return arraySocios_ret;
	}
	
	public void eliminarRegistro(String nomSocio, String nombreClase, String nombreInsti, String nombreAct) throws SocioNoRegistrado {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario usuario = mU.buscarUsuario(nomSocio);
		
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		InstitucionDeportiva institucion = mI.buscarInstitucion(nombreInsti);
		ActividadDeportiva actDep = institucion.buscarActividadDeportiva(nombreAct);
		Clase clase = actDep.buscarClase(nombreClase);
		
		if(usuario instanceof Socio) {
			if(!clase.socioEstaRegistrado(nomSocio)) {
				throw new SocioNoRegistrado(" El socio " + usuario.getNickname() + " no tiene un registro para la clase " + clase.getNombre());
		}else {
			Socio socio = (Socio) mU.buscarUsuario(nomSocio);
			clase.borrarRegistroClase(socio);
			
			Conexion conexion = Conexion.getInstancia();
			EntityManager eM = conexion.getEntityManager();
			eM.getTransaction().begin();
			eM.persist(clase);
			eM.persist((Socio)usuario);	
			eM.getTransaction().commit();
		 }
			
		}
		
		
	}

}
