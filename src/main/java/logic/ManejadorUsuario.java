package logic;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtUsuario;

public class ManejadorUsuario {
	private static ManejadorUsuario instancia = null;
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public static ManejadorUsuario getInstancia() {
		if(instancia == null)
			instancia = new ManejadorUsuario();
		return instancia;
	}
	
	public void agregarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public Usuario buscarUsuario(String nickname) {
		Usuario retorno = null;
		for(Usuario u: usuarios) {
			if(u.getNickname().equals(nickname))
				retorno = u;
		}
		return retorno;
	}
	
	public ArrayList<String> obtenerUsuarios(){
		ArrayList<String> aRetornar = new ArrayList<String>();
		for(Usuario i: usuarios) {
			aRetornar.add(i.getNickname());		
		}
		return aRetornar;
	}
	
	public ArrayList<String> obtenerProfes(String nombreInsti){
		ArrayList<String> aRetornar = new ArrayList<String>();
		for(Usuario i: usuarios) {
			if (i instanceof Profesor) {
				if(((Profesor) i).getInstDep().getNombre().equals(nombreInsti)) {
					aRetornar.add(i.getNickname());
				}
			}	
		}
		return aRetornar;
	}
	
	public ArrayList<String> obtenerSocios(){
		ArrayList<String> aRetornar = new ArrayList<String>();
		for(Usuario i: usuarios) {
			if (i instanceof Socio) {
				aRetornar.add(i.getNickname());
			}	
		}
		return aRetornar;
	}
	
	public DtUsuario getDtUser(String nick) {
		Usuario user = this.buscarUsuario(nick);
		return user.getDtUsuario();
	}
	
}
