package datatypes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import logic.Registro;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtSocio extends DtUsuario{
	private List<Registro> registros = new ArrayList<Registro>();
	
	public DtSocio(String nickname, String nombre, String apellido, String email, Calendar fechaNac, String password, String imagenURL) {
		super(nickname, nombre, apellido, email, fechaNac, password, imagenURL);
	}

	public List<Registro> getRegistros() {
		return registros;
	}
	
}
