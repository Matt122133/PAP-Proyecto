package datatypes;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class DtSocio extends DtUsuario{
	//private List<Registro> registros = new ArrayList<Registro>();
	
	public DtSocio(String nickname, String nombre, String apellido, String email, Calendar fechaNac, String password, String imagenURL) {
		super(nickname, nombre, apellido, email, fechaNac, password, imagenURL);
	}

	/*public List<Registro> getRegistros() {
		return registros;
	}*/
	
}
