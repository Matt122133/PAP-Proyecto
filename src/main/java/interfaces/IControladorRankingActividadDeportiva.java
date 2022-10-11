package interfaces;

import java.util.List;

import datatypes.DtActividadDeportiva;

public interface IControladorRankingActividadDeportiva {

	
	public String[] listarActividades();
	
	public List<DtActividadDeportiva> obtenerDtActividad();
	
	public List<DtActividadDeportiva> actOrdenadas();
	
}
