package org.koushik.javabrains.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.koushik.javabrains.model.ErrorMessage;


/* Handles ALL exceptions because of Throwable */
// @Provider  // commenting this annot disables this Mapper!
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {
		
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(),
				                                     500, 
				                                     "http://www.google.com");
		
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errorMessage)
				.build();
	}

}