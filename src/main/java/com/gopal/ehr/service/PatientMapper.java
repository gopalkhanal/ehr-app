package com.gopal.ehr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gopal.ehr.data.AddressData;
import com.gopal.ehr.data.ContactInfoData;
import com.gopal.ehr.data.PatientData;
import com.gopal.ehr.entity.AddressEntity;
import com.gopal.ehr.entity.ContactInfoEntity;
import com.gopal.ehr.entity.PatientEntity;

@Component
public class PatientMapper {

	// Create
	public PatientEntity mapToPatientEntity(PatientData patientData) {

		System.out.println("hit inside mapper class");
		return mapToPatientEntity(new PatientEntity(), patientData);

	}

	// Modify
	public PatientEntity mapToPatientEntity(PatientEntity patientEntity, PatientData patientData) {

		System.out.println("Creating patient");
		patientEntity.setFirstName(patientData.getFirstName());
		patientEntity.setLastName(patientData.getLastName());
		patientEntity.setGender(patientData.getGender());
		patientEntity.setDob(patientData.getDob());
		patientEntity.setPatientCode(patientData.getPatientCode());
		patientEntity.setPatientStatus(patientData.getPatientStatus());
		patientEntity.setSsn(patientData.getSsn());
		patientEntity.setDateCreated(patientData.getDateCreated());
		patientEntity.setDateModified(patientData.getDateModified());

		System.out.println("Setting patient details");

		patientEntity.setAddressEntity(mapToAddressEntity(patientData.getAddressVO()));
		System.out.println("Setting address is done..");

		patientEntity.setContactInfoEntity(mapToContactInfoEntity(patientData.getContactInfoVO()));
		System.out.println("Setting contact info is done..");

		return patientEntity;

	}

	// Find
	public PatientData mapToPatientData(PatientEntity patientEntity) {
		PatientData patientData = new PatientData();
		patientData.setId(patientEntity.getId());
		patientData.setFirstName(patientEntity.getFirstName());
		patientData.setLastName(patientEntity.getLastName());
		patientData.setGender(patientEntity.getGender());
		patientData.setDob(patientEntity.getDob());
		patientData.setPatientCode(patientEntity.getPatientCode());
		patientData.setPatientStatus(patientEntity.getPatientStatus());
		patientData.setSsn(patientEntity.getSsn());
		patientData.setDateCreated(patientEntity.getDateCreated());
		patientData.setDateModified(patientEntity.getDateModified());

		patientData.setAddressVO(mapToAddress(patientEntity.getAddressEntity()));

		patientData.setContactInfoVO(mapToContactInfo(patientEntity.getContactInfoEntity()));

		return patientData;
	}

	// Search
	public List<PatientData> mapToPatientDataList(final List<PatientEntity> source) {

		final List<PatientData> results = new ArrayList<PatientData>();

		for (PatientEntity entity : source) {
			results.add(mapToPatientData(entity));
		}
		return results;
	}

	public AddressData mapToAddress(AddressEntity addressEntity) {

		AddressData addressVO = new AddressData();

		addressVO.setCity(addressEntity.getCity());
		addressVO.setState(addressEntity.getState());
		addressVO.setStreet(addressEntity.getStreet());
		addressVO.setZip(addressEntity.getZip());

		return addressVO;
	}

	public AddressEntity mapToAddressEntity(AddressData addressVO) {

		AddressEntity addressEntity = new AddressEntity();

		addressEntity.setCity(addressVO.getCity());
		addressEntity.setState(addressVO.getState());
		addressEntity.setStreet(addressVO.getStreet());
		addressEntity.setZip(addressVO.getZip());

		return addressEntity;
	}

	public ContactInfoData mapToContactInfo(ContactInfoEntity contactInfoEntity) {

		ContactInfoData contactInfoVO = new ContactInfoData();

		contactInfoVO.setCellPhone(contactInfoEntity.getCellPhone());
		contactInfoVO.setEmail(contactInfoEntity.getEmail());
		contactInfoVO.setHomePhone(contactInfoEntity.getHomePhone());
		contactInfoVO.setMethodOfContact(contactInfoEntity.getMethodOfContact());

		return contactInfoVO;
	}

	public ContactInfoEntity mapToContactInfoEntity(ContactInfoData contactInfoVO) {

		ContactInfoEntity contactInfoEntity = new ContactInfoEntity();

		contactInfoEntity.setCellPhone(contactInfoVO.getCellPhone());
		contactInfoEntity.setEmail(contactInfoVO.getEmail());
		contactInfoEntity.setHomePhone(contactInfoVO.getHomePhone());
		contactInfoEntity.setMethodOfContact(contactInfoVO.getMethodOfContact());

		return contactInfoEntity;
	}

}
