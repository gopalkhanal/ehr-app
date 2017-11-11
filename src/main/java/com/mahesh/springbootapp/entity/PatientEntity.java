package com.mahesh.springbootapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PATIENT") // select p from PatientEntity WHERE p.frstName=1? AND p.DOB=?2'
@NamedQueries({
		@NamedQuery(name = QueryConstants.QUERY_CUSTOMER_SEARCH, query = "select p from PatientEntity p where p .firstName=?1 OR p.dob=?2 AND p.gender=?3 OR p.addressEntity.zip=?4"),
		@NamedQuery(name = QueryConstants.QUERY_PATIENT_LIST_SEARCH, query = "select p from PatientEntity p") })
public class PatientEntity {

	@Id
	@Column(name = "PATIENT_ID")
	@SequenceGenerator(name = "custSeq", sequenceName = "JPA_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "custSeq")
	private Long id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "DOB")
	private String dob;

	@Column(name = "PATIENT_CODE")
	private String patientCode;

	@Column(name = "PATIENT_STATUS")
	private String patientStatus;

	@Column(name = "SSN")
	private Long ssn;

	@Column(name = "DATE_CREATED")
	private String dateCreated;

	@Column(name = "DATE_MODIFIED")
	private String dateModified;

	@Embedded
	private AddressEntity addressEntity;

	@Embedded
	private ContactInfoEntity contactInfoEntity;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "patientEntity")
	private List<PatientAllergyEntity> patientsAllergy;// = new ArrayList<>();

	public PatientEntity() {

	}

	public PatientEntity(Long id, String firstName, String lastName, String gender, String dob, String patientCode,
			String patientStatus, Long ssn, String dateCreated, String dateModified, AddressEntity addressEntity,
			ContactInfoEntity contactInfoEntity) {
		super();
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
		this.addressEntity = addressEntity;
		this.contactInfoEntity = contactInfoEntity;
	}

	public List<PatientAllergyEntity> getPatientsAllergy() {
		if (patientsAllergy == null)
			patientsAllergy = new ArrayList<PatientAllergyEntity>();
		return patientsAllergy;
	}

	public void setPatientsAllergy(List<PatientAllergyEntity> patientsAllergy) {
		this.patientsAllergy = patientsAllergy;
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

	public AddressEntity getAddressEntity() {
		return addressEntity;
	}

	public void setAddressEntity(AddressEntity addressEntity) {
		this.addressEntity = addressEntity;
	}

	public ContactInfoEntity getContactInfoEntity() {
		return contactInfoEntity;
	}

	public void setContactInfoEntity(ContactInfoEntity contactInfoEntity) {
		this.contactInfoEntity = contactInfoEntity;
	}

	@Override
	public String toString() {
		return "PatientEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", dob=" + dob + ", patientCode=" + patientCode + ", patientStatus=" + patientStatus + ", ssn=" + ssn
				+ ", dateCreated=" + dateCreated + ", dateModified=" + dateModified + ", addressEntity=" + addressEntity
				+ ", contactInfoEntity=" + contactInfoEntity + "]";
	}

}
