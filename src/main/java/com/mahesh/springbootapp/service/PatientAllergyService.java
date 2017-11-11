package com.mahesh.springbootapp.service;

import java.util.List;

import com.mahesh.springbootapp.entity.PatientAllergyEntity;
import com.mahesh.springbootapp.vo.PatientAllergyVO;

public interface PatientAllergyService {

	List<PatientAllergyEntity> createPatientAllergyRecord(List<PatientAllergyVO> patientAllergyVO);

}
