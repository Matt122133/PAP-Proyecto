package publicadores;

import java.util.Calendar;

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
	public void modificarSocio(String nickname, String nombre, String apellido, Calendar fechaNac, String password ,String imagenURL) {
		iconMU.modificarSocio(nickname, nombre, apellido, fechaNac, password, imagenURL);
	}
	
	@WebMethod
	public void modificarProfe(String nickname, String nombre, String apellido, Calendar fechaNac, String password, String imagenURL, String descripcion,
			String biografia, String sitioWeb, String instDep) {
		iconMU.modificarProfesor(nickname, nombre, apellido, fechaNac, password, imagenURL, descripcion, biografia, sitioWeb, instDep);
	}
	
	@WebMethod
	public DtUsuario obtenerDtUsuario(String nickname) {
		return iconMU.obtenerUserDt(nickname);
	}
	
	@WebMethod
	public DtSocio obtenerDtSocio(String nickname) {
		return iconMU.obtenerDtSocio(nickname);
	}
	
	@WebMethod
	public DtProfesor obtenerDtProfesor(String nickname) {
		return iconMU.obtenerDtProfesor(nickname);
	}
	
	
}
