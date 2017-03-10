package org.koushik.javabrains.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/* Special mapper class for mapping DataNotFoundException to response
 * using ErrorMessage model */
@Provider // this annot registers us in JAX-RS, so it will know, that mapper is here ot map an exception
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException exception) {		
		return Response.status(Status.NOT_FOUND).build();
	}

}
