package org.javabrains.koushnik.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/** This is model class */
@Entity
@Table (name="USER_DETAILS")
public class UserDetails {
	// so Entity name will be like a class,
	// but Table name will be as defined in @Table(name='..')
		
	@Id // for Primary Key		
	private int userId;
	
	//@Transient // skip this field
	private String userName;
	
	@Temporal(TemporalType.DATE)  // for persisting date w/o time
	//@Temporal(TemporalType.TIME)  // for persisting time w/o date
	private Date joinedDate;
	
	private String Address;
	
	@Lob // means that it is a LARGE object, will be CLOB type inside DB
	private String description;

	// We can place annots on getters instead!
	// so Hibernate picks up the value from getter 
	
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
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
