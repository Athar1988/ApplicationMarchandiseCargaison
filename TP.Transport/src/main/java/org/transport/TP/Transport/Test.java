package org.transport.TP.Transport;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.transport.TP.metier.MetierTransport;
import org.transport.TP.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		HibernateUtil.getSessionFactory();
		InterfaceTransport MT= new TransportDao();
		MT.ajouterCargaison(new CargaisonAerienne("CA1", 12.3, new Date(),200.3)); 
		MT.ajouterCargaison(new CargaisonAerienne("CA2", 20.4, new Date(),4.5)); 
		MT.ajouterCargaison(new CargaisonRoutiere("CR1", 12.3, new Date(),20.5)); 

		

		MT.ajouterMarchandiseCargaison(new Marchandise("Livres",500.1,60.2),"CA1");
		MT.ajouterMarchandiseCargaison(new Marchandise("Ordinateurs",300.2,40.2),"CA1");
		MT.ajouterMarchandiseCargaison(new Marchandise("Voitures",300.2,85.2),"CA2");
		MT.ajouterMarchandiseCargaison(new Marchandise("souries",700.1,62),"CR1");
		///MT.ajouterMarchandise(M);
		System.out.println("eeeeeee");

	}

}
