package datatypes;

import java.util.Calendar;

public class DtUsuario {
	private String nickname;
	private String nombre; 
	private String apellido;
	private String email;
	private Calendar fechaNac;
	private String password;
	private String imagenURL;
	
	public DtUsuario(String nickname, String nombre, String apellido, String email, Calendar fechaNac, String password, String imagenURL) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNac = fechaNac;
		this.password = password;
		this.imagenURL = imagenURL;
	}
	
	public DtUsuario() {
		super();
	}

	public String getNickname() {
		return nickname;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getEmail() {
		return email;
	}

	public Calendar getFechaNac() {
		return fechaNac;
	}

	public String getPassword() {
		return password;
	}

	public String getImagenURL() {
		return imagenURL;
	}

}
