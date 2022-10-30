package logic;

import java.util.ArrayList;

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
	
	public void modificarProfesor(DtProfesor profeModificado) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario aModificar = mU.buscarUsuario(profeModificado.getNickname());
		if(aModificar instanceof Profesor) {
			((Profesor) aModificar).actualizarProfe(profeModificado);
		}
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM= conexion.getEntityManager();
		eM.getTransaction().begin();
		eM.persist(aModificar);
		eM.getTransaction().commit();
	}
	
	public void modificarSocio(DtSocio socioModificado) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario aModificar = mU.buscarUsuario(socioModificado.getNickname());
		if(aModificar instanceof Socio) {
			((Socio) aModificar).actualizarSocio(socioModificado);
		}
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM= conexion.getEntityManager();
		eM.getTransaction().begin();
		eM.persist(aModificar);
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
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		return mU.getDtUser(user);
	}

}
