package com.gopal.ehr.service;

import java.util.HashMap;
import java.util.List;

import com.gopal.ehr.data.PatientAllergyData;
import com.gopal.ehr.data.PatientData;

public interface PatientService {

	PatientData createPatient(final PatientData patientData);

	void modifyPatient(final PatientData patientData);

	PatientData findPatient(final Long id);

	List<PatientData> searchPatient(final String name, final String dob, final String gender, final Long zip);

	HashMap<Long, PatientData> searchPatients();

	PatientAllergyData createPatientAllergy(PatientAllergyData patientAllergyVO);

}
