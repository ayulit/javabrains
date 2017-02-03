package org.javabrains.koushnik.dto;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
		
	@Id @GeneratedValue // for Primary Key + autogenerate	
	private int userId;
	
	//@Transient // skip this field
	private String userName;
		
	@Temporal(TemporalType.DATE)  // for persisting date w/o time
	//@Temporal(TemporalType.TIME)  // for persisting time w/o date
	private Date joinedDate;
	
	// this is Value object
	@Embedded // don't confuse with @Embeddable, which we mark class declaration
	@AttributeOverrides({
	@AttributeOverride (name="street", column=@Column(name="HOME_STREET_NAME")),
	@AttributeOverride (name="city", column=@Column(name="HOME_CITY_NAME")),
	@AttributeOverride (name="state", column=@Column(name="HOME_STATE_NAME")),
	@AttributeOverride (name="pincode", column=@Column(name="HOME_PIN_CODE"))
	})
	private Address homeAddress;

	// what if we have another Address object ?! Overriding Default col name for one of objects!
	@Embedded	
	private Address officeAddress;
	
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
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	
	
}
