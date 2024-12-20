package interfaces;

import logic.ControladorAltaActividadDeportiva;
import logic.ControladorAltaDictadoDeClase;
import logic.ControladorAltaInstitucionDeportiva;
import logic.ControladorAltaUsuario;
import logic.ControladorConsultaAct;
import logic.ControladorConsultaClase;
import logic.ControladorConsultaUsuario;
import logic.ControladorEliminarRegistro;
import logic.ControladorLogin;
import logic.ControladorModificarActividad;
import logic.ControladorModificarInstitucion;
import logic.ControladorModificarUsuario;
import logic.ControladorRankingActividadDeportiva;
import logic.ControladorRankingClases;
import logic.ControladorRegistroClase;

public class Fabrica {
	private static Fabrica instancia = null;
	
	private Fabrica(){}
	
	public static Fabrica getInstancia() {
		if(instancia == null)
			instancia = new Fabrica();
		return instancia;
	}
	
	public IControladorAltaUsuario getIControladorAU() {
		return new ControladorAltaUsuario();
	}
	
	public IControladorAltaInstitucionDeportiva getIControladorAI() {
		return new ControladorAltaInstitucionDeportiva();
	}
	
	public IControladorAltaActividadDeportiva getIControladorAD() {
		return new ControladorAltaActividadDeportiva();
	}
	
	public IControladorAltaDictadoDeClase getIControladorAC() {
		return new ControladorAltaDictadoDeClase();
	}
	
	public IControladorConsultaAct  getIControladorCA() {
		return new ControladorConsultaAct();
	}
	
	public IControladorConsultaClase getIControladorCC() {
		return new ControladorConsultaClase();
	}
	
	public IControladorRegistroClase getIControladorRC() {
		return new ControladorRegistroClase();
	}
	
	public IControladorConsultaUsuario getIControladorCU() {
		return new ControladorConsultaUsuario();
	}
	
	public IControladorModificarUsuario getIControladorMU(){
		return new ControladorModificarUsuario();
	}
	
	public IControladorModificarInstitucion getIControladorMI(){
		return new ControladorModificarInstitucion();
	}
	
	public IControladorRankingClases getIControladorRankingC(){
		return new ControladorRankingClases();
	}
	
	public IControladorRankingActividadDeportiva getIControladorRA(){
		return new ControladorRankingActividadDeportiva();
	}
	
	public IControladorModificarActividad getIControladorMA(){
		return new ControladorModificarActividad();
	}
	
	public IControladorEliminarRegistro getIControladorER() {
		return new ControladorEliminarRegistro();
	}
	
	public IControladorLogin getIControladorLG() {
		return new ControladorLogin();
	}
	
}
