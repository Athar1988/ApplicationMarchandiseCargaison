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

public class MetierTransport implements InterfaceTransport{

	@Override
	public void ajouterCargaison(Cargaison C) {
	        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	        session.beginTransaction();
	        
	        try {
	        session.save(C);
	        }catch(Exception e){
	        	session.getTransaction().rollback();
	        	e.printStackTrace();
	        }
	        session.getTransaction().commit();
		}

	@Override
	public void ajouterMarchandise(Marchandise M) {
	        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	        session.beginTransaction();
	        try {
	        session.save(M);
	        }catch(Exception e){
	        	session.getTransaction().rollback();
	        	e.printStackTrace();
	        }
	        session.getTransaction().commit();
		}


	@SuppressWarnings("unchecked")
	@Override
	public void ajouterMarchandiseCargaison(Marchandise M, String idC) {
		  Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	        session.beginTransaction();
	        try {
	        Query requete1=session.createQuery("select c.marchandise from Cargaison c where  c.id="+idC);
	        Set<Marchandise>  Listmarch=(Set<Marchandise>) requete1.getResultList();
	        Listmarch.add(M);
	        Query requete2=session.createQuery("update Cargaison set marchandise =:march");
	        requete2.setParameter("march", Listmarch);
	        }catch(Exception e){
	        	session.getTransaction().rollback();
	        	e.printStackTrace();
	        }
	        session.getTransaction().commit();
		
	}

	public List<Cargaison> getTousCargaison() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query req=session.createQuery("select c from Cargaison c");
        List<Cargaison>  carg=req.getResultList();
        session.getTransaction().commit();
		return carg;
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	public List<Marchandise> getMarchandiseCargaison(String idC) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query req=session.createQuery("select c.marchandise from Cargaison c where  c.id like :id");
        req.setParameter("x", idC);
        List<Marchandise>  march=req.getResultList();
        session.getTransaction().commit();
		return march;
	}

	@Override
	public List<Marchandise> getMarchandiseMotcle(String motcle) {
		// TODO Auto-Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
        Query req=session.createQuery("select m from Marchandise m where m.nomMarchandise like :x");
        req.setParameter("x", "%"+motcle+"%");
        List<Marchandise>  listMarch=req.getResultList();
        session.getTransaction().commit(); 
		return listMarch;
	}

	@Override
	public Cargaison getCargaison(String idC) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query req=session.createQuery("select c from Cargaison c where c.id="+idC);
        Cargaison carg=(Cargaison) req.getParameters();
        session.getTransaction().commit();		
        return carg;
	}

	@Override
	public void supprilmerMarchandise(Long idMarchandise) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Object o=session.get(Marchandise.class, idMarchandise);
        if(o==null) throw new RuntimeException("Marchandise introuvable");
        session.delete(o);
        session.getTransaction().commit();
		
	}



}
