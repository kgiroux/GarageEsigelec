package fr.esigelec.garage;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import fr.esigelec.garage.Voiture;
import utils.HibernateUtil;


public class VoitureDAO {
	//D�claration d'un logger qui h�rite du RootLogger d�finit dans le log4j.properties
	private static final Logger LOGGER1 =Logger.getLogger("LOGGER1");

	VoitureDAO(){};
	public void ajouter(Voiture v){
		if(v != null){
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			// Seul ligne qui peut changer
			session.save(v);
			session.getTransaction().commit();
			session.close();
			
			LOGGER1.trace("Voiture ajout�e !");
		}
	}
<<<<<<< HEAD
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
		
	public void supprimer(Voiture v){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		// Seul ligne qui peut changer
		session.delete(v);
		session.getTransaction().commit();
		session.close();
		
		LOGGER1.trace("Voiture supprim�e !");
>>>>>>> 483eefaafed7a00a6827a7168571737530ae3f91
	}
	public void supprimer(int id){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Voiture voiture = new Voiture();
		voiture.setId(id);
		supprimer(voiture);
		
		LOGGER1.trace("Voiture supprim�e !");
	}
<<<<<<< HEAD
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
		
		
=======
	public void rouler(Voiture v, int distance){
	
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		// Seul ligne qui peut changer
		session.update(v);
		session.getTransaction().commit();
		session.close();
		
		LOGGER1.trace("Voiture a roul� !");
>>>>>>> 483eefaafed7a00a6827a7168571737530ae3f91
	}
	public Voiture get(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Voiture voi=(Voiture)session.get(Voiture.class,id);
		session.getTransaction().commit();
		session.close();
		
		LOGGER1.trace("Voiture retourn�e !");
		return voi;	
	}
	public List<Voiture> getVoitures(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "from Voiture";
		Query query = session.createQuery(hql);
		List<Voiture> vehicules=query.list();
		session.getTransaction().commit();
		session.close();LOGGER1.trace("Voitures retourn�es !");
		
		return vehicules;
	}
	
	public void deleteVoitures(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.createQuery("delete from Voiture").executeUpdate();
	}
}
