package com.gopal.ehr.service;

import org.springframework.stereotype.Component;

import com.gopal.ehr.entity.PatientAllergyEntity;
import com.gopal.ehr.vo.PatientAllergyVO;

@Component
public class PatientAllergyMapper {

	public PatientAllergyEntity mapToPatientAllergyEntity(final PatientAllergyEntity patientAllergyEntity,
			PatientAllergyVO patAllergyVO) {

		patientAllergyEntity.setDateCreated(patAllergyVO.getDateCreated());

		return patientAllergyEntity;
	}

	public PatientAllergyVO mapToPatientAllergyVO(PatientAllergyEntity patientAllergyEntity) {

		PatientAllergyVO patientAllergyVO = new PatientAllergyVO();

		patientAllergyVO.setDateCreated(patientAllergyEntity.getDateCreated());
		patientAllergyVO.setPatientAllergyId(patientAllergyEntity.getPatientAllergyId());
		patientAllergyVO.setAllergyId(patientAllergyEntity.getAllergyDetailsEntity().getAllergyId());

		return patientAllergyVO;
	}

}
