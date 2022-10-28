package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtActividadDeportiva;
import interfaces.Fabrica;
import interfaces.IControladorConsultaAct;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorPublishConsultaActividad {
	private Fabrica fabrica;
	private IControladorConsultaAct iconCA;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;
	
	public ControladorPublishConsultaActividad() {
		fabrica = Fabrica.getInstancia();
		iconCA = fabrica.getIControladorCA();
		
		try {
			configuracion = new WebServiceConfiguracion();
		}catch (Exception ex) {
			
		}
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorConsultaAct", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorConsultaAct");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public String[] listarActividades() {
		return iconCA.listarActividades();
	}
	
	@WebMethod
	public DtActividadDeportiva obtenerDtActvidadDep(String nomAct) {
		return iconCA.obtenerDtAct(nomAct);
	}
	
	@WebMethod
	public String[] listarClasesDeActividad(String nomAct) {
		return iconCA.listarClasesDeAct(nomAct);
	}
}
