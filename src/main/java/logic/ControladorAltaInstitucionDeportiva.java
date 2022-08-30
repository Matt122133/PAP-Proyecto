package logic;


import exceptions.InstitucionRepetidaException;
import interfaces.IControladorAltaInstitucionDeportiva;

public class ControladorAltaInstitucionDeportiva implements IControladorAltaInstitucionDeportiva{
	
	public ControladorAltaInstitucionDeportiva() {
		super();
	}

	public void altaInstitucionDeportiva(String nombre, String descripcion, String url) throws InstitucionRepetidaException {
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		if(mI.buscarInstitucion(nombre) != null)
			throw new InstitucionRepetidaException("La institucion de nombre "+ nombre +" ya existe.");
		InstitucionDeportiva inst = new InstitucionDeportiva(nombre, descripcion, url);
		mI.agregarInstitucion(inst);
	}
}
