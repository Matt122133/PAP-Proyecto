package interfaces;

import datatypes.DtClase;
import exceptions.SocioNoRegistrado;

public interface IControladorEliminarRegistro {
	
	public String[] listarInstituciones();
	public String[] listarActividades(String nombreInstitucion);
	public String[] listarClases(String nombreInstitucion, String nombreActividad);
	public DtClase obtenerDtClase(String nombreInsti, String nombreActividad, String nombreClase); 
	public String[] listarSocios();
	public void eliminarRegistro(String socio, String clase, String nombreInsti, String nombreAct) throws SocioNoRegistrado;
}
