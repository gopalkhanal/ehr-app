package com.mahesh.springbootapp.service;

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

import com.mahesh.springbootapp.entity.AllergyDetailsEntity;
import com.mahesh.springbootapp.entity.PatientAllergyEntity;
import com.mahesh.springbootapp.entity.PatientEntity;
import com.mahesh.springbootapp.entity.QueryConstants;
import com.mahesh.springbootapp.rest.exception.DuplicateDataException;
import com.mahesh.springbootapp.vo.PatientAllergyVO;
import com.mahesh.springbootapp.vo.PatientDataVO;

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
	public PatientDataVO createPatient(PatientDataVO patientDataVO) {

		Random random = new Random();

		// Setting PatientCode before persisting to database.
		patientDataVO.setPatientCode(String.format("%04d", random.nextInt(10000)));

		// Setting DateCreated before persisting to database.
		String timeStamp = new SimpleDateFormat("yyyy-mm-dd").format(new java.util.Date());
		patientDataVO.setDateCreated(timeStamp);

		// Mapping PatientDataVO to PatientEntity before persisting Patient records to
		// database.
		PatientEntity patientEntity = patientMapper.mapToPatientEntity(patientDataVO);
		System.out.println("Mapping is done");

		/*
		 * if (entity == null) { throw new InvalidDataException("invalid entity"); }
		 */
		List<PatientEntity> patientRecordListDB = patientRecordListDB();
		for (PatientEntity patientEntityList : patientRecordListDB) {
			System.out.println(patientEntityList.getFirstName() + " new: " + patientEntity.getFirstName());
			if (patientEntityList.getFirstName().equalsIgnoreCase(patientEntity.getFirstName())) {
				// System.out.println("name matched");
				if (patientEntityList.getDob().equalsIgnoreCase(patientEntity.getDob())) {
					// System.out.println("name and dob matched");

					if (patientEntityList.getGender().equalsIgnoreCase(patientEntity.getGender())) {
						// System.out.println("name dob zip gender matched");
						throw new DuplicateDataException("the patient exists");
					} else {
						// System.out.println("no duplicate gender");
					}

				} else {
					// System.out.println("no duplicate dob,zip,gender");
				}
			} else {
				// System.out.println("no duplicate record");
			}
		}

		// Now, Patient records is ready to persist to the database and here we're doing
		// that with the help of EntityManager.
		entityManager.persist(patientEntity);
		System.out.println("Persisting is done");

		// Setting the patient Id because it is the auto generated sequence in the
		// database.
		patientDataVO.setId(patientEntity.getId());

		// Creating PatientAllergyRecord
		List<PatientAllergyVO> allergyVOList = patientDataVO.getPatientAllergyVO();
		List<PatientAllergyEntity> allergyEntityList = allergyService.createPatientAllergyRecord(allergyVOList);

		for (PatientAllergyEntity patientAllergyEntity : allergyEntityList) {

			patientEntity.getPatientsAllergy().add(patientAllergyEntity);
			patientAllergyEntity.setPatientEntity(patientEntity);

			for (PatientAllergyVO patientAllergyVO : allergyVOList) {

				patientAllergyVO.setPatientId(patientDataVO.getId());
				patientAllergyVO.setPatientAllergyId(patientAllergyEntity.getPatientAllergyId());
			}
		}

		return patientDataVO;

	}

	// Select all patient record from database and check for validation...
	private List<PatientEntity> patientRecordListDB() {
		TypedQuery<PatientEntity> query = entityManager.createNamedQuery(QueryConstants.QUERY_PATIENT_LIST_SEARCH,
				PatientEntity.class);
		return null;
	}

	@Override
	public void modifyPatient(PatientDataVO patientDataVO) {

		String timeStamp = new SimpleDateFormat("yyyy-mm-dd").format(new java.util.Date());
		patientDataVO.setDateModified(timeStamp);

		PatientEntity patientEntity = entityManager.find(PatientEntity.class, patientDataVO.getId());
		patientEntity = patientMapper.mapToPatientEntity(patientEntity, patientDataVO);

		entityManager.persist(patientEntity);
		System.out.println("Modify is done..");
	}

	@Override
	public PatientDataVO findPatient(Long id) {

		final PatientEntity patientEntity = entityManager.find(PatientEntity.class, id);

		final PatientDataVO result = patientMapper.mapToPatientDataVO(patientEntity);

		List<PatientAllergyVO> patientAllergyList = new ArrayList<PatientAllergyVO>();
		List<PatientAllergyEntity> patientAllergyEntityList = patientEntity.getPatientsAllergy();

		for (PatientAllergyEntity patientAllergyEntity : patientAllergyEntityList) {

			patientAllergyList.add(allergyMapper.mapToPatientAllergyVO(patientAllergyEntity));
			// Confusing
			patientAllergyEntity.setPatientEntity(patientEntity);

		}

		for (PatientAllergyVO patientAllergyVO : patientAllergyList) {

			patientAllergyVO.setPatientId(patientEntity.getId());
		}

		result.setPatientAllergyVO(patientAllergyList);
		System.out.println(result);

		return result;

	}

	@Override
	public List<PatientDataVO> searchPatient(String name, String dob, String gender, Long zip) {

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
	public PatientAllergyVO createPatientAllergy(PatientAllergyVO patientAllergyVO) {

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
	public HashMap<Long, PatientDataVO> searchPatients() {
		System.out.println("This method is only applicable for PatientServiceInMemoryImplementation...");
		return null;
	}

}
