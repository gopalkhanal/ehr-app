package com.mahesh.springbootapp.rest.exhandler;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.mahesh.springbootapp.rest.exception.ErrorResponse;
import com.mahesh.springbootapp.rest.exception.InvalidDataException;

@Provider
public class InvalidDataProvider implements ExceptionMapper<InvalidDataException> {

	@Override
	public Response toResponse(InvalidDataException exception) {
		final ErrorResponse entity = new ErrorResponse();
		entity.setErrorCode("PATIENT-100");
		entity.setErrorDesc("Invalid data to create patient");

		return Response.status(511).type(MediaType.APPLICATION_JSON).entity(entity).build();
	}

}
