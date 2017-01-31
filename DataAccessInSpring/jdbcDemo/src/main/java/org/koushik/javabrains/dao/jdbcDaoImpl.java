package org.koushik.javabrains.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.koushik.javabrains.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/** Responsible for talking to the DB and getting the value */
// Bean this will be automatically as we use '<context:component-scan..' at spring.xml
@Component
public class jdbcDaoImpl {

	// DataSource has driver, url etc.
	// we can use @Autowired because it is only one DataSource type 
	@Autowired
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public Circle getCircle(int circleId) {
		
		/* JDBC code here... */
		
		Connection conn = null;
	
		try {

			
			// Creating connection
			conn = dataSource.getConnection();
			
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
