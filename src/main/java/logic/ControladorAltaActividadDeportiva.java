package logic;

import java.util.ArrayList;
import java.util.Calendar;

import exceptions.ActividadRepetidaException;
import interfaces.IControladorAltaActividadDeportiva;

public class ControladorAltaActividadDeportiva implements IControladorAltaActividadDeportiva{
	
	public void altaActividadDeportiva(String nombreInst, String nombre, String descripcion, Integer duracion, float costo, Calendar fechaReg) throws ActividadRepetidaException {
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		InstitucionDeportiva instDep = mI.buscarInstitucion(nombreInst);
		ActividadDeportiva actDep = new ActividadDeportiva(nombre, descripcion, duracion, costo, fechaReg);
		if (instDep.tengoActDep(nombre))
			throw new ActividadRepetidaException("La actividad "+ nombre +" ya existe.");		
		instDep.agregarActividadDeportiva(actDep);
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
}
