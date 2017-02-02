package org.koushik.javabrains.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

/** New DAO class extended from DAO Support class
 *  with data source, injected as a bean.
 * 
 *  This make us have less code! */
public class NamedParameterJdbcDaoImpl extends NamedParameterJdbcDaoSupport {
	
	/* Method almost the same as in jdbcDaoImpl.java */
	public int getCircleCount() {
		String sql = "SELECT COUNT(*) FROM CIRCLE";
		
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);	
	}
}
