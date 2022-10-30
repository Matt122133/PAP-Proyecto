package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import exceptions.SocioNoRegistrado;
import interfaces.Fabrica;
import interfaces.IControladorEliminarRegistro;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorPublishEliminarRegistro {
	private Fabrica fabrica;
	private IControladorEliminarRegistro iconER;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;
	
	public ControladorPublishEliminarRegistro() {
		fabrica = Fabrica.getInstancia();
		iconER = fabrica.getIControladorER();
		
		try {
			configuracion = new WebServiceConfiguracion();
		}catch (Exception ex) {
			
		}
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorEliminarRegistro", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorEliminarRegistro");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public void eliminarRegistro(String nomSocio, String nombreClase, String nombreInsti, String nombreAct) {
		try {
			iconER.eliminarRegistro(nomSocio, nombreClase, nombreInsti, nombreAct);
		} catch (SocioNoRegistrado e){
			e.printStackTrace();
		}
	}
}
