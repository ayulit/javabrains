package org.javabrains.koushnik.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/** This is model class */
@Entity (name="USER_DETAILS")
public class UserDetails {

	// @Id used for Primary Key 
	@Id
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="USER_NAME")
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
