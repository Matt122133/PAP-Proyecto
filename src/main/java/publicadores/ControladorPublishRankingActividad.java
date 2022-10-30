package publicadores;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtActividadDeportiva;
import interfaces.Fabrica;
import interfaces.IControladorRankingActividadDeportiva;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorPublishRankingActividad {
	private Fabrica fabrica;
	private IControladorRankingActividadDeportiva iconRA;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;
	
	public ControladorPublishRankingActividad() {
		fabrica = Fabrica.getInstancia();
		iconRA = fabrica.getIControladorRA();
		
		try {
			configuracion = new WebServiceConfiguracion();
		}catch (Exception ex) {
			
		}
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorRankingActividadDeportiva", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorRankingActividadDeportiva");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public DtActividadDeportiva[] listarActividadesOrdenadasPorClases() {
		List<DtActividadDeportiva> lstActs = iconRA.actOrdenadas();
		DtActividadDeportiva[] dtAct = new DtActividadDeportiva[lstActs.size()];
		int a = 0;
		for(DtActividadDeportiva i: lstActs) {
			dtAct[a] = i;
			a++;
		}
		return dtAct;
	}
	
}
