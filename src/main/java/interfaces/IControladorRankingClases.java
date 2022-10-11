package interfaces;

import java.util.List;

import datatypes.DtClase;

public interface IControladorRankingClases {

	
	public String[] listarClases();
	
	public List<DtClase> clasesOrdenadas();
}
