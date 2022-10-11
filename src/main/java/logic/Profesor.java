package logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import datatypes.DtClase;
import datatypes.DtProfesor;
import datatypes.DtUsuario;

@Entity
public class Profesor extends Usuario{
	private String descripcion;
	private String biografia;
	private String sitioWeb;
	
	@ManyToOne
	private InstitucionDeportiva instDep;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Clase> clases = new ArrayList<Clase>();
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getBiografia() {
		return biografia;
	}
	
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	
	public String getSitioWeb() {
		return sitioWeb;
	}
	
	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}
	
	public InstitucionDeportiva getInstDep() {
		return instDep;
	}
	
	public void setInstDep(InstitucionDeportiva instDep) {
		this.instDep = instDep;
	}
	
	public List<Clase> getClases() {
		return clases;
	}
	
	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}
	
	public Profesor(String nickname, String nombre, String apellido, String email, Calendar fechaNac, String password, String imagenURL, String descripcion,
		String biografia, String sitioWeb, InstitucionDeportiva instDep) {
		super(nickname, nombre, apellido, email, fechaNac, password, imagenURL);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioWeb = sitioWeb;
		this.instDep = instDep;
	}
	
	public Profesor(String nickname, String nombre, String apellido, String email, Calendar fechaNac, String password, String imagenURL) {
		super(nickname, nombre, apellido, email, fechaNac, password , imagenURL);
	}
	
	public Profesor() { 
		super(); 
	}
	
	public void agregarClase(Clase clase) {
		clases.add(clase);
	}
	
	public Clase buscarClase(String nombreClase) {
		Clase claseRet = null;
		for(Clase i:clases) {
			if(i.getNombre().equals(nombreClase)) {
				claseRet = i;
			}
		}
		return claseRet;
	}
	
	public ArrayList<String> obtenerClases(){
		ArrayList<String> arrayClase_ret = new ArrayList<String>();
		for(Clase i: clases) {
			arrayClase_ret.add(i.getNombre());
		}
		return arrayClase_ret;
	}
	
	public ArrayList<DtClase> obtenerDtClases(){
		ArrayList<DtClase> arrayClase_ret = new ArrayList<DtClase>();
		for(Clase i: clases) {
			arrayClase_ret.add(i.getDtClase());
		}
		return arrayClase_ret;
	}
	
	
	public void actualizarProfe(DtUsuario actualizado) {
		if (actualizado instanceof DtProfesor) {
			this.setNombre(actualizado.getNombre());
			this.setApellido(actualizado.getApellido());
			this.setEmail(actualizado.getEmail());
			this.setFechaNac(actualizado.getFechaNac());
			this.setNickname(actualizado.getNickname());
			this.setPassword(actualizado.getPassword());
			this.setImagenURL(actualizado.getImagenURL());
			ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
			InstitucionDeportiva instDeportiva = mI.buscarInstitucion(((DtProfesor) actualizado).getInstDep());
			this.setInstDep(instDeportiva);
			this.setBiografia(((DtProfesor) actualizado).getBiografia());
			this.setDescripcion(((DtProfesor) actualizado).getDescripcion());
			this.setSitioWeb(((DtProfesor) actualizado).getSitioWeb());
		}
	}
	
	@Override
	public DtUsuario getDtUsuario() {
		return new DtProfesor(this.getNickname(), this.getNombre(),this.getApellido(), this.getEmail(), this.getFechaNac(), this.getPassword(), this.getImagenURL(), this.getDescripcion(), this.getBiografia(), this.getSitioWeb() ,this.getInstDep().getNombre());
	}
	
}
