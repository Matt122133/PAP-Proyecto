package logic;

import java.util.ArrayList;

import datatypes.DtInstitucion;
import interfaces.IControladorModificarInstitucion;

public class ControladorModificarInstitucion implements IControladorModificarInstitucion {
	
	public void modificarInstDep(DtInstitucion actualizado) {
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		InstitucionDeportiva aActualizar = mI.buscarInstitucion(actualizado.getNombre());
		aActualizar.setDescripcion(actualizado.getDescripcion());
		aActualizar.setUrl(actualizado.getUrl());
	}
	
	public String[] listarInstituciones() {
		ArrayList<String> instituciones;
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		instituciones = mI.obtenerInstituciones();
		String[] instituciones_ret = new String[instituciones.size()];
        int a=0;
        for(String i:instituciones) {
        	instituciones_ret[a]=i;
        	a++;
        }
        return instituciones_ret;
	}
	
	public DtInstitucion obtenerDtInst(String nombre){
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		InstitucionDeportiva laInst = mI.buscarInstitucion(nombre);
		DtInstitucion retorno = new DtInstitucion(laInst.getNombre(),laInst.getDescripcion(),laInst.getUrl());
		return retorno;
	}
}
