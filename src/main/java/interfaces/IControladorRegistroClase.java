package interfaces;

import java.util.Calendar;

import datatypes.DtClase;
import exceptions.RegistroRepetidoException;

public interface IControladorRegistroClase {
	
	public String[] listarInstituciones();
	public String[] listarActividades(String nombreInstitucion);
	public String[] listarClases(String nombreInstitucion, String nombreActividad);
	public DtClase obtenerDtClase(String nombreInsti, String nombreActividad, String nombreClase); 
	public String[] listarSocios();
	public void registroSocioClase(String institucion, String actividad,String socio, String clase, Calendar fechaReg) throws RegistroRepetidoException ;

}
