package org.koushnik.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushnik.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();		
		user.setUserName("First User");

		UserDetails user2 = new UserDetails();		
		user2.setUserName("Second User");
		
		/* now we need persist the object to the DB
           let's use Hibernate API without DAO! */
		
		// reading configuration file and creating a session factory		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		// open new session from SessionFactory object
		Session session = sessionFactory.openSession();
		
		// need to create a transaction
		session.beginTransaction();
		
		// saving objects
		session.save(user);
		session.save(user2);
		
		// after saving we will have to end the transaction
		session.getTransaction().commit();
		
		// closing session
		session.close();
		
		/* Let's fetch user from DB now */
		
		user = null;
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		// fetching: specify class and what data do we need,
		// Primary Key field usually, e.g. =1 here	
		user = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println("User Name retrieved is " + user.getUserName());
	}

}
