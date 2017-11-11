package com.mahesh.springbootapp.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mahesh.springbootapp.vo.PatientAllergyVO;
import com.mahesh.springbootapp.vo.PatientDataVO;

@Service
public class PatientServiceInMemoryImplementation implements PatientService {

	private HashMap<Long, PatientDataVO> patientDBMap = new HashMap<Long, PatientDataVO>();

	@Override
	public PatientDataVO createPatient(final PatientDataVO patientData) {

		if (patientData != null)
			patientData.setId(System.currentTimeMillis());
		patientDBMap.put(patientData.getId(), patientData);

		return patientData;
	}

	@Override
	public void modifyPatient(final PatientDataVO patient) {

		System.out.println("This part is not done...");
	}

	@Override
	public PatientDataVO findPatient(Long key) {

		return patientDBMap.get(key);
	}

	@Override
	public List<PatientDataVO> searchPatient(String name, String dob, String gender, Long zip) {

		List<PatientDataVO> result = new ArrayList<>();

		Collection<PatientDataVO> allPatients = patientDBMap.values();

		for (PatientDataVO pData : allPatients) {
			if (pData.getFirstName().toLowerCase().startsWith(name.toLowerCase())) {
				result.add(pData);
			} else if (pData.getDob().equals(dob)) {
				result.add(pData);
			} else if (pData.getGender().equals(gender)) {
				result.add(pData);
			} else if (pData.getAddressVO().getZip().longValue() == zip) {
				result.add(pData);
			} else {
				System.out.println("Invalid input...");
			}

		}

		return result;
	}

	@Override
	public PatientAllergyVO createPatientAllergy(PatientAllergyVO patientAllergyVO) {

		System.out.println("This method is used only for JpaImplementation...");
		return null;
	}

	@Override
	public HashMap<Long, PatientDataVO> searchPatients() {

		System.out.println("We don't need this...because we're using List...");
		return null;
	}

}
