package interfaces;

import datatypes.DtUsuario;
import exceptions.UsuarioRepetidoException;

public interface IControladorAltaUsuario {

	public void altaUsuario(DtUsuario usuario) throws UsuarioRepetidoException;
	
	public String[] listarInstituciones();
}
