package com.gopal.ehr.service;

import java.util.HashMap;
import java.util.List;

import com.gopal.ehr.vo.PatientAllergyVO;
import com.gopal.ehr.vo.PatientDataVO;

public interface PatientService {

	PatientDataVO createPatient(final PatientDataVO patientData);

	void modifyPatient(final PatientDataVO patientData);

	PatientDataVO findPatient(final Long id);

	List<PatientDataVO> searchPatient(final String name, final String dob, final String gender, final Long zip);

	HashMap<Long, PatientDataVO> searchPatients();

	PatientAllergyVO createPatientAllergy(PatientAllergyVO patientAllergyVO);

}
