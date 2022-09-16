package logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import interfaces.IControladorRankingClases;

public class ControladorRankingClases implements IControladorRankingClases{
	
	
	@SuppressWarnings({ "deprecation" })
	public String[] listarClases() {
		ArrayList<InstitucionDeportiva> instituciones;
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		instituciones = mI.obtenerInstis();
		List<ActividadDeportiva> Act = new ArrayList<ActividadDeportiva>();
		List<Clase> clase = new ArrayList<Clase>();
		List<Clase> clases = new ArrayList<Clase>();
		int a =0;
		int b =0;
		int d , m ,y;
		for(InstitucionDeportiva i:instituciones){
			Act=i.getActDeportivas();
			for(ActividadDeportiva j:Act) {
				clase= j.getClases();
					for(Clase k: clase) {
					clases.add(k);
				}
			}
		}
		Collections.sort(clases, (c1,c2) -> new Integer (c2.getRegistros().size()).compareTo(new Integer(c1.getRegistros().size())) );  
		String[] clases_ret = new String[clases.size()];
		for(Clase l:clases) {
			d=l.getFecha().get(Calendar.DAY_OF_MONTH);
			m=l.getFecha().get(Calendar.MONTH) +1;
			y=l.getFecha().get(Calendar.YEAR);
			b++;
			clases_ret[a]= b +":   "+ l.getNombre()+"   " + d +"/"+ m +"/"+ y+"   "  +l.getUrl() ;
			a++;
		}
		
		return clases_ret;
		
	}
	
}
