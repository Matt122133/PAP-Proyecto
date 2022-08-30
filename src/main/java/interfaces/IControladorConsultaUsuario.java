package interfaces;

import datatypes.DtClase;
import datatypes.DtUsuario;
import logic.Usuario;

public interface IControladorConsultaUsuario {

	public String[] listarUsuarios();
	
	public Usuario obtenerUsuario(String nickname);
	
	public String[] buscarClases(String nickname);
	
	public DtClase obtenerDtClase(String nombreInsti, String nombreActividad, String nombreClase);
	
	public DtClase obtenerDtClasePorUsuario(String nombreProfe, String nombreClase);
	
	public String ActDepDeClase(String nombreClase);

	public DtUsuario obtenerUserDt(String user);
}
