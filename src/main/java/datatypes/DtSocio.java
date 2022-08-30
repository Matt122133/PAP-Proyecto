package datatypes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import logic.Registro;

public class DtSocio extends DtUsuario{
	private List<Registro> registros = new ArrayList<Registro>();
	
	public DtSocio(String nickname, String nombre, String apellido, String email, Calendar fechaNac) {
		super(nickname, nombre, apellido, email, fechaNac);
		
	}

	public List<Registro> getRegistros() {
		return registros;
	}
	
}
