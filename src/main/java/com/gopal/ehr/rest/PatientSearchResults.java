package com.gopal.ehr.rest;

import java.util.List;

import com.gopal.ehr.data.PatientData;

public class PatientSearchResults {

	private List<PatientData> patients;

	public PatientSearchResults() {

	}

	public PatientSearchResults(List<PatientData> patients) {

		this.patients = patients;
	}

	public List<PatientData> getPatients() {
		return patients;
	}

	public void setPatients(List<PatientData> patients) {
		this.patients = patients;
	}

}
