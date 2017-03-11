package org.koushik.javabrains.model;

/* Class for HATEOAS,
 * but we can also use JAX-RS' class javax.ws.rs.core.Link
 * but its a liitle buggy while JSON conversion */

// No need of @XmlRootElements, because it's gonna be a member of Message, so not root
public class Link {

	private String link;
	private String rel;
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	
}
