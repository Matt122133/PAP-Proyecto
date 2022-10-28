package logic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import interfaces.IControladorConsultaAct;
import persistencia.Conexion;

public class ControladorConsultaAct implements IControladorConsultaAct {
	
	
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
	
	public String[] obtenerActividadesDeportivas(String nombreInsti) {
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
	
	public DtActividadDeportiva obtenerDtActividadDeportivaInst(String institucion, String actividad) {
		InstitucionDeportiva inst;
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		inst = mI.buscarInstitucion(institucion);
		return inst.obtenerDtActDep(actividad);
		
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
	
	@SuppressWarnings("unchecked")
	public String[] listarActividades() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM = conexion.getEntityManager();
		
		Query query = eM.createQuery("select a from ActividadDeportiva a");
		List<ActividadDeportiva> actsDep = (List<ActividadDeportiva>) query.getResultList();
		
		String[] aRetornar = new  String[actsDep.size()];
		int a = 0;
		for(ActividadDeportiva i: actsDep) {
			aRetornar[a] = i.getNombre();	
			a++;
		}
		return aRetornar;
	}
	
	@SuppressWarnings("unchecked")
	public DtActividadDeportiva obtenerDtAct(String nomAct) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM = conexion.getEntityManager();
		DtActividadDeportiva dtAct = null;
		Query query = eM.createQuery("select i from InstitucionDeportiva i");
		List<InstitucionDeportiva> instis = (List<InstitucionDeportiva>) query.getResultList();
		
			ArrayList<DtActividadDeportiva> actividades = new ArrayList<DtActividadDeportiva>();
			for(InstitucionDeportiva i: instis) {
				ArrayList<DtActividadDeportiva> acts = i.listarDtActDeportiva();
				for(DtActividadDeportiva a: acts) {
					actividades.add(a);
					for(DtActividadDeportiva o: actividades) {
						if(o.getNombre().equals(nomAct)) {
							dtAct = o;
						}	
					}
				}
			}
		return dtAct;
	}
		
	
	public String[] listarClasesDeAct(String nomAct) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM = conexion.getEntityManager();
		
		ActividadDeportiva act = eM.find(ActividadDeportiva.class, nomAct);
		List<Clase> clases = act.getClases();
		String[] array_ret = new String[clases.size()];
		int a = 0;
		for(Clase i: clases) {
			array_ret[a] = i.getNombre();	
			a++;
		}
		return array_ret;
	}

}
