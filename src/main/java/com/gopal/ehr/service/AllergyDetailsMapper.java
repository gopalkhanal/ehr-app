package com.gopal.ehr.service;

import org.springframework.stereotype.Component;

import com.gopal.ehr.entity.AllergyDetailsEntity;
import com.gopal.ehr.vo.AllergyDetailsVO;

@Component
public class AllergyDetailsMapper {

	public AllergyDetailsVO mapToAllergyDetailsVO(AllergyDetailsEntity allergyDetailsEntity) {

		AllergyDetailsVO allergyDetailsVO = new AllergyDetailsVO();

		allergyDetailsVO.setAllergyCode(allergyDetailsEntity.getAllergyCode());
		allergyDetailsVO.setAllergyDescription(allergyDetailsEntity.getAllergyDescription());
		allergyDetailsVO.setAllergyId(allergyDetailsEntity.getAllergyId());

		return allergyDetailsVO;
	}
}
