package org.koushik.javabrains.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.koushik.javabrains.model.ErrorMessage;

/* Special mapper class for mapping DataNotFoundException to response
 * using ErrorMessage model */
@Provider // this annot registers us in JAX-RS, so it will know, that mapper is here ot map an exception
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(),
				                                     404, 
				                                     "http://www.google.com");
		
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}

}
