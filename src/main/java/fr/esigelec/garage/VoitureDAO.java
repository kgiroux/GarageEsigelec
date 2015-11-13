package fr.esigelec.garage;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.esigelec.garage.Voiture;
import utils.HibernateUtil;

public class VoitureDAO {

	VoitureDAO(){};
	public void ajouter(Voiture v){
		if(v != null){
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			// Seul ligne qui peut changer
			session.save(v);
			session.getTransaction().commit();
			session.close();
		}
	}
	public void supprimer(Voiture v) throws AssertionError{
		if(v != null){
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			// Seul ligne qui peut changer
			session.delete(v);
			session.getTransaction().commit();
			session.close();
		}else{
			throw new AssertionError();
		}
		
	}
	public void supprimer(int id){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Voiture voiture = new Voiture();
		voiture.setId(id);
		supprimer(voiture);
	}
	public void rouler(Voiture v , int distance) throws AssertionError, InvalidParameterException, IllegalArgumentException{
		if(v != null){
			if(distance >= 0){
				long  value = v.getKm()*1L + distance *1L;
				if((value) < Integer.MAX_VALUE){
					Session session = HibernateUtil.getSessionFactory().openSession();
					session.beginTransaction();
					// Seul ligne qui peut changer
					v.setKm(v.getKm() + distance);
					try{
						session.saveOrUpdate(v);
						session.getTransaction().commit();
					}catch(Exception e){
						e.printStackTrace();
						session.getTransaction().rollback();
					}
					finally{
						
						session.close();
					}
					
					
				}else{
					throw new IllegalArgumentException();
				}
			}else{
				throw new InvalidParameterException();
			}
			
		}else{
			throw new AssertionError();
		}
		
		
	}
	public Voiture get(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Voiture voi=(Voiture)session.get(Voiture.class,id);
		session.getTransaction().commit();
		session.close();
		return voi;	
	}
	public List<Voiture> getVoitures(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "from Voiture";
		Query query = session.createQuery(hql);
		List<Voiture> vehicules=query.list();
		session.getTransaction().commit();
		session.close();
		return vehicules;
	}
	
	public void deleteVoitures(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.createQuery("delete from Voiture").executeUpdate();
	}
}
