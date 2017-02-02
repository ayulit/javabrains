package org.koushik.javabrains.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.koushik.javabrains.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;


/** Responsible for talking to the DB and getting the value */
// Bean this will be automatically as we use '<context:component-scan..' at spring.xml
@Component
public class jdbcDaoImpl {

	// DataSource has driver, url etc.
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	// setter injection ?!
	@Autowired
	public void setDataSource(DataSource dataSource) {
		// this is common practice to use DataSource setter to create instance of JdbcTemplate
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	/** THIS IS NO LONGER REQUIRED BECAUSE OF SPRING */
	/* Now this method will be failed because we are not initializing dataSource!
	 * So the solution is to use JdbcTemplate here too  */
/*	public Circle getCircle(int circleId) {
		
		 JDBC code here... 
		
		 before Query Execution 
		
		Connection conn = null;
	
		try {

			
			// Creating connection
			conn = dataSource.getConnection();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM circle WHERE id = ?");
			// replace '?' with 'circleId'
			ps.setInt(1, circleId);  
			
			 after Query Execution 
			
			 We need RecordSet for execution
			Circle circle = null;
			ResultSet rs = ps.executeQuery();
			
			// getting result from ResultSet
			if (rs.next()) {
				circle = new Circle(circleId, rs.getString("name"));
			}
			
			 Don't forget to close! 
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
				 there is nothing we can do here...
			}			
		}
		
		 So, we can see how much pain we have with all of this,
		 * just for getting a single record from database :( 
	
	}*/
	
	
	/** FETCHING DATA CONCEPT USING Spring's JdbcTemplate*/
	
	/** Using JdbcTemplate make interaction with DB easy and short! */
	public int getCircleCount() {
		String sql = "SELECT COUNT(*) FROM CIRCLE";
		
		return jdbcTemplate.queryForObject(sql, Integer.class);	
	}
	
	public String getCircleName(int circleid) {
		String sql = "SELECT name FROM circle WHERE id = ?";
		
		return jdbcTemplate.queryForObject(sql, new Object[] {circleid}, String.class);		
	}
	
	/** Using Row Mapper for map whole row on object (=model) */
	public Circle getCircleforId(int circleId) {
		String sql = "SELECT * FROM circle WHERE id = ?";
		
		return jdbcTemplate.queryForObject(sql, new Object[] {circleId}, new CircleMapper());
	}
	
	/**
	 * Making class implementing RowMapper
	 * static final here is a good practice
	 * */
	private static final class CircleMapper implements RowMapper<Circle> {

		@Override
		public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
			Circle circle = new Circle();
			
			circle.setId(rs.getInt("id"));
			circle.setName(rs.getString("name"));
			
			return circle;
		}
		
	}
	
	/**
	 * Getting many all rows from DB - all the circles as a List
	 * */
	public List<Circle> getAllCircles() {
		String sql = "SELECT * FROM circle";
		
		return (List<Circle>) jdbcTemplate.query(sql, new CircleMapper());
	}
	
//	public void insertCircle(Circle circle) {
//		String sql = "INSERT INTO circle (id,name) VALUES (?,?)";
//		
//		jdbcTemplate.update(sql, new Object[] {circle.getId(), circle.getName()});
//	}
	
	/** Insert using named parameters */
	public void insertCircle(Circle circle) {
		String sql = "INSERT INTO circle (id,name) VALUES (:id, :name)";
	
		// this we will have to prepare to substitute param vales like :blah
		SqlParameterSource namedParameters = 
				new MapSqlParameterSource("id", circle.getId())
				       .addValue("name", circle.getName());
		
		// passing...
		namedParameterJdbcTemplate.update(sql, namedParameters);
		
	}
	
	public void createTriangleTable() {
		String sql = "CREATE TABLE triangle (id INTEGER, name VARCHAR(50))";
		
		jdbcTemplate.execute(sql);
	}


}
