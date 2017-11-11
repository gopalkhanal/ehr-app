package com.gopal.ehr.service;

import com.gopal.ehr.data.AllergyDetailsData;

public interface AllergyDetailsService {

	AllergyDetailsData findAllergyDetails(final Long allergyCode);

	void removeAllergyDetails(final Long patientAllergyId);
}
