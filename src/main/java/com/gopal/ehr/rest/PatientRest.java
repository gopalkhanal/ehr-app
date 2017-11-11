package com.gopal.ehr.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.gopal.ehr.data.AllergyDetailsData;
import com.gopal.ehr.data.PatientAllergyData;
import com.gopal.ehr.data.PatientData;
import com.gopal.ehr.service.AllergyDetailsService;
import com.gopal.ehr.service.PatientService;

@Path("/patient")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class PatientRest {

	@Autowired
	@Qualifier("psJpaImpl")
	private PatientService patientService;

	@Autowired
	private AllergyDetailsService allergyDetailsService;

	// Creating new Patient
	@POST
	public Response createPatient(final PatientData patientDataVo) {

		final PatientData entity = patientService.createPatient(patientDataVo);
		System.out.println("Creating done");
		return Response.ok().entity(entity).build();

	}

	// Creating new Allergy
	@POST
	@Path("/patientAllergy")
	public Response createPatientAllergy(final PatientAllergyData patientAllergyVO) {

		final PatientAllergyData patAllergyVO = patientService.createPatientAllergy(patientAllergyVO);

		return Response.ok().entity(patAllergyVO).build();
	}

	// Modifying Patient
	@PUT
	public Response modify(final PatientData patientDataVo) {

		System.out.println("Modifying patient record");
		patientService.modifyPatient(patientDataVo);

		return Response.noContent().build();
	}

	// Finding Patient by Id
	@GET
	@Path("/{patientId}")
	public Response find(@PathParam("patientId") Long key) {
		System.out.println("get...");
		final PatientData entity = patientService.findPatient(key);
		return Response.ok().entity(entity).build();

	}

	// Searching Patient
	@GET
	@Path("/search")
	public Response search(@QueryParam("name") final String name, @QueryParam("dob") final String dob,
			@QueryParam("gender") final String gender, @QueryParam("zip") final Long zip) {

		System.out.println("restsearch");

		final List<PatientData> searchResult = patientService.searchPatient(name, dob, gender, zip);

		PatientSearchResults entity = new PatientSearchResults(searchResult);

		return Response.ok().entity(entity).build();
	}

	// Finding Allergy by AllergyCode
	@GET
	@Path("/allergy/{allergyCode}")
	public Response findAllergyDetails(@PathParam("allergyCode") final Long allergyCode) {

		final AllergyDetailsData allergyDetailsEntity = allergyDetailsService.findAllergyDetails(allergyCode);

		return Response.ok().entity(allergyDetailsEntity).build();
	}

	// Remove/Delete Allergy Details
	@DELETE
	@Path("/allergy/{patientAllergyId}")
	public Response removeAllergyDetails(@PathParam("patientAllergyId") final Long patientAllergyId) {

		allergyDetailsService.removeAllergyDetails(patientAllergyId);
		return Response.noContent().build();
	}
}
