package interfaces;

import java.util.Calendar;

import exceptions.ClaseRepetidaException;

public interface IControladorAltaDictadoDeClase {
	
	public void altaDictadoClase(String nombreInst, String nombreAct, String nombreProf, String nombre, Calendar fecha, int horaIni, String url, Calendar fechaReg, String imagenClaseURL) throws ClaseRepetidaException;
	
	public String[] listarInstituciones();
	
	public String[] obtenerActividadesDeportivas(String nombreinsti);
	
	public String[] obtenerProfesor(String nombreInsti);
	
	public boolean validarInsti(String nomi);
	
	public boolean validarAct(String nomi,String noma);
	
	public boolean validarC(String nomc);
}
