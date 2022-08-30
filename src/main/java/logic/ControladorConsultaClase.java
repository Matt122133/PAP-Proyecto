package logic;

import java.util.ArrayList;

import datatypes.DtClase;
import interfaces.IControladorConsultaClase;

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
	
	
	public DtClase obtenerDtClase(String nombreInsti, String nombreActividad, String nombreClase) {
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		InstitucionDeportiva institucion = mI.buscarInstitucion(nombreInsti);
		ActividadDeportiva actDep = institucion.buscarActividadDeportiva(nombreActividad);
		Clase clase = actDep.buscarClase(nombreClase);
		DtClase dtClase = clase.getDtClase();
		return dtClase;
	}

}
