package interfaces;

import java.util.Calendar;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;

public interface IControladorModificarUsuario {
	public void modificarUsuario(DtUsuario modificado);
	
	public String[] listarInstituciones();
	
	public String[] listarUsuarios();
	
	public DtUsuario obtenerUserDt(String user);
	
	public void modificarProfesor(String nickname, String nombre, String apellido, Calendar fechaNac, String password, String imagenURL, String descripcion,
			String biografia, String sitioWeb, String instDep );
	
	public void modificarSocio(String nickname, String nombre, String apellido, Calendar fechaNac, String password ,String imagenURL);
	
	public DtSocio obtenerDtSocio(String nickname);
	
	public DtProfesor obtenerDtProfesor(String nickname);
	
	
}
