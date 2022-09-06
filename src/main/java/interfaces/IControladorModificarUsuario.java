package interfaces;

import datatypes.DtUsuario;

public interface IControladorModificarUsuario {
	public void modificarUsuario(DtUsuario modificado);
	public String[] listarInstituciones();
	public String[] listarUsuarios();
	public DtUsuario obtenerUserDt(String user);
}
