package com.gopal.ehr.rest;

import java.util.List;

import com.gopal.ehr.vo.PatientDataVO;

public class PatientSearchResults {

	private List<PatientDataVO> patients;

	public PatientSearchResults() {

	}

	public PatientSearchResults(List<PatientDataVO> patients) {

		this.patients = patients;
	}

	public List<PatientDataVO> getPatients() {
		return patients;
	}

	public void setPatients(List<PatientDataVO> patients) {
		this.patients = patients;
	}

}
