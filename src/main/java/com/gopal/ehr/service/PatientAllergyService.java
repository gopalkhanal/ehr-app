package com.gopal.ehr.service;

import java.util.List;

import com.gopal.ehr.entity.PatientAllergyEntity;
import com.gopal.ehr.vo.PatientAllergyVO;

public interface PatientAllergyService {

	List<PatientAllergyEntity> createPatientAllergyRecord(List<PatientAllergyVO> patientAllergyVO);

}
