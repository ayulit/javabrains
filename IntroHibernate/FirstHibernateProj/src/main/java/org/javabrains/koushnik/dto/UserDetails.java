package org.javabrains.koushnik.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/** This is model class */
@Entity (name="USER_DETAILS")
public class UserDetails {

	private int userId;	
	private String userName;

	// We can place annots on getters instead!
	// so Hibernate picks up the value from getter 
	
	// @Id used for Primary Key 
	@Id
	@Column(name="USER_ID")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column(name="USER_NAME")
	public String getUserName() {
		return userName + " from getter";
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
