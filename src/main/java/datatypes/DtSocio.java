package datatypes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import logic.Registro;

public class DtSocio extends DtUsuario{
	private List<Registro> registros = new ArrayList<Registro>();
	
	public DtSocio(String nickname, String nombre, String apellido, String email, Calendar fechaNac, String password/*, byte[] imagen*/) {
		super(nickname, nombre, apellido, email, fechaNac, password/*, imagen*/);
	}

	public List<Registro> getRegistros() {
		return registros;
	}
	
}
