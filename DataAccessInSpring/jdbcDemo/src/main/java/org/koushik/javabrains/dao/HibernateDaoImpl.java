package org.koushik.javabrains.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// @Repository makes this class a Spring bean called 'hibernateDaoImpl'
@Repository
public class HibernateDaoImpl {
	
	// we need to create it to use Hibernate, it must be only one!
	// it needed to be injected using @Autowired,
	// because bean's type AnnotationSessionFactoryBean is the only available 
	@Autowired
	private SessionFactory sessionFactory;
	
	public int getCircleCount() {
		// using HQL - Hibernate Query Language
		// 'Circle' here is an entity, not a table!!
		String hql = "select count(*) from Circle";
		
		// creating session and getting access to it
		// Query - is a Hibernate query
		Query query = getSessionFactory().openSession().createQuery(hql);
		
		// Executing query and returning the result
		return ((Long) query.uniqueResult()).intValue();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
