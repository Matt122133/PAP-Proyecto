package publicadores;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtClase;
import interfaces.Fabrica;
import interfaces.IControladorRankingClases;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorPublishRankingClases {
	private Fabrica fabrica;
	private IControladorRankingClases iconRC;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;
	
	public ControladorPublishRankingClases() {
		fabrica = Fabrica.getInstancia();
		iconRC = fabrica.getIControladorRankingC();
		
		try {
			configuracion = new WebServiceConfiguracion();
		}catch (Exception ex) {
			
		}
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorRankingClases", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorRankingClases");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public DtClase[] listarClasesOrdenadasPorSocios() {
		List<DtClase> lstClases = iconRC.clasesOrdenadas();
		DtClase[] dtc = new DtClase[lstClases.size()];
		int a = 0;
		for(DtClase i: lstClases) {
			dtc[a] = i;
			a++;
		}
		return dtc;
	}
}
