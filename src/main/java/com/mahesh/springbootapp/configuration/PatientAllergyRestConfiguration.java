package com.mahesh.springbootapp.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.mahesh.springbootapp.rest.PatientRest;
import com.mahesh.springbootapp.rest.RestDemo;

@Configuration
public class PatientAllergyRestConfiguration extends ResourceConfig {

	public PatientAllergyRestConfiguration() {
		register(RestDemo.class);
		register(PatientRest.class);
	}

}
