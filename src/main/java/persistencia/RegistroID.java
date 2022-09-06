package persistencia;

import java.io.Serializable;
import java.util.Objects;

public class RegistroID implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String socio;
	private String clase;

	public RegistroID() {
		super();
	}
	public RegistroID(String socio, String clase) {
		super();
		this.socio = socio;
		this.clase = clase;
	}
	public String getSocio() {
		return socio;
	}
	public void setSocio(String socio) {
		this.socio = socio;
	}
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(clase, socio);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistroID other = (RegistroID) obj;
		return Objects.equals(clase, other.clase) && Objects.equals(socio, other.socio);
	}


}
