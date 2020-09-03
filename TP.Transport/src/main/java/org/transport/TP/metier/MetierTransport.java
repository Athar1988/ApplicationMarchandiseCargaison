package org.transport.TP.metier;

import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.persistence.Query;

import org.hibernate.Session;
import org.transport.TP.Transport.Cargaison;
import org.transport.TP.Transport.InterfaceTransport;
import org.transport.TP.Transport.Marchandise;
import org.transport.TP.util.HibernateUtil;

public class MetierTransport implements InterfaceMetier {
	//pour fait appel a la couche accer au donner
	private InterfaceTransport Idao;

	public InterfaceTransport getIdao() {
		return Idao;
	}

	public void setIdao(InterfaceTransport idao) {
		Idao = idao;
		System.out.println("injection dao");
	}

	@Override
	public void ajouterCargaison(Cargaison C) {
		Idao.ajouterCargaison(C);
		
	}

	@Override
	public void ajouterMarchandiseCargaison(Marchandise M, String idC) {
		Idao.ajouterMarchandiseCargaison(M, idC);
		
	}

	@Override
	public List<Cargaison> getTousCargaison() {
		List<Cargaison> C=Idao.getTousCargaison();
		return C;
	}

	@Override
	public List<Marchandise> getMarchandiseCargaison(String idC) {
		List<Marchandise> M=Idao.getMarchandiseCargaison(idC);
		return M;
	}

	@Override
	public List<Marchandise> getMarchandiseMotcle(String motcle) {
		List<Marchandise>  M=Idao.getMarchandiseMotcle(motcle);
		return M;
	}

	@Override
	public Cargaison getCargaison(String idC) {
		Cargaison C=Idao.getCargaison(idC);
		return C;
	}

	@Override
	public void supprilmerMarchandise(Long idMarchandise) {
		Idao.supprilmerMarchandise(idMarchandise);		
	}

	public void init() {
		System.out.println("Initialisation metier");
	}
}
