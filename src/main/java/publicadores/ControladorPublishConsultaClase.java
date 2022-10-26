package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtClase;
import interfaces.Fabrica;
import interfaces.IControladorConsultaClase;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorPublishConsultaClase {
	private Fabrica fabrica;
	private IControladorConsultaClase iconCC;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;
	
	public ControladorPublishConsultaClase() {
		fabrica = Fabrica.getInstancia();
		iconCC = fabrica.getIControladorCC();
		
		try {
			configuracion = new WebServiceConfiguracion();
		}catch (Exception ex) {
			
		}
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorConsultaClase", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorConsultaClase");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public DtClase obtenerDtClasePorNomClase(String nomClase) {
		 return iconCC.obtenerDtClasePorNomClase(nomClase);
	}
	
	@WebMethod
	public DtClase[] obtenerDtClaseDeProfe(String nickProfe) {
		return iconCC.listarDtClasePorProfe(nickProfe);
	}

}
