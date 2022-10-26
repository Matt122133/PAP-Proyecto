package logic;

import interfaces.IControladorLogin;

public class ControladorLogin implements IControladorLogin {
	
	public boolean validarSocio(String nickname, String password) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario user = mU.buscarUsuario(nickname);
		if(user != null && user.getPassword().equals(password)) {
			if(user instanceof Socio) {
				return true;
			}	
		}
		
		return false;
		
}
	
	public boolean validarProfesor(String nickname, String password) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario user = mU.buscarUsuario(nickname);
		if(user != null && user.getPassword().equals(password)) {
			if(user instanceof Profesor) {
				return true;
			}
		}
		return false;
	}
	
}
