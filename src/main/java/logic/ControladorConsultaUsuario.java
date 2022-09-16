package logic;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtUsuario;
import interfaces.IControladorConsultaUsuario;

public class ControladorConsultaUsuario implements IControladorConsultaUsuario{

	
	public String[] listarUsuarios() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ArrayList<String> arrayUsuarios = mU.obtenerUsuarios();
		String[] arrayUsuarios_ret = new String[arrayUsuarios.size()];
		int a=0;
		for(String i:arrayUsuarios) {
			arrayUsuarios_ret[a]=i;
			a++;
		}
		return arrayUsuarios_ret;
	}

	 
	public Usuario obtenerUsuario(String nickname) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario usuario_ret = mU.buscarUsuario(nickname);
		return usuario_ret;
	}
	
	
	public String[] buscarClases(String nickname) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario usuario_ret = mU.buscarUsuario(nickname);		
		ArrayList<String> listaClases = new ArrayList<String>();
		String[] clases_ret = new String[0];
		if(usuario_ret instanceof Profesor) {
			listaClases = ((Profesor) usuario_ret).obtenerClases();
			clases_ret = new String[listaClases.size()];
	        int a=0;
	        for(String i:listaClases) {
	        	clases_ret[a]=i;
	        	a++;
	        }
		}else if(usuario_ret instanceof Socio) {
			listaClases = ((Socio) usuario_ret).obtenerClases();
			clases_ret = new String[listaClases.size()];
			int a=0;
	        for(String i:listaClases) {
	        	clases_ret[a]=i;
	        	a++;
	        }
		}	
		return clases_ret;
	}
	
	public DtUsuario obtenerUserDt(String user) {
        ManejadorUsuario mU = ManejadorUsuario.getInstancia();
        return mU.getDtUser(user);
    }

	public DtClase obtenerDtClase(String nombreInsti, String nombreActividad, String nombreClase) {
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		InstitucionDeportiva institucion = mI.buscarInstitucion(nombreInsti);
		ActividadDeportiva actDep = institucion.buscarActividadDeportiva(nombreActividad);
		Clase clase = actDep.buscarClase(nombreClase);
		DtClase dtClase = clase.getDtClase();
		return dtClase;
	}
	
	public DtClase obtenerDtClasePorUsuario(String nombreProfe, String nombreClase) {
		ManejadorUsuario uI = ManejadorUsuario.getInstancia();
		Usuario usuario = uI.buscarUsuario(nombreProfe);
		DtClase dtClase = new DtClase();
		if(usuario instanceof Profesor) {
		Clase clase = ((Profesor) usuario).buscarClase(nombreClase);
		dtClase = clase.getDtClase();
		return dtClase;
		}else if(usuario instanceof Socio) {
		Clase clase = ((Socio) usuario).buscarPorNombre(nombreClase);
		dtClase = clase.getDtClase();
		return dtClase;
		}
		return dtClase;
	}
	
	public String ActDepDeClase(String nombreClase) {
		ArrayList<InstitucionDeportiva> instituciones;
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		instituciones = mI.obtenerInstis();
		List<ActividadDeportiva> Act = new ArrayList<ActividadDeportiva>();

		for(InstitucionDeportiva i:instituciones){
			Act=i.getActDeportivas();
			for(ActividadDeportiva j:Act) {
				Clase clase = j.existeClase(nombreClase);
				if(clase != null) {
					return clase.getNombre();
				}
			}
		}
		return null;
		
	}
	

	public DtActividadDeportiva obtenerDtAct(String nombreClase, String nombreActividad){
		ArrayList<InstitucionDeportiva> instituciones;
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		instituciones = mI.obtenerInstis();
		List<ActividadDeportiva> Act = new ArrayList<ActividadDeportiva>();

		for(InstitucionDeportiva i:instituciones){
			Act=i.getActDeportivas();
			for(ActividadDeportiva j:Act) {
				Clase clase = j.existeClase(nombreClase);
				if(clase != null) {
					return j.obtenerDt();
				}
			}
		}
		return null;	
	}
	
}
	
	
	

