package interfaces;

import datatypes.DtInstitucion;

public interface IControladorModificarInstitucion {
	
	public void modificarInstDep(DtInstitucion actualizado);
	
	public String[] listarInstituciones();
	
	public DtInstitucion obtenerDtInst(String nombre);
	
}
