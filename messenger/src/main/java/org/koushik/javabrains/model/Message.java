package org.koushik.javabrains.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/** Model class for data layer (JDBC / Hibernate / etc) */
@XmlRootElement 	// JAXB in action
public class Message {

	private long id;
	private String message;
	private Date created;
	private String author;
	// every message has a bunch of comments!
	private Map<Long, Comment> comments = new HashMap<>();
 
	public Message() {
		/* no-arg constructor always needed,
		 * when you mess up with XML or JSON ! */
	}
	
	// constructor here to stub data retrieving via hardcode 
	public Message(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.created = new Date(); // just picks current date
		this.author = author;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	// we dont want to comment data to show up,
	// when the message instances pulled up in the API
	@XmlTransient // so ignorance for conversion
	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}
	
}
