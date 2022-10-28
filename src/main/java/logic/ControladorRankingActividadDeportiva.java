package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import datatypes.DtActividadDeportiva;
import interfaces.IControladorRankingActividadDeportiva;

public class ControladorRankingActividadDeportiva implements IControladorRankingActividadDeportiva {

	
	
	
	@SuppressWarnings("removal")
	public String[] listarActividades() {
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
	
		Collections.sort(Acts, (a1,a2) -> new Integer (a2.getClases().size()).compareTo(new Integer(a1.getClases().size())));  
		String[] act_ret = new String[Acts.size()];
		for(ActividadDeportiva l:Acts) {
			b++;
			act_ret[a]= b +":   "+ l.getNombre() + ":   " + l.getCosto()+ ":   " + l.getDuracion() ;
			a++;
		}
		
		return act_ret;
		
	}
	
	public List<DtActividadDeportiva> obtenerDtActividad(){
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		ArrayList<InstitucionDeportiva> instis = mI.obtenerInstis();
		List<DtActividadDeportiva> act = new ArrayList<DtActividadDeportiva>();
		List<DtActividadDeportiva> acts = new ArrayList<DtActividadDeportiva>();
		for(InstitucionDeportiva i: instis) {
			act = i.listarDtActDeportiva();
			for(DtActividadDeportiva s: act) {
				acts.add(s);
			}
		}
		
		return acts;
		
	}
	
	@SuppressWarnings("removal")
	public List<DtActividadDeportiva> actOrdenadas(){
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		ArrayList<InstitucionDeportiva> instis = mI.obtenerInstis();
		List<ActividadDeportiva> act = new ArrayList<ActividadDeportiva>();
		List<ActividadDeportiva> acts = new ArrayList<ActividadDeportiva>();
		for(InstitucionDeportiva i: instis) {
			act = i.getActDeportivas();
			for(ActividadDeportiva s: act) {
				acts.add(s);
			}
		}
		
		Collections.sort(acts, (a1,a2) -> new Integer (a2.getClases().size()).compareTo(new Integer(a1.getClases().size())));  
		List<DtActividadDeportiva> act_ret = new ArrayList<DtActividadDeportiva>(acts.size());
		for(ActividadDeportiva o: acts) {
			act_ret.add(o.obtenerDt());
		}
		
		return act_ret;
		
	}
	
	
	
}
