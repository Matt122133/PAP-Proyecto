package logic;



import java.util.ArrayList;
import java.util.Calendar;

import javax.persistence.EntityManager;

import exceptions.ClaseRepetidaException;
import interfaces.IControladorAltaDictadoDeClase;
import persistencia.Conexion;


public class ControladorAltaDictadoDeClase implements IControladorAltaDictadoDeClase{

	public ControladorAltaDictadoDeClase() {
		super();
	}
	
	public void altaDictadoClase(String nombreInst, String nombreAct, String nicknameProf, String nombre, Calendar fecha, int horaIni, String url, Calendar fechaReg, byte[] imagenClase) throws ClaseRepetidaException {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario prof = mU.buscarUsuario(nicknameProf);

		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		InstitucionDeportiva inst = mI.buscarInstitucion(nombreInst);
		ActividadDeportiva actDep = inst.buscarActividadDeportiva(nombreAct);
		Clase clase = actDep.existeClase(nombre);
		
		if(clase != null)
			throw new ClaseRepetidaException(" Ya existe una clase de nombre: " + nombre );
		
		Clase nuevaClase = new Clase(nombre, fecha, horaIni, url, fechaReg, imagenClase);
		actDep.agregarClase(nuevaClase);
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM= conexion.getEntityManager();
		eM.getTransaction().begin();
		eM.persist(actDep);
		eM.getTransaction().commit();
		
		if (prof instanceof Profesor) {
			((Profesor) prof).agregarClase(nuevaClase);
			
			eM.getTransaction().begin();
			eM.persist(prof);
			eM.getTransaction().commit();
		}
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
