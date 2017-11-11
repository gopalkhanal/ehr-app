package com.mahesh.springbootapp.service;

import com.mahesh.springbootapp.vo.AllergyDetailsVO;

public interface AllergyDetailsService {

	AllergyDetailsVO findAllergyDetails(final Long allergyCode);

	void removeAllergyDetails(final Long patientAllergyId);
}
