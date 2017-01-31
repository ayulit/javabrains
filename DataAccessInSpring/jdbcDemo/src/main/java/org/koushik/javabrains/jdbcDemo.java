package org.koushik.javabrains;

import org.koushik.javabrains.dao.jdbcDaoImpl;
import org.koushik.javabrains.model.Circle;

/** Main class */
public class jdbcDemo {

	public static void main(String[] args) {
		Circle circle = new jdbcDaoImpl().getCircle(1);
		System.out.println(circle.getName());
	}

}
