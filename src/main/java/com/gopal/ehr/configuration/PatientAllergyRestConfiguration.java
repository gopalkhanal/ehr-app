package com.gopal.ehr.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.gopal.ehr.rest.PatientRest;
import com.gopal.ehr.rest.RestDemo;

@Configuration
public class PatientAllergyRestConfiguration extends ResourceConfig {

	public PatientAllergyRestConfiguration() {
		register(RestDemo.class);
		register(PatientRest.class);
	}

}
