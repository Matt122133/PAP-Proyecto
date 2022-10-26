package interfaces;

import datatypes.DtClase;

public interface IControladorConsultaClase {
	
	public String[] listarInstituciones();
	public String[] listarActividadesDeportivas(String nombreInsti);
	public String[] listarClases(String nombreInsti, String nombreActividad);
	public DtClase obtenerDtClase(String nombreInsti, String nombreActividad, String nombreClase);
	public DtClase obtenerDtClasePorNomClase(String nombreClase);
	public DtClase[] listarDtClasePorProfe(String nickname);
}
