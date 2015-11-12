package utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory buildSessionFactory() {
	// La SessionFactory est initialis�e une seule fois pour toute l'application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
		.configure() // configuration � partir du fichier hibernate.cfg.xml
		.build();
		try {
			sessionFactory = new MetadataSources( registry).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			StandardServiceRegistryBuilder.destroy( registry );
		}
		return sessionFactory;
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}