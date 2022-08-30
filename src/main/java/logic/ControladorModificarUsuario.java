package logic;

import java.util.ArrayList;

import datatypes.DtUsuario;
import interfaces.IControladorModificarUsuario;

public class ControladorModificarUsuario implements IControladorModificarUsuario{
	
	public void ModificarUsuario(DtUsuario modificado) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario aModificar = mU.buscarUsuario(modificado.getNickname());
		if(aModificar instanceof Profesor) {
			((Profesor) aModificar).actualizarProfe(modificado);
		}
		else if(aModificar instanceof Socio) {
			((Socio) aModificar).actualizarSocio(modificado);
		}
	}
	
	
	public String[] listarUsuarios() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ArrayList<String> arrayUsuarios = mU.obtenerUsuarios();
		String[] arrayUsuarios_ret = new String[arrayUsuarios.size()];
		int a=0;
		for(String i:arrayUsuarios) {
			arrayUsuarios_ret[a]=i;
			a++;
		}
		return arrayUsuarios_ret;
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
	
	
	public DtUsuario obtenerUserDt(String user) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		return mU.getDtUser(user);
	}


}
