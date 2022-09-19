package logic;

import java.util.ArrayList;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import exceptions.UsuarioRepetidoException;
import interfaces.IControladorAltaUsuario;

public class ControladorAltaUsuario implements IControladorAltaUsuario {
	
	public ControladorAltaUsuario() {
		super();
	}
	
	@SuppressWarnings("null")
	public void altaUsuario(DtUsuario usuario) throws UsuarioRepetidoException {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		Usuario nuevoUsuario = mU.existeUsuario(usuario.getNickname(),usuario.getEmail());
		
		if (nuevoUsuario != null) 
			throw new UsuarioRepetidoException("El usuario con nickname " + usuario.getNickname() +  " o con el email " + usuario.getEmail() + " ya esta registrado.");
			
		if (usuario instanceof DtSocio)
			nuevoUsuario = new Socio(usuario.getNickname(), usuario.getNombre(), usuario.getApellido(), usuario.getEmail(), usuario.getFechaNac(), usuario.getPassword(), usuario.getImagen());
		
		if (usuario instanceof DtProfesor) {
			InstitucionDeportiva instDep = mI.buscarInstitucion(((DtProfesor) usuario).getInstDep());
			nuevoUsuario = new Profesor(usuario.getNickname(), usuario.getNombre(), usuario.getApellido(), usuario.getEmail(), usuario.getFechaNac(), usuario.getPassword(), usuario.getImagen() , ((DtProfesor) usuario).getDescripcion(), ((DtProfesor) usuario).getBiografia(), ((DtProfesor) usuario).getSitioWeb(), instDep);
		}
		mU.agregarUsuario(nuevoUsuario);
	}
	
	public String[] listarInstituciones() {
		ArrayList<String> instituciones;
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		instituciones = mI.obtenerInstituciones();
		String[] instituciones_ret = new String[instituciones.size()];
        int a=0;
        for(String i:instituciones) {
        	instituciones_ret[a]=i;
        	a++;
        }
        return instituciones_ret;
	}
	
}
