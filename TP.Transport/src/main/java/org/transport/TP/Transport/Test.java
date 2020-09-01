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
		InterfaceTransport MT= new MetierTransport();
		Cargaison CA= new CargaisonAerienne("Aerienne", 12.3, new Date(),200.3);
		MT.ajouterCargaison(CA); 
		Cargaison CR= new CargaisonRoutiere("Routiere", 12.3, new Date(),20.5);
		MT.ajouterCargaison(CR); 
		Marchandise M= new Marchandise("livre", 12.3, 10.2) ;
		MT.ajouterMarchandise(M);
		System.out.println("eeeeeee");

	}

}
