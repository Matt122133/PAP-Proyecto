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
import interfaces.IControladorModificarUsuario;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorPublishModificarUsuario {
	private Fabrica fabrica;
	private IControladorModificarUsuario iconMU;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;
	
	public ControladorPublishModificarUsuario() {
		fabrica = Fabrica.getInstancia();
		iconMU = fabrica.getIControladorMU();
		
		try {
			configuracion = new WebServiceConfiguracion();
		}catch (Exception ex) {
			
		}
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorModificarUsuario", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorModificarUsuario");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public boolean validarProf(String nickname) {
		return iconMU.validarProfe(nickname);
	}
	
	@WebMethod
	public boolean validarSocio(String nickname) {
		return iconMU.validarSocio(nickname);
	}
	
	@WebMethod
	public void modificarUsuario(DtUsuario dtUser) {
		iconMU.modificarUsuario(dtUser);
	}
	
	@WebMethod
	public void modificarSocio(DtSocio dtSocio) {
		iconMU.modificarSocio(dtSocio);
	}
	
	@WebMethod
	public void modificarProfe(DtProfesor dtProf) {
		iconMU.modificarProfesor(dtProf);
	}
	
	@WebMethod
	public void obtenerProfe(String nickname) {
		iconMU.obtenerProfesor(nickname);
	}
	
	@WebMethod
	public void obtenerSocio(String nickname) {
		iconMU.obtenerSocio(nickname);
	}
	
}
