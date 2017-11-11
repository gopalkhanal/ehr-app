package com.gopal.ehr.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gopal.ehr.entity.AllergyDetailsEntity;
import com.gopal.ehr.entity.PatientAllergyEntity;
import com.gopal.ehr.vo.PatientAllergyVO;

@Service("patientAllergyServiceJpaImpl")
@Transactional
public class PatientAllergyServiceJpaImpl implements PatientAllergyService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private PatientAllergyMapper patientAllergyMapper;

	@Override
	public List<PatientAllergyEntity> createPatientAllergyRecord(List<PatientAllergyVO> patientAllergyVOList) {

		List<PatientAllergyEntity> patientAllergyList = new ArrayList<PatientAllergyEntity>();

		for (PatientAllergyVO patAllergyVO : patientAllergyVOList) {

			String timeStamp = new SimpleDateFormat("yyyy-mm-dd").format(new java.util.Date());
			patAllergyVO.setDateCreated(timeStamp);

			PatientAllergyEntity patientAllergyEntity = patientAllergyMapper
					.mapToPatientAllergyEntity(new PatientAllergyEntity(), patAllergyVO);

			final AllergyDetailsEntity allergyDetailsEntity = entityManager.find(AllergyDetailsEntity.class,
					patAllergyVO.getAllergyId());

			entityManager.persist(patientAllergyEntity);

			// Confusing
			// patientAllergyEntity.setPatientAllergyId(patientAllergyEntity.getPatientAllergyId());
			patientAllergyEntity.setAllergyDetailsEntity(allergyDetailsEntity);

			patientAllergyList.add(patientAllergyEntity);
		}

		return patientAllergyList;
	}

}
