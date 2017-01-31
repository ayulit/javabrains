package org.koushik.javabrains;

import org.koushik.javabrains.dao.jdbcDaoImpl;
import org.koushik.javabrains.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** Main class */
public class jdbcDemo {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		jdbcDaoImpl dao = ctx.getBean("jdbcDaoImpl", jdbcDaoImpl.class);
		
		Circle circle = dao.getCircle(1);
		System.out.println(circle.getName());
				
	}

}
