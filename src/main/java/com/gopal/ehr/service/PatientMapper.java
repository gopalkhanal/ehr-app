package com.gopal.ehr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gopal.ehr.entity.AddressEntity;
import com.gopal.ehr.entity.ContactInfoEntity;
import com.gopal.ehr.entity.PatientEntity;
import com.gopal.ehr.vo.AddressVO;
import com.gopal.ehr.vo.ContactInfoVO;
import com.gopal.ehr.vo.PatientDataVO;

@Component
public class PatientMapper {

	// Create
	public PatientEntity mapToPatientEntity(PatientDataVO patientDataVO) {

		System.out.println("hit inside mapper class");
		return mapToPatientEntity(new PatientEntity(), patientDataVO);

	}

	// Modify
	public PatientEntity mapToPatientEntity(PatientEntity patientEntity, PatientDataVO patientDataVO) {

		System.out.println("Creating patient");
		patientEntity.setFirstName(patientDataVO.getFirstName());
		patientEntity.setLastName(patientDataVO.getLastName());
		patientEntity.setGender(patientDataVO.getGender());
		patientEntity.setDob(patientDataVO.getDob());
		patientEntity.setPatientCode(patientDataVO.getPatientCode());
		patientEntity.setPatientStatus(patientDataVO.getPatientStatus());
		patientEntity.setSsn(patientDataVO.getSsn());
		patientEntity.setDateCreated(patientDataVO.getDateCreated());
		patientEntity.setDateModified(patientDataVO.getDateModified());

		System.out.println("Setting patient details");

		patientEntity.setAddressEntity(mapToAddressEntity(patientDataVO.getAddressVO()));
		System.out.println("Setting address is done..");

		patientEntity.setContactInfoEntity(mapToContactInfoEntity(patientDataVO.getContactInfoVO()));
		System.out.println("Setting contact info is done..");

		return patientEntity;

	}

	// Find
	public PatientDataVO mapToPatientDataVO(PatientEntity patientEntity) {
		PatientDataVO patientData = new PatientDataVO();
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

		patientData.setAddressVO(mapToAddressVO(patientEntity.getAddressEntity()));

		patientData.setContactInfoVO(mapToContactInfoVO(patientEntity.getContactInfoEntity()));

		return patientData;
	}

	// Search
	public List<PatientDataVO> mapToPatientDataList(final List<PatientEntity> source) {

		final List<PatientDataVO> results = new ArrayList<PatientDataVO>();

		for (PatientEntity entity : source) {
			results.add(mapToPatientDataVO(entity));
		}
		return results;
	}

	public AddressVO mapToAddressVO(AddressEntity addressEntity) {

		AddressVO addressVO = new AddressVO();

		addressVO.setCity(addressEntity.getCity());
		addressVO.setState(addressEntity.getState());
		addressVO.setStreet(addressEntity.getStreet());
		addressVO.setZip(addressEntity.getZip());

		return addressVO;
	}

	public AddressEntity mapToAddressEntity(AddressVO addressVO) {

		AddressEntity addressEntity = new AddressEntity();

		addressEntity.setCity(addressVO.getCity());
		addressEntity.setState(addressVO.getState());
		addressEntity.setStreet(addressVO.getStreet());
		addressEntity.setZip(addressVO.getZip());

		return addressEntity;
	}

	public ContactInfoVO mapToContactInfoVO(ContactInfoEntity contactInfoEntity) {

		ContactInfoVO contactInfoVO = new ContactInfoVO();

		contactInfoVO.setCellPhone(contactInfoEntity.getCellPhone());
		contactInfoVO.setEmail(contactInfoEntity.getEmail());
		contactInfoVO.setHomePhone(contactInfoEntity.getHomePhone());
		contactInfoVO.setMethodOfContact(contactInfoEntity.getMethodOfContact());

		return contactInfoVO;
	}

	public ContactInfoEntity mapToContactInfoEntity(ContactInfoVO contactInfoVO) {

		ContactInfoEntity contactInfoEntity = new ContactInfoEntity();

		contactInfoEntity.setCellPhone(contactInfoVO.getCellPhone());
		contactInfoEntity.setEmail(contactInfoVO.getEmail());
		contactInfoEntity.setHomePhone(contactInfoVO.getHomePhone());
		contactInfoEntity.setMethodOfContact(contactInfoVO.getMethodOfContact());

		return contactInfoEntity;
	}

}
