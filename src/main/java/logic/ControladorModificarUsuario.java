package logic;

import java.util.ArrayList;
import java.util.Calendar;

import javax.persistence.EntityManager;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import interfaces.IControladorModificarUsuario;
import persistencia.Conexion;

public class ControladorModificarUsuario implements IControladorModificarUsuario{
	
	public void modificarUsuario(DtUsuario modificado) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario aModificar = mU.buscarUsuario(modificado.getNickname());
		if(aModificar instanceof Profesor) {
			((Profesor) aModificar).actualizarProfe(modificado);
		}
		else if(aModificar instanceof Socio) {
			((Socio) aModificar).actualizarSocio(modificado);
		}
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM= conexion.getEntityManager();
		eM.getTransaction().begin();
		eM.persist(aModificar);
		eM.getTransaction().commit();
	}
	
	public void modificarProfesor(String nickname, String nombre, String apellido, Calendar fechaNac, String password, String imagenURL, String descripcion,
			String biografia, String sitioWeb, String instDep ) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM= conexion.getEntityManager();
		Profesor profesor = eM.find(Profesor.class, nickname);
		
		profesor.setNombre(nombre);
		profesor.setApellido(apellido);
		profesor.setFechaNac(fechaNac);
		profesor.setPassword(password);
		profesor.setImagenURL(imagenURL);
		profesor.setDescripcion(descripcion);
		profesor.setBiografia(biografia);
		profesor.setSitioWeb(sitioWeb);
		InstitucionDeportiva insti = eM.find(InstitucionDeportiva.class, instDep);
		profesor.setInstDep(insti);
	
		eM.getTransaction().begin();
		eM.persist(profesor);
		eM.getTransaction().commit();
	}
	
	public void modificarSocio(String nickname, String nombre, String apellido, Calendar fechaNac, String password ,String imagenURL) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM= conexion.getEntityManager();
		Socio socio = eM.find(Socio.class, nickname);
		
		socio.setNombre(nombre);
		socio.setApellido(apellido);
		socio.setFechaNac(fechaNac);
		socio.setPassword(password);
		socio.setImagenURL(imagenURL);

		eM.getTransaction().begin();
		eM.persist(socio);
		eM.getTransaction().commit();
	}
	
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
	
	
	public DtUsuario obtenerUserDt(String user) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM= conexion.getEntityManager();
		Usuario usuario = eM.find(Usuario.class, user);
		return usuario.getDtUsuario();
	}
	
	public DtSocio obtenerDtSocio(String nickname) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM= conexion.getEntityManager();
		
		Socio socio = eM.find(Socio.class,nickname);
		return socio.getDtSocio();
	}
	
	public DtProfesor obtenerDtProfesor(String nickname) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM= conexion.getEntityManager();
		
		Profesor profesor = eM.find(Profesor.class, nickname);
		return profesor.getDtProfesor();
	}

}
