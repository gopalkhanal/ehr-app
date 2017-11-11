package com.gopal.ehr.service;

import org.springframework.stereotype.Component;

import com.gopal.ehr.data.AllergyDetailsData;
import com.gopal.ehr.entity.AllergyDetailsEntity;

@Component
public class AllergyDetailsMapper {

	public AllergyDetailsData mapToAllergyDetailsVO(AllergyDetailsEntity allergyDetailsEntity) {

		AllergyDetailsData allergyDetailsVO = new AllergyDetailsData();

		allergyDetailsVO.setAllergyCode(allergyDetailsEntity.getAllergyCode());
		allergyDetailsVO.setAllergyDescription(allergyDetailsEntity.getAllergyDescription());
		allergyDetailsVO.setAllergyId(allergyDetailsEntity.getAllergyId());

		return allergyDetailsVO;
	}
}
