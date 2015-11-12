package fr.esigelec.garage;

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
	public void supprimer(Voiture v){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		// Seul ligne qui peut changer
		session.delete(v);
		session.getTransaction().commit();
		session.close();
	}
	public void supprimer(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Voiture voiture = new Voiture();
		voiture.setId(id);
		// Seul ligne qui peut changer
		session.delete(voiture);
		session.getTransaction().commit();
		session.close();
	}
	public void rouler(Voiture v, int distance){
	
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		// Seul ligne qui peut changer
		session.update(v);
		session.getTransaction().commit();
		session.close();
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
}
