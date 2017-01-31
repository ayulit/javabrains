package org.koushik.javabrains.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.koushik.javabrains.model.Circle;
import org.springframework.stereotype.Component;


/** Responsible for talking to the DB and getting the value */
// Bean this will be automatically as we use '<context:component-scan..' at spring.xml
@Component
public class jdbcDaoImpl {
	
	public Circle getCircle(int circleId) {
		
		/* JDBC code here... */
		
		Connection conn = null;
		// we use server, configured on our system with existed db
		String url = "jdbc:derby://localhost:1527/db";
		
		// we use client driver from Derby client dependency
		String driver = "org.apache.derby.jdbc.ClientDriver";
		
		try {
			// Initializing driver		
			Class.forName(driver).newInstance();
			
			// Creating connection
			conn = DriverManager.getConnection(url);
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM circle WHERE id = ?");
			// replace '?' with 'circleId'
			ps.setInt(1, circleId);  
			
			/* We need RecordSet for execution*/
			Circle circle = null;
			ResultSet rs = ps.executeQuery();
			
			// getting result from ResultSet
			if (rs.next()) {
				circle = new Circle(circleId, rs.getString("name"));
			}
			
			/* Don't forget to close! */
			rs.close();
			ps.close();
			
			return circle;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				conn.close();	
			} catch (SQLException e) {
				/* there is nothing we can do here...*/
			}			
		}
		
		/* So, we can see how much pain we have with all of this,
		 * just for getting a single record from database :( */
	
	}
}
