package com.gopal.ehr.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gopal.ehr.data.PatientAllergyData;
import com.gopal.ehr.data.PatientData;
import com.gopal.ehr.entity.AllergyDetailsEntity;
import com.gopal.ehr.entity.PatientAllergyEntity;
import com.gopal.ehr.entity.PatientEntity;
import com.gopal.ehr.entity.QueryConstants;

@Service("psJpaImpl")
@Transactional
public class PatientServiceJpaImpl implements PatientService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private PatientMapper patientMapper;

	@Autowired
	private PatientAllergyService allergyService;

	@Autowired
	private PatientAllergyMapper allergyMapper;

	/**
	 * Creating a new record of Patient in the database with the help of MapperClass
	 * and the Entity Manager(from @PersistenceContext)
	 */
	@Override
	public PatientData createPatient(PatientData patientDataVO) {

		Random random = new Random();

		patientDataVO.setPatientCode(String.format("%04d", random.nextInt(10000)));

		String timeStamp = new SimpleDateFormat("yyyy-mm-dd").format(new java.util.Date());
		patientDataVO.setDateCreated(timeStamp);

		PatientEntity patientEntity = patientMapper.mapToPatientEntity(patientDataVO);
		System.out.println("Mapping is done");

		List<PatientEntity> patientRecordListDB = patientRecordListDB();
		for (PatientEntity patientEntityList : patientRecordListDB) {
			System.out.println(patientEntityList.getFirstName() + " new: " + patientEntity.getFirstName());
			if (patientEntityList.getFirstName().equalsIgnoreCase(patientEntity.getFirstName())) {
				if (patientEntityList.getDob().equalsIgnoreCase(patientEntity.getDob())) {
				}
			}
		}

		entityManager.persist(patientEntity);
		System.out.println("Persisting is done");

		patientDataVO.setId(patientEntity.getId());

		List<PatientAllergyData> allergyVOList = patientDataVO.getPatientAllergyVO();
		List<PatientAllergyEntity> allergyEntityList = allergyService.createPatientAllergyRecord(allergyVOList);

		for (PatientAllergyEntity patientAllergyEntity : allergyEntityList) {

			patientEntity.getPatientsAllergy().add(patientAllergyEntity);
			patientAllergyEntity.setPatientEntity(patientEntity);

			for (PatientAllergyData patientAllergyVO : allergyVOList) {

				patientAllergyVO.setPatientId(patientDataVO.getId());
				patientAllergyVO.setPatientAllergyId(patientAllergyEntity.getPatientAllergyId());
			}
		}

		return patientDataVO;

	}

	private List<PatientEntity> patientRecordListDB() {
		TypedQuery<PatientEntity> query = entityManager.createNamedQuery(QueryConstants.QUERY_PATIENT_LIST_SEARCH,
				PatientEntity.class);
		return null;
	}

	@Override
	public void modifyPatient(PatientData patientDataVO) {

		String timeStamp = new SimpleDateFormat("yyyy-mm-dd").format(new java.util.Date());
		patientDataVO.setDateModified(timeStamp);

		PatientEntity patientEntity = entityManager.find(PatientEntity.class, patientDataVO.getId());
		patientEntity = patientMapper.mapToPatientEntity(patientEntity, patientDataVO);

		entityManager.persist(patientEntity);
		System.out.println("Modify is done..");
	}

	@Override
	public PatientData findPatient(Long id) {

		final PatientEntity patientEntity = entityManager.find(PatientEntity.class, id);

		final PatientData result = patientMapper.mapToPatientData(patientEntity);

		List<PatientAllergyData> patientAllergyList = new ArrayList<PatientAllergyData>();
		List<PatientAllergyEntity> patientAllergyEntityList = patientEntity.getPatientsAllergy();

		for (PatientAllergyEntity patientAllergyEntity : patientAllergyEntityList) {

			patientAllergyList.add(allergyMapper.mapToPatientAllergyVO(patientAllergyEntity));
			patientAllergyEntity.setPatientEntity(patientEntity);

		}

		for (PatientAllergyData patientAllergyVO : patientAllergyList) {

			patientAllergyVO.setPatientId(patientEntity.getId());
		}

		result.setPatientAllergyVO(patientAllergyList);
		System.out.println(result);

		return result;

	}

	@Override
	public List<PatientData> searchPatient(String name, String dob, String gender, Long zip) {

		final TypedQuery<PatientEntity> query = entityManager.createNamedQuery(QueryConstants.QUERY_CUSTOMER_SEARCH,
				PatientEntity.class);
		query.setParameter("1", name);
		query.setParameter("2", dob);
		query.setParameter("3", gender);
		query.setParameter("4", zip);

		final List<PatientEntity> results = query.getResultList();

		return patientMapper.mapToPatientDataList(results);
	}

	@Override
	public PatientAllergyData createPatientAllergy(PatientAllergyData patientAllergyVO) {

		final PatientEntity patientEntity = entityManager.find(PatientEntity.class, patientAllergyVO.getPatientId());

		String timeStamp = new SimpleDateFormat("yyyy-mm-dd").format(new java.util.Date());
		patientAllergyVO.setDateCreated(timeStamp);

		final AllergyDetailsEntity allergyDetailsEntity = entityManager.find(AllergyDetailsEntity.class,
				patientAllergyVO.getAllergyId());
		final PatientAllergyEntity patientAllergyEntity = allergyMapper
				.mapToPatientAllergyEntity(new PatientAllergyEntity(), patientAllergyVO);

		patientAllergyEntity.setAllergyDetailsEntity(allergyDetailsEntity);
		patientAllergyEntity.setPatientEntity(patientEntity);

		List<PatientAllergyEntity> patientAllergyEntityList = patientEntity.getPatientsAllergy();

		patientAllergyEntityList.add(patientAllergyEntity);
		patientEntity.setPatientsAllergy(patientAllergyEntityList);

		entityManager.persist(patientEntity);
		entityManager.persist(patientAllergyEntity);

		patientAllergyVO.setPatientAllergyId(patientAllergyEntity.getPatientAllergyId());

		return patientAllergyVO;
	}

	@Override
	public HashMap<Long, PatientData> searchPatients() {
		System.out.println("This method is only applicable for PatientServiceInMemoryImplementation...");
		return null;
	}

}
