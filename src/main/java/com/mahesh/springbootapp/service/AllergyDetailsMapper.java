package com.mahesh.springbootapp.service;

import org.springframework.stereotype.Component;

import com.mahesh.springbootapp.entity.AllergyDetailsEntity;
import com.mahesh.springbootapp.vo.AllergyDetailsVO;

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
