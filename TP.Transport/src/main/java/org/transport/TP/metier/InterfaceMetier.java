package org.transport.TP.metier;

import java.util.List;

import org.transport.TP.Transport.Cargaison;
import org.transport.TP.Transport.Marchandise;

public interface InterfaceMetier {
	public void ajouterCargaison(Cargaison C);
	public void ajouterMarchandiseCargaison(Marchandise M, String idC);
	public List<Cargaison> getTousCargaison();
	public List<Marchandise>  getMarchandiseCargaison(String idC);
	public List<Marchandise> getMarchandiseMotcle(String motcle);
	public Cargaison getCargaison(String idC);
	public void supprilmerMarchandise(Long idMarchandise);	
}
