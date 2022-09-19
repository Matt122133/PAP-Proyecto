package logic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import datatypes.DtActividadDeportiva;
import interfaces.IControladorModificarActividad;
import persistencia.Conexion;

public class ControladorModificarActividad implements IControladorModificarActividad {
	
	public String[] listarActividades(){
		ArrayList<InstitucionDeportiva> instituciones;
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		instituciones = mI.obtenerInstis();
		List<ActividadDeportiva> Act = new ArrayList<ActividadDeportiva>();
		List<ActividadDeportiva> Acts= new ArrayList<ActividadDeportiva>();
		int a =0;
		for(InstitucionDeportiva i:instituciones){
			Act=i.getActDeportivas();
			for(ActividadDeportiva j:Act) {
				Acts.add(j);
			}
		}
		
		String[] act_ret = new String[Acts.size()];
		for(ActividadDeportiva l:Acts) {
			act_ret[a]= l.getNombre() ;
			a++;
		}
		
		return act_ret;
		
	}
	
	public DtActividadDeportiva obtenerDtActividad(String nombre) {
		ArrayList<InstitucionDeportiva> instituciones;
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		instituciones = mI.obtenerInstis();
		List<ActividadDeportiva> Act = new ArrayList<ActividadDeportiva>();
		for(InstitucionDeportiva i:instituciones){
			Act=i.getActDeportivas();
			for(ActividadDeportiva l:Act) {
				if(l.getNombre().equals(nombre)) {
				DtActividadDeportiva retorno = l.obtenerDt();
				return retorno;
				}
			}
		}
		return null;
	}
		
	
	public void modificarActDep(DtActividadDeportiva actualizado) {
		ArrayList<InstitucionDeportiva> instituciones;
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		instituciones = mI.obtenerInstis();
		for(InstitucionDeportiva i:instituciones){
			ActividadDeportiva actActualizar = i.buscarActividadDeportiva(actualizado.getNombre());
			if(actActualizar != null) {
				actActualizar.setDescripcion(actualizado.getDescripcion());
				actActualizar.setCosto(actualizado.getCosto());
				actActualizar.setDuracion(actualizado.getDuracion());
				actActualizar.setImagenAct(actualizado.getImagenAct());
				
				Conexion conexion = Conexion.getInstancia();
				EntityManager eM= conexion.getEntityManager();
				eM.getTransaction().begin();
				eM.persist(actActualizar);
				eM.getTransaction().commit();
			}
		}
	}
}
