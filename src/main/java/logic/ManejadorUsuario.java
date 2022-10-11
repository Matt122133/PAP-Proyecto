package logic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import datatypes.DtUsuario;
import persistencia.Conexion;

public class ManejadorUsuario {
	private static ManejadorUsuario instancia = null;
	
	public static ManejadorUsuario getInstancia() {
		if(instancia == null)
			instancia = new ManejadorUsuario();
		return instancia;
	}
	
	public void agregarUsuario(Usuario usuario) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM= conexion.getEntityManager();
		eM.getTransaction().begin();
		eM.persist(usuario);
		eM.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public Usuario existeUsuario(String nickname/*,String email*/ ) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM= conexion.getEntityManager();
		
		Query query = eM.createQuery("select u from Usuario u");
		List<Usuario> usuarios = (List<Usuario>) query.getResultList();
		
		Usuario usuario = null;
		for(Usuario u: usuarios) {
			if(u.getNickname().equals(nickname) /*|| u.getEmail().equals(email)*/)
				usuario = u;
		}
		return usuario;
	}
	
	public Usuario buscarUsuario(String nickname) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM= conexion.getEntityManager();
		
		Usuario usuario = eM.find(Usuario.class, nickname);
		return usuario;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> obtenerUsuarios(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM= conexion.getEntityManager();
		
		Query query = eM.createQuery("select u from Usuario u");
		List<Usuario> usuarios = (List<Usuario>) query.getResultList();
		
		ArrayList<String> aRetornar = new ArrayList<String>();
		for(Usuario i: usuarios) {
			aRetornar.add(i.getNickname());		
		}
		return aRetornar;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> obtenerProfes(String nombreInsti){
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM= conexion.getEntityManager();
		
		Query query = eM.createQuery("select p from Profesor p");
		List<Profesor> profesores = (List<Profesor>) query.getResultList();
		
		ArrayList<String> aRetornar = new ArrayList<String>();
		for(Profesor i: profesores) {
			if(i.getInstDep().getNombre().equals(nombreInsti)) {
				aRetornar.add(i.getNickname());
			}	
		}
		return aRetornar;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> obtenerSocios(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM= conexion.getEntityManager();
		
		Query query = eM.createQuery("select s from Socio s");
		List<Socio> socios = (List<Socio>) query.getResultList();
		
		ArrayList<String> aRetornar = new ArrayList<String>();
		for(Socio i: socios) {
			aRetornar.add(i.getNickname());
		}
		return aRetornar;
	}
	
	public DtUsuario getDtUser(String nickname) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM= conexion.getEntityManager();
		
		Usuario usuario = eM.find(Usuario.class, nickname);
		return usuario.getDtUsuario();
	}
	
	@SuppressWarnings("unchecked")
	public Usuario validarUsuario(String nickname, String password) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager eM= conexion.getEntityManager();
		
		Query query = eM.createQuery("select u from Usuario u");
		List<Usuario> usuarios = (List<Usuario>) query.getResultList();
		
		Usuario usuario = null;
		for(Usuario u: usuarios) {
			if(u.getNickname().equals(nickname) || u.getPassword().equals(password))
				usuario = u;
		}
		return usuario;
	}
	
}
