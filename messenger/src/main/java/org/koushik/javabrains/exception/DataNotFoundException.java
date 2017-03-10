package org.koushik.javabrains.exception;

/* Exception of ours */
public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7710722396066852685L;
	
	// standart Java
	public DataNotFoundException(String message) {
		super(message);
	}
	
}
