package com.mahesh.springbootapp.rest.exhandler;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.mahesh.springbootapp.rest.exception.ErrorResponse;
import com.mahesh.springbootapp.rest.exception.NoRecordFoundException;

@Provider
public class NoRecordFoundProvider implements ExceptionMapper<NoRecordFoundException> {

	@Override
	public Response toResponse(NoRecordFoundException exception) {
		final ErrorResponse entity = new ErrorResponse();
		entity.setErrorCode("Error-101");
		entity.setErrorDesc(exception.getMessage());

		return Response.status(509).entity(entity).build();
	}

}
