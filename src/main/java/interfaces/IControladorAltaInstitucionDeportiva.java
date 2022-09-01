package interfaces;

import exceptions.InstitucionRepetidaException;

public interface IControladorAltaInstitucionDeportiva {
	
	public void altaInstitucionDeportiva(String nombre, String descripcion, String url) throws InstitucionRepetidaException;
}
