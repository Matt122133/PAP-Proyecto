package logic;

import java.util.ArrayList;
import java.util.Calendar;

import javax.persistence.EntityManager;

import datatypes.DtClase;
import exceptions.RegistroRepetidoException;
import interfaces.IControladorRegistroClase;
import persistencia.Conexion;

public class ControladorRegistroClase implements IControladorRegistroClase{

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

	public String[] listarActividades(String nombreInsti) {
		InstitucionDeportiva institucion;
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		institucion = mI.buscarInstitucion(nombreInsti);
		ArrayList<String> actDep = institucion.listarActividadesDeportivas();
		String[] actDep_ret = new String[actDep.size()];
        int a=0;
        for(String i:actDep) {
        	actDep_ret[a]=i;
        	a++;
        }
        return actDep_ret;
	}

	public String[] listarClases(String nombreInsti, String nombreActividad) {
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		InstitucionDeportiva institucion = mI.buscarInstitucion(nombreInsti);
		ActividadDeportiva actDep = institucion.buscarActividadDeportiva(nombreActividad);
		ArrayList<String> arrayClases = actDep.listarClases();
		String[] arrayClases_ret = new String[arrayClases.size()];
		int a=0;
		for(String i: arrayClases) {
			arrayClases_ret[a]=i;
			a++;
		}
		return arrayClases_ret;
		
	}
	
	public DtClase obtenerDtClase(String nombreInsti, String nombreActividad, String nombreClase) {
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		InstitucionDeportiva institucion = mI.buscarInstitucion(nombreInsti);
		ActividadDeportiva actDep = institucion.buscarActividadDeportiva(nombreActividad);
		Clase clase = actDep.buscarClase(nombreClase);
		DtClase dtClase = clase.getDtClase();
		return dtClase;
	}

	public String[] listarSocios() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ArrayList<String> arraySocios = mU.obtenerSocios();
		String[] arraySocios_ret = new String[arraySocios.size()];
		int a=0;
		for (String i: arraySocios) {
			arraySocios_ret[a] = i;
			a++;
		}
		return arraySocios_ret;
	}
	
	public Float obtenerCostoClase(String nomActividad, String nomInsti){
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM = conexion.getEntityManager();
		InstitucionDeportiva insti = eM.find(InstitucionDeportiva.class, nomInsti);
		ActividadDeportiva actDep = insti.buscarActividadDeportiva(nomActividad);
		return actDep.getCosto();
	}

	public boolean validarInsti(String nomi) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM = conexion.getEntityManager();
		InstitucionDeportiva insti = eM.find(InstitucionDeportiva.class, nomi);
		if(insti != null) {
			return true;
		}else return false;
		
	}
	
	public boolean validarAct(String nomi,String noma) {
		boolean b = false;
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM = conexion.getEntityManager();
		InstitucionDeportiva insti = eM.find(InstitucionDeportiva.class, nomi);
		if(insti != null) {
			ArrayList<String> actDep = insti.listarActividadesDeportivas();
	        for(String i:actDep) {
	        	if(i.equals(noma)) {
	        		b=true;
	        	}
	        }
		} 
		return b;
	}
	
	public boolean validarC(String nomc) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM = conexion.getEntityManager();
		Clase clase = eM.find(Clase.class, nomc);
		if(clase!= null) {
			return false;
		}else return true;
		
	}
	
	public boolean validarRegistro(String nickSocio, String nomClase) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM = conexion.getEntityManager();
		Socio socio = eM.find(Socio.class, nickSocio);
		if(socio.buscarRegistroPorNomClase(nomClase) == true) {
			return true;
		}
		return false;
	}
	
	public void registroSocioClase(String nombreInsti, String nombreAct, String socio, String nombreClase, Calendar fechaReg) throws RegistroRepetidoException {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario usuario = mU.buscarUsuario(socio);
		
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		InstitucionDeportiva institucion = mI.buscarInstitucion(nombreInsti);
		ActividadDeportiva actDep = institucion.buscarActividadDeportiva(nombreAct);
		Clase clase = actDep.buscarClase(nombreClase);
		
		if(usuario instanceof Socio) {
			if(((Socio)usuario).buscarRegistro(clase)) {
				throw new RegistroRepetidoException("El socio "+ usuario.getNickname() + " ya tiene un registro para la clase " + clase.getNombre());
			}else {
				Registro nuevoRegistro = new Registro(fechaReg,(Socio) usuario, clase);
				((Socio)usuario).agregarRegistro(nuevoRegistro);
				clase.agregarRegistro(nuevoRegistro);
				
				
				
				Conexion conexion = Conexion.getInstancia();
				EntityManager eM= conexion.getEntityManager();
				eM.getTransaction().begin();
				eM.persist(clase);
				eM.persist((Socio)usuario);				
				eM.getTransaction().commit();
				
				
			}
		}
	}
	
}
