package org.transport.TP.Transport;

import java.util.List;
import java.util.Set;



public interface InterfaceTransport {

	public void ajouterCargaison(Cargaison C);
	public void ajouterMarchandiseCargaison(Marchandise M, String idC);
	public List<Cargaison> getTousCargaison();
	public List<Marchandise>  getMarchandiseCargaison(String idC);
	public List<Marchandise> getMarchandiseMotcle(String motcle);
	public Cargaison getCargaison(String idC);
	public void supprilmerMarchandise(Long idMarchandise);
	void ajouterMarchandise(Marchandise M);
	
}
