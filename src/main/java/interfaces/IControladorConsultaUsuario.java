package interfaces;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import logic.Usuario;

public interface IControladorConsultaUsuario {

	public String[] listarUsuarios();
	
	public Usuario obtenerUsuario(String nickname);
	
	public String[] buscarClases(String nickname);
	
	public DtClase obtenerDtClase(String nombreInsti, String nombreActividad, String nombreClase);
	
	public DtClase obtenerDtClasePorUsuario(String nombreProfe, String nombreClase);
	
	public String ActDepDeClase(String nombreClase);
	
	public DtActividadDeportiva dtActDeClase(String nomClase);

	public DtUsuario obtenerUserDt(String user);
	
	public DtActividadDeportiva obtenerDtAct(String nombreClase,String nombreActividad);
	
	public DtProfesor obtenerDtProfesor(String nickname);
	
	public DtSocio obtenerDtSocio(String nickname);
	
	public boolean validarSocio(String nickname);
	
	public boolean validarProfe(String nickname);
	
	public DtClase[] buscarClasesProfe(String nickname);
	
	public String[] registroSocios(String nickname);
	
}
