package org.javabrains.koushnik.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/** This is model class */
@Entity
public class UserDetails {

	// @Id used for Primary Key 
	@Id
	private int userId;
	
	private String userName;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
