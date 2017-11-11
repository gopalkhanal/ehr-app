package com.gopal.ehr.service;

import com.gopal.ehr.vo.AllergyDetailsVO;

public interface AllergyDetailsService {

	AllergyDetailsVO findAllergyDetails(final Long allergyCode);

	void removeAllergyDetails(final Long patientAllergyId);
}
