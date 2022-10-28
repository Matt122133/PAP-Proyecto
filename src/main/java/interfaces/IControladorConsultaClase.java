package interfaces;

import java.util.ArrayList;

import datatypes.DtClase;

public interface IControladorConsultaClase {
	
	public String[] listarInstituciones();
	
	public String[] listarActividadesDeportivas(String nombreInsti);
	
	public String[] listarClases(String nombreInsti, String nombreActividad);
	
	public DtClase obtenerDtClase(String nombreInsti, String nombreActividad, String nombreClase);
	
	public DtClase obtenerDtClasePorNombreClase(String nombreClase);
	
	public ArrayList<String> listarClasesProfe(String nickProfe);
	
	public DtClase obtenerDtClasePorNombreBD(String nomClase);
	
	public String[] listarRegistros(String nombre);
}
