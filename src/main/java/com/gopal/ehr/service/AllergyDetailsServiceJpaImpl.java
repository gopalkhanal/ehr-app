package com.gopal.ehr.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gopal.ehr.data.AllergyDetailsData;
import com.gopal.ehr.entity.AllergyDetailsEntity;
import com.gopal.ehr.entity.PatientAllergyEntity;
import com.gopal.ehr.entity.QueryConstants;

@Service("allergyDetailsServiceJpaImpl")
@Transactional
public class AllergyDetailsServiceJpaImpl implements AllergyDetailsService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private AllergyDetailsMapper allergyDetailsMapper;

	@Override
	public AllergyDetailsData findAllergyDetails(Long allergyCode) {

		TypedQuery<AllergyDetailsEntity> query = entityManager.createNamedQuery(QueryConstants.QUERY_AllERY_SEARCH,
				AllergyDetailsEntity.class);

		query.setParameter(1, allergyCode);

		final AllergyDetailsEntity allergyDetailsEntity = query.getSingleResult();

		final AllergyDetailsData allergyDetailsVO = allergyDetailsMapper.mapToAllergyDetailsVO(allergyDetailsEntity);

		return allergyDetailsVO;
	}

	@Override
	public void removeAllergyDetails(Long patientAllergyId) {

		final PatientAllergyEntity patientAllergyEntity = entityManager.find(PatientAllergyEntity.class,
				patientAllergyId);

		entityManager.remove(patientAllergyEntity);

	}

}
