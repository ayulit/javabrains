package org.koushnik.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushnik.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
		
		user.setUserId(1);
		user.setUserName("First User");
		
		// now we need persist the object to the DB
        // let's use Hibernate API without DAO!
		
		// reading configuration file and creating a session factory		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		// open new session from SessionFactory object
		Session session = sessionFactory.openSession();
		
		// need to create a transaction
		session.beginTransaction();
		
		// saving object
		session.save(user);
		
		// after saving we will have to end the transaction
		session.getTransaction().commit();
		
		
	}

}
