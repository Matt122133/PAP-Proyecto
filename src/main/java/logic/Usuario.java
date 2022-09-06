package logic;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import datatypes.DtUsuario;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {
	@Id
	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private Calendar fechaNac;
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Calendar getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Calendar fechaNac) {
		this.fechaNac = fechaNac;
	}
	public Usuario(String nickname, String nombre, String apellido, String email, Calendar fechaNac) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNac = fechaNac;
	}
	public Usuario() {
		super();
	}
	
	
	public abstract DtUsuario getDtUsuario();
	
}
