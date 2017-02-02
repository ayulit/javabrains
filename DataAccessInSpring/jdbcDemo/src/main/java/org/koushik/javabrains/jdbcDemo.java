package org.koushik.javabrains;

import org.koushik.javabrains.dao.NamedParameterJdbcDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** Main class */
public class jdbcDemo {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		NamedParameterJdbcDaoImpl dao = ctx.getBean("namedParameterJdbcDaoImpl", NamedParameterJdbcDaoImpl.class);
		
		System.out.println(dao.getCircleCount());
	}

}
