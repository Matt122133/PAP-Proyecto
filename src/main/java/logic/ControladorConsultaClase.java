package logic;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import datatypes.DtClase;
import interfaces.IControladorConsultaClase;
import persistencia.Conexion;

public class ControladorConsultaClase implements IControladorConsultaClase{

	
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
	
	
	public String[] listarActividadesDeportivas(String nombreInsti) {
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
	
	public ArrayList<String> listarClasesProfe(String nickProfe){
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario user = mU.buscarUsuario(nickProfe);
		ArrayList<String> clases = new ArrayList<String>();
		if(user instanceof Profesor){
			clases = ((Profesor) user).obtenerClases();
		}
		return clases;	
	}
	
	public DtClase obtenerDtClase(String nombreInsti, String nombreActividad, String nombreClase) {
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		InstitucionDeportiva institucion = mI.buscarInstitucion(nombreInsti);
		ActividadDeportiva actDep = institucion.buscarActividadDeportiva(nombreActividad);
		Clase clase = actDep.buscarClase(nombreClase);
		DtClase dtClase = clase.getDtClase();
		return dtClase;
	}
	
	public DtClase obtenerDtClasePorNombreClase(String nombreClase) {
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		ArrayList<InstitucionDeportiva> instis = mI.obtenerInstis();
		ArrayList<DtClase> dtClases = new ArrayList<DtClase>();
		for(InstitucionDeportiva i: instis) {
			ArrayList<ActividadDeportiva> acts = i.listarAct();
			for(ActividadDeportiva o: acts) {
				ArrayList<DtClase> clases = o.obtenerDtClase();
				for(DtClase u: clases) {
					dtClases.add(u);
					for(DtClase e: dtClases) {
						if(e.getNombre().equals(nombreClase)) {
							return e;
						}
					}
				}
			}
		}
		return null;
	}
	
	public DtClase obtenerDtClasePorNombreBD(String nomClase) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM = conexion.getEntityManager();
		
		Clase clase = eM.find(Clase.class, nomClase);
		if(clase == null) {
			System.out.println("Clase nula");
		}
		return clase.getDtClase();
	}
}
