package com.mahesh.springbootapp.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class RestDemo {

	@GET
	public String welcome() {
		return "Welcome to REST web services practice";
	}
}
