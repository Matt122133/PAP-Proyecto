package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import interfaces.IControladorRankingActividadDeportiva;

public class ControladorRankingActividadDeportiva implements IControladorRankingActividadDeportiva {

	
	
	
	@SuppressWarnings("deprecation")
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
	
}
