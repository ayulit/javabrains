package org.javabrains.koushnik.dto;

import javax.persistence.Embeddable;

@Embeddable // annotation for specify Value type object (in opposition to Entity type object)
public class Address {

	private String street;
	private String city;
	private String state;
	private String pincode;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
}
