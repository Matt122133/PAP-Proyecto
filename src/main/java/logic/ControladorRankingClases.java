package logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import interfaces.IControladorRankingClases;

public class ControladorRankingClases implements IControladorRankingClases{
	
	

	@SuppressWarnings("removal")
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
	
	/*@SuppressWarnings("removal")
	public List<DtClase> clasesOrdenadas(){
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		ArrayList<InstitucionDeportiva> instis = mI.obtenerInstis();
		ArrayList<DtClase> dtClases = new ArrayList<DtClase>();
		for(InstitucionDeportiva i: instis) {
			ArrayList<ActividadDeportiva> acts = i.listarAct();
			for(ActividadDeportiva o: acts) {
				ArrayList<DtClase> clases = o.obtenerDtClase();
				for(DtClase u: clases) {
					dtClases.add(u);
					
				}
			}
		}
		
		Collections.sort(dtClases, (c1,c2) -> new Integer (c2.getRegistros().size()).compareTo(new Integer(c1.getRegistros().size())) );
		List<DtClase> clases_ret = new ArrayList<DtClase>(dtClases.size());
		for(DtClase e: dtClases) {
			clases_ret.add(e);
		}
		
		return clases_ret;
		
		
	}*/
	
	
	
	
	
}
