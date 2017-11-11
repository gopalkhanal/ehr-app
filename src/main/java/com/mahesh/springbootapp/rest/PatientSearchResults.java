package com.mahesh.springbootapp.rest;

import java.util.List;

import com.mahesh.springbootapp.vo.PatientDataVO;

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
