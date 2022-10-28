package interfaces;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;

public interface IControladorConsultaAct {
	
	public String[] listarInstituciones();
	
	public String[] obtenerActividadesDeportivas(String nombreInsti);
	
	public DtActividadDeportiva obtenerDtActividadDeportivaInst(String institucion, String actividad);
	
	String[] listarClases(String nombreInsti, String nombreActividad);
	
	DtClase obtenerDtClase(String nombreInsti, String nombreActividad, String nombreClase);
	
	public String[] listarActividades();
	
	public DtActividadDeportiva obtenerDtAct(String nomAct);
	
	public String[] listarClasesDeAct(String nomAct);
	
	
}
