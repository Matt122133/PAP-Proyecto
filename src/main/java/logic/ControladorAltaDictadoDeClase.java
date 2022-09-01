package logic;



import java.util.ArrayList;
import java.util.Calendar;

import exceptions.ClaseRepetidaException;
import interfaces.IControladorAltaDictadoDeClase;


public class ControladorAltaDictadoDeClase implements IControladorAltaDictadoDeClase{

	public ControladorAltaDictadoDeClase() {
		super();
	}
	
	public void altaDictadoClase(String nombreInst, String nombreAct, String nicknameProf, String nombre, Calendar fecha, int horaIni, String url, Calendar fechaReg) throws ClaseRepetidaException {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario prof = mU.buscarUsuario(nicknameProf);

		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		InstitucionDeportiva inst = mI.buscarInstitucion(nombreInst);
		ActividadDeportiva actDep = inst.buscarActividadDeportiva(nombreAct);
		
		if(actDep.existeClase(nombre))
			throw new ClaseRepetidaException("Ya existe una clase con ese nombre.");
		Clase nuevaClase = new Clase(nombre, fecha, horaIni, url, fechaReg);
		actDep.agregarClase(nuevaClase);
		
		if (prof instanceof Profesor)
			((Profesor) prof).agregarClase(nuevaClase);
	}

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
	
	public String[] obtenerActividadesDeportivas(String nombreinsti) {
		InstitucionDeportiva institucion;
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		institucion = mI.buscarInstitucion(nombreinsti);
		ArrayList<String> actdep = institucion.listarActividadesDeportivas();
		String[] actdep_ret = new String[actdep.size()];
        int a=0;
        for(String i:actdep) {
        	actdep_ret[a]=i;
        	a++;
        }
        return actdep_ret;
	}
	
	public String[] obtenerProfesor(String nombreInsti) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ArrayList<String> prof = mU.obtenerProfes(nombreInsti);
		String[] prof_ret = new String[prof.size()];
		int a = 0;
		for(String i:prof) {
			prof_ret[a] = i;
			a++;
		}
		return prof_ret;
	}
	
	

}
