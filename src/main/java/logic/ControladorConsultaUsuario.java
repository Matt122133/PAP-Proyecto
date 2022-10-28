package logic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import interfaces.IControladorConsultaUsuario;
import persistencia.Conexion;

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
	
	public DtProfesor obtenerDtProfesor(String nickname) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario user = mU.buscarUsuario(nickname);
		DtProfesor dtProf = null;
		if(user instanceof Profesor) {
			dtProf = ((Profesor) user).getDtProfesor();
		}
		return dtProf;
	}
	
	public DtSocio obtenerDtSocio(String nickname){
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario user = mU.buscarUsuario(nickname);
		DtSocio dtSocio = null;
		if(user instanceof Socio) {
			dtSocio = ((Socio) user).getDtSocio();
		}
		return dtSocio;
	}
	 
	public boolean validarProfe(String nickname) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario user = mU.buscarUsuario(nickname);
		if(user instanceof Profesor) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean validarSocio(String nickname) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario user = mU.buscarUsuario(nickname);
		if(user instanceof Socio) {
			return true;
		}else {
			return false;
		}
	}
	
	public String[] registroSocios(String nickname) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM = conexion.getEntityManager();
		Socio socio = eM.find(Socio.class, nickname);
		List<Registro> registros = socio.getRegistros();
		String[] array_ret = new String[registros.size()];
		int a = 0;
		for(Registro i:registros) {
			array_ret[a] = i.getNombreClase();
			a++;
		}
		
		return array_ret;
	}
	
	public DtClase[] buscarClasesProfe(String nickname) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario user = mU.buscarUsuario(nickname);	
		ArrayList<DtClase> listaClases = new ArrayList<DtClase>();
		DtClase[] clases_ret = new DtClase[0];
		if(user instanceof Profesor) {
			listaClases = ((Profesor) user).obtenerDtClases();
			clases_ret = new DtClase[listaClases.size()];
			int a = 0;
			for(DtClase i: listaClases) {
				clases_ret[a] = i;
				a++;
			}
		}
		return clases_ret;
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
					return j.getNombre();				
				}
			}
		}
		return null;
		
	}
	
	public DtActividadDeportiva dtActDeClase(String nomClase) {
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		ArrayList<InstitucionDeportiva> instituciones = mI.obtenerInstis();
		List<ActividadDeportiva> acts = new ArrayList<ActividadDeportiva>();
		List<ActividadDeportiva> actividades = new ArrayList<ActividadDeportiva>();
		for(InstitucionDeportiva i:instituciones){
			acts = i.listarAct();
			for(ActividadDeportiva u: acts) {
				actividades.add(u);
				for(ActividadDeportiva e: actividades) {
					ArrayList<DtClase> clases = e.obtenerDtClase();
					for(DtClase w: clases) {
						if(w.getNombre().equals(nomClase)) {
							return e.obtenerDt();
						}
						
					}
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
	
	
	

