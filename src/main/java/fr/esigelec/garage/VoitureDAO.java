package fr.esigelec.garage;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import fr.esigelec.garage.Voiture;
import utils.HibernateUtil;


public class VoitureDAO {
	//Déclaration d'un logger qui hérite du RootLogger définit dans le log4j.properties
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
			
			LOGGER1.trace("Voiture ajoutée !");
		}
	}
	public void supprimer(Voiture v){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		// Seul ligne qui peut changer
		session.delete(v);
		session.getTransaction().commit();
		session.close();
		
		LOGGER1.trace("Voiture supprimée !");
	}
	public void supprimer(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Voiture voiture = new Voiture();
		voiture.setId(id);
		supprimer(voiture);
		
		LOGGER1.trace("Voiture supprimée !");
	}
	public void rouler(Voiture v, int distance){
	
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		// Seul ligne qui peut changer
		session.update(v);
		session.getTransaction().commit();
		session.close();
		
		LOGGER1.trace("Voiture a roulé !");
	}
	public Voiture get(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Voiture voi=(Voiture)session.get(Voiture.class,id);
		session.getTransaction().commit();
		session.close();
		
		LOGGER1.trace("Voiture retournée !");
		return voi;	
	}
	public List<Voiture> getVoitures(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "from Voiture";
		Query query = session.createQuery(hql);
		List<Voiture> vehicules=query.list();
		session.getTransaction().commit();
		session.close();LOGGER1.trace("Voitures retournées !");
		
		return vehicules;
	}
}
