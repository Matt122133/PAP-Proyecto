package logic;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtActividadDeportiva;
import interfaces.IControladorModificarActividad;

public class ControladorModificarActividad implements IControladorModificarActividad {
	
	public String[] listarActividades(){
		ArrayList<InstitucionDeportiva> instituciones;
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		instituciones = mI.obtenerInstis();
		List<ActividadDeportiva> Act = new ArrayList<ActividadDeportiva>();
		List<ActividadDeportiva> Acts= new ArrayList<ActividadDeportiva>();
		int a =0;
		int b =0;
		for(InstitucionDeportiva i:instituciones){
			Act=i.getActDeportivas();
			for(ActividadDeportiva j:Act) {
				Acts.add(j);
			}
		}
		
		String[] act_ret = new String[Acts.size()];
		for(ActividadDeportiva l:Acts) {
			b++;
			act_ret[a]= b +":   "+ l.getNombre() ;
			a++;
		}
		
		return act_ret;
		
	}
	
	public DtActividadDeportiva obtenerDtActividad(String nombre) {
		ArrayList<InstitucionDeportiva> instituciones;
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		instituciones = mI.obtenerInstis();
		List<ActividadDeportiva> Act = new ArrayList<ActividadDeportiva>();
		List<ActividadDeportiva> Acts= new ArrayList<ActividadDeportiva>();
		for(InstitucionDeportiva i:instituciones){
			Act=i.getActDeportivas();
			for(ActividadDeportiva j:Act) {
				Acts.add(j);
				
			}
		}
		
		for(ActividadDeportiva l:Acts) {
			DtActividadDeportiva retorno = l.obtenerDtPorString(nombre);
			return retorno;
		}
		
		 return null;
	}
		
	
	public void modificarActDep(DtActividadDeportiva actualizado) {
		/*ArrayList<InstitucionDeportiva> instituciones;
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		instituciones = mI.obtenerInstis();
		for(InstitucionDeportiva i:instituciones){
			ActividadDeportiva actActualizar = i.buscarActividadDeportiva(actualizado.getNombre());
			actActualizar.setNombre(actualizado.getNombre());
			actActualizar.setDescripcion(actualizado.getDescripcion());
			actActualizar.setCosto(actualizado.getCosto());
			actActualizar.setDuracion(actualizado.getDuracion());
			actActualizar.setFechaReg(actualizado.getFechaReg());	
		}*/
		
	}

}
