package interfaces;

public interface IControladorLogin {
	
	public boolean validarSocio(String nickname, String password);
	
	public boolean validarProfesor(String nickname, String password);

}
