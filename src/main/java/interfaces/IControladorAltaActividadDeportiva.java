package interfaces;

import exceptions.ActividadRepetidaException;

import java.util.Calendar;

public interface IControladorAltaActividadDeportiva {
	
	public void altaActividadDeportiva(String nombreInst, String nombre, String descripcion, Integer duracion, float costo, Calendar fechaReg, String imagenAct) throws ActividadRepetidaException;

	public String[] listarInstituciones();

}
