package org.koushik.javabrains.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.koushik.javabrains.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


/** Responsible for talking to the DB and getting the value */
// Bean this will be automatically as we use '<context:component-scan..' at spring.xml
@Component
public class jdbcDaoImpl {

	// DataSource has driver, url etc.
	// we can use @Autowired because it is only one DataSource type 
	@Autowired
	private DataSource dataSource;
	
	// for now we will init it just here
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public Circle getCircle(int circleId) {
		
		/* JDBC code here... */
		
		/* before Query Execution */
		
		Connection conn = null;
	
		try {

			
			// Creating connection
			conn = dataSource.getConnection();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM circle WHERE id = ?");
			// replace '?' with 'circleId'
			ps.setInt(1, circleId);  
			
			/* after Query Execution */
			
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
	
	/** Using JdbcTemplate make interaction with DB easy and short! */
	public int getCircleCount() {
		String sql = "SELECT COUNT(*) FROM CIRCLE";
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.queryForObject(sql, Integer.class);	
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
