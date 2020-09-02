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
	public void ajouterMarchandiseCargaison(Marchandise M, String refCarg) {
	        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	        session.beginTransaction();
	        Cargaison C =(Cargaison)session.get(Cargaison.class, refCarg);
	        //associer les objets dans les 2 sens relation bi-relationnelle
	        M.setCargaison(C);C.getMarchandise().add(M);
	        try {
	        session.save(M);
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
        Query req=session.createQuery("select m from Marchandise m where  m.Cargaison.Ref_carg=:x");
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
	public Cargaison getCargaison(String refCarg) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
      /*  Query req=session.createQuery("select c from Cargaison c where c.Ref_carg=x");
        req.setParameter("x", refCarg);
        Cargaison carg=(Cargaison) req.getParameters();*/
        Cargaison carg1=(Cargaison) session.get(Cargaison.class, refCarg);
        session.getTransaction().commit();		
        return carg1;
	}

	@Override
	public void supprilmerMarchandise(Long idMarchandise) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Marchandise o=session.get(Marchandise.class, idMarchandise);
        if(o==null) throw new RuntimeException("Marchandise introuvable");
        session.delete(o);
        session.getTransaction().commit();
		
	}



}
