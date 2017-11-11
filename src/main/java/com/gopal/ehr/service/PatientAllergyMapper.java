package com.gopal.ehr.service;

import org.springframework.stereotype.Component;

import com.gopal.ehr.data.PatientAllergyData;
import com.gopal.ehr.entity.PatientAllergyEntity;

@Component
public class PatientAllergyMapper {

	public PatientAllergyEntity mapToPatientAllergyEntity(final PatientAllergyEntity patientAllergyEntity,
			PatientAllergyData patAllergyVO) {

		patientAllergyEntity.setDateCreated(patAllergyVO.getDateCreated());

		return patientAllergyEntity;
	}

	public PatientAllergyData mapToPatientAllergyVO(PatientAllergyEntity patientAllergyEntity) {

		PatientAllergyData patientAllergyVO = new PatientAllergyData();

		patientAllergyVO.setDateCreated(patientAllergyEntity.getDateCreated());
		patientAllergyVO.setPatientAllergyId(patientAllergyEntity.getPatientAllergyId());
		patientAllergyVO.setAllergyId(patientAllergyEntity.getAllergyDetailsEntity().getAllergyId());

		return patientAllergyVO;
	}

}
