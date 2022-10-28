package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import interfaces.Fabrica;
import interfaces.IControladorConsultaUsuario;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorPublishConsultaUsuario {
	private Fabrica fabrica;
	private IControladorConsultaUsuario iconCU;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;
	
	public ControladorPublishConsultaUsuario() {
		fabrica = Fabrica.getInstancia();
		iconCU = fabrica.getIControladorCU();
		
		try {
			configuracion = new WebServiceConfiguracion();
		}catch (Exception ex) {
			
		}
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorConsultaUsuario", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorConsultaUsuario");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public DtProfesor obtenerDtProfe(String nickname) {
		return iconCU.obtenerDtProfesor(nickname);
	}
	
	@WebMethod
	public DtSocio obtenerDtSocio(String nickname) {
		return iconCU.obtenerDtSocio(nickname);
	}
	
	@WebMethod
	public boolean validarProf(String nickname) {
		return iconCU.validarProfe(nickname);
	}
	
	@WebMethod
	public boolean validarSocio(String nickname) {
		return iconCU.validarSocio(nickname);
	}
	
	@WebMethod
	public DtUsuario obtenerUserDt(String nickname) {
		return iconCU.obtenerUserDt(nickname);
	}
	
	@WebMethod
	public String[] sociosRegistros(String nickname) {
		return iconCU.registroSocios(nickname);
	}
	
}
