package publicadores;

import java.util.Calendar;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import exceptions.ClaseRepetidaException;
import interfaces.Fabrica;
import interfaces.IControladorAltaDictadoDeClase;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorPublishAltaClase {
	private Fabrica fabrica;
	private IControladorAltaDictadoDeClase iconAC;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;
	
	public ControladorPublishAltaClase() {
		fabrica = Fabrica.getInstancia();
		iconAC = fabrica.getIControladorAC();
		
		try {
			configuracion = new WebServiceConfiguracion();
		}catch (Exception ex) {
			
		}
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorAltaDictadoDeClase", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorAltaDictadoDeClase");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public void altaDictadoClase(String nombreInst, String nombreAct, String nicknameProf, String nombre, Calendar fecha, int horaIni, String url, Calendar fechaReg, String imagenClaseURL){
			try {
				iconAC.altaDictadoClase(nombreInst, nombreAct, nicknameProf, nombre, fecha, horaIni, url, fechaReg, imagenClaseURL);
			} catch (ClaseRepetidaException e) {
				e.printStackTrace();
			}
		
	}
	
	@WebMethod
	public boolean validarInsti(String nomi) {
		return iconAC.validarInsti(nomi);
	}
	
	@WebMethod
	public boolean validarAct(String nomI,String nomA) {
		return iconAC.validarAct(nomI, nomA);
	}
	
	@WebMethod
	public boolean validarC(String nomc) {
		return iconAC.validarC(nomc);
	}
	
	

}
