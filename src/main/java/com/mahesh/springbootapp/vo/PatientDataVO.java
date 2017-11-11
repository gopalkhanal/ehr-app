package com.mahesh.springbootapp.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PatientDataVO {

	private Long id;
	private String firstName;
	private String lastName;
	private String gender;
	private String dob;
	private String patientCode;
	private String patientStatus;
	private Long ssn;
	private String dateCreated;
	private String dateModified;
	private AddressVO addressVO;
	private ContactInfoVO contactInfoVO;

	private List<PatientAllergyVO> patientAllergyVO;

	public PatientDataVO() {

	}

	public PatientDataVO(Long id, String firstName, String lastName, String gender, String dob, String patientCode,
			String patientStatus, Long ssn, String dateCreated, String dateModified, AddressVO addressVO,
			ContactInfoVO contactInfoVO) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.patientCode = patientCode;
		this.patientStatus = patientStatus;
		this.ssn = ssn;
		this.dateCreated = dateCreated;
		this.dateModified = dateModified;
		this.addressVO = addressVO;
		this.contactInfoVO = contactInfoVO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPatientCode() {
		return patientCode;
	}

	public void setPatientCode(String patientCode) {
		this.patientCode = patientCode;
	}

	public String getPatientStatus() {
		return patientStatus;
	}

	public void setPatientStatus(String patientStatus) {
		this.patientStatus = patientStatus;
	}

	public Long getSsn() {
		return ssn;
	}

	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDateModified() {
		return dateModified;
	}

	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}

	public AddressVO getAddressVO() {
		return addressVO;
	}

	public void setAddressVO(AddressVO addressVO) {
		this.addressVO = addressVO;
	}

	public ContactInfoVO getContactInfoVO() {
		return contactInfoVO;
	}

	public void setContactInfoVO(ContactInfoVO contactInfoVO) {
		this.contactInfoVO = contactInfoVO;
	}

	public List<PatientAllergyVO> getPatientAllergyVO() {
		return patientAllergyVO;
	}

	public void setPatientAllergyVO(List<PatientAllergyVO> patientAllergyVO) {
		this.patientAllergyVO = patientAllergyVO;
	}

	@Override
	public String toString() {
		return "PatientData [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", dob=" + dob + ", patientCode=" + patientCode + ", patientStatus=" + patientStatus + ", ssn=" + ssn
				+ ", dateCreated=" + dateCreated + ", dateModified=" + dateModified + ", addressVO=" + addressVO
				+ ", contactInfoVO=" + contactInfoVO + "]";
	}

}
