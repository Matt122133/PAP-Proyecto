package interfaces;

import datatypes.DtActividadDeportiva;

public interface IControladorModificarActividad {

	public String[] listarActividades();
	
	public DtActividadDeportiva obtenerDtActividad(String nombre);
	
	public void modificarActDep(DtActividadDeportiva actualizado);
	
}
