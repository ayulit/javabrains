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
		
/*		Circle circle = dao.getCircle(1);
		System.out.println(circle.getName());*/
		
		System.out.println(dao.getCircleCount());
		System.out.println(dao.getCircleName(1));
		
		/* Getting whole row and get name */
		System.out.println(dao.getCircleforId(1).getName());
		
		dao.insertCircle(new Circle(3, "Third Circle"));
		
		System.out.println(dao.getAllCircles().size());
	}

}
