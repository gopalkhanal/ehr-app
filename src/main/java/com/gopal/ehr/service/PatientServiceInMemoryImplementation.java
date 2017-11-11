package com.gopal.ehr.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gopal.ehr.data.PatientAllergyData;
import com.gopal.ehr.data.PatientData;

@Service
public class PatientServiceInMemoryImplementation implements PatientService {

	private HashMap<Long, PatientData> patientDBMap = new HashMap<Long, PatientData>();

	@Override
	public PatientData createPatient(final PatientData patientData) {

		if (patientData != null)
			patientData.setId(System.currentTimeMillis());
		patientDBMap.put(patientData.getId(), patientData);

		return patientData;
	}

	@Override
	public void modifyPatient(final PatientData patient) {

		System.out.println("This part is not done...");
	}

	@Override
	public PatientData findPatient(Long key) {

		return patientDBMap.get(key);
	}

	@Override
	public List<PatientData> searchPatient(String name, String dob, String gender, Long zip) {

		List<PatientData> result = new ArrayList<>();

		Collection<PatientData> allPatients = patientDBMap.values();

		for (PatientData pData : allPatients) {
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
	public PatientAllergyData createPatientAllergy(PatientAllergyData patientAllergyVO) {

		System.out.println("This method is used only for JpaImplementation...");
		return null;
	}

	@Override
	public HashMap<Long, PatientData> searchPatients() {

		System.out.println("We don't need this...because we're using List...");
		return null;
	}

}
