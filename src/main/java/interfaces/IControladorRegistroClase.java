package interfaces;

import java.util.Calendar;

import datatypes.DtClase;
import exceptions.RegistroRepetidoException;

public interface IControladorRegistroClase {
	
	public String[] listarInstituciones();
	public String[] listarActividades(String nombreInsti);
	public String[] listarClases(String nombreInsti, String nombreActividad);
	public DtClase obtenerDtClase(String nombreInsti, String nombreActividad, String nombreClase); 
	public String[] listarSocios();
	public void registroSocioClase(String nombreInsti, String nombreAct, String socio, String nombreClase, Calendar fechaReg) throws RegistroRepetidoException ;
	public Float obtenerCostoClase(String nomActividad, String nomInsti);
}
