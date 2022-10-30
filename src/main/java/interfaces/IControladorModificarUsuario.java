package interfaces;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;

public interface IControladorModificarUsuario {
	public void modificarUsuario(DtUsuario modificado);
	
	public String[] listarInstituciones();
	
	public String[] listarUsuarios();
	
	public DtUsuario obtenerUserDt(String user);
	
	public void modificarProfesor(DtProfesor profeModificado);
	
	public void modificarSocio(DtSocio socioModificado);
	
}
