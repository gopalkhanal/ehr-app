package com.gopal.ehr.service;

import java.util.List;

import com.gopal.ehr.data.PatientAllergyData;
import com.gopal.ehr.entity.PatientAllergyEntity;

public interface PatientAllergyService {

	List<PatientAllergyEntity> createPatientAllergyRecord(List<PatientAllergyData> patientAllergyVO);

}
