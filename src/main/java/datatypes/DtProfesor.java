package datatypes;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtProfesor extends DtUsuario{
	private String descripcion;
	private String biografia;
	private String sitioWeb;
	private String instDep;
	//private List<Clase> clases = new ArrayList<Clase>();

	public DtProfesor(String nickname, String nombre, String apellido, String email, Calendar fechaNac, String password, String imagenURL, String descripcion, String biografia, String sitioWeb, String instDep) {
		super(nickname, nombre, apellido, email, fechaNac, password, imagenURL);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioWeb = sitioWeb;
		this.instDep = instDep;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public String getBiografia() {
		return biografia;
	}
	public String getSitioWeb() {
		return sitioWeb;
	}
	public String getInstDep() {
		return instDep;
	}
	
	/*public List<Clase> getClases() {
		return clases;
	}*/
	
	
}
