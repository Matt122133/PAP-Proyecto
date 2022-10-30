package publicadores;

import java.util.Calendar;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import exceptions.RegistroRepetidoException;
import interfaces.Fabrica;
import interfaces.IControladorRegistroClase;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorPublishRegistroSocio {
	private Fabrica fabrica;
	private IControladorRegistroClase iconRC;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;
	
	public ControladorPublishRegistroSocio() {
		fabrica = Fabrica.getInstancia();
		iconRC = fabrica.getIControladorRC();
		
		try {
			configuracion = new WebServiceConfiguracion();
		}catch (Exception ex) {
			
		}
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorRegistroClase", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorRegistroClase");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public void registroDeSocioAClase(String nombreInsti, String nombreAct, String socio, String nombreClase, Calendar fechaReg) {
		try {
			iconRC.registroSocioClase(nombreInsti, nombreAct, socio, nombreClase, fechaReg);
		} catch (RegistroRepetidoException e) {
			e.printStackTrace();
		}
	}
	
	@WebMethod
	public boolean validarInsti(String nomi) {
		return iconRC.validarInsti(nomi);
	}
	
	@WebMethod
	public boolean validarAct(String nomI,String nomA) {
		return iconRC.validarAct(nomI, nomA);
	}
	
	@WebMethod
	public boolean validarC(String nomc) {
		return iconRC.validarC(nomc);
	}
	
	@WebMethod
	public float obtenerCostoDeClase(String nomActividad, String nomInsti) {
		return iconRC.obtenerCostoClase(nomActividad, nomInsti);
	}
	
	@WebMethod
	public boolean validarRegistro(String nickSocio, String nomClase) {
		return iconRC.validarRegistro(nickSocio, nomClase);
	}
	
	
}
