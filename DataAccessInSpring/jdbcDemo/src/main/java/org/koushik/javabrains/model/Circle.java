package org.koushik.javabrains.model;

/** This is model class, it models table from db */
public class Circle {

	private int id;
	private String name;
	
	public int getId() {
		return id;
	}	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/** this setting constructor is common in JDBC */
	public Circle(int circleId, String name) {
		setId(circleId);
		setName(name);
	}
	public Circle() {
		// TODO Auto-generated constructor stub
	}	

}
