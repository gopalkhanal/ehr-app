package com.gopal.ehr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PATIENTALLERGY")
public class PatientAllergyEntity {

	@Id
	@Column(name = "PATALLERGY_ID")
	@SequenceGenerator(name = "allSeq", sequenceName = "JPA_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "allSeq")
	private Long patientAllergyId;

	@Column(name = "DATE_CREATED")
	private String dateCreated;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PATIENTID_FK")
	private PatientEntity patientEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ALLEGYID_FK")
	private AllergyDetailsEntity allergyDetailsEntity;

	public PatientAllergyEntity() {

	}

	public PatientAllergyEntity(Long patientAllergyId, PatientEntity patientEntity,
			AllergyDetailsEntity allergyDetailsEntity, String dateCreated) {
		super();
		this.patientAllergyId = patientAllergyId;
		this.patientEntity = patientEntity;
		this.allergyDetailsEntity = allergyDetailsEntity;
		this.dateCreated = dateCreated;
	}

	public Long getPatientAllergyId() {
		return patientAllergyId;
	}

	public void setPatientAllergyId(Long patientAllergyId) {
		this.patientAllergyId = patientAllergyId;
	}

	public PatientEntity getPatientEntity() {
		return patientEntity;
	}

	public void setPatientEntity(PatientEntity patientEntity) {
		this.patientEntity = patientEntity;
	}

	public AllergyDetailsEntity getAllergyDetailsEntity() {
		return allergyDetailsEntity;
	}

	public void setAllergyDetailsEntity(AllergyDetailsEntity allergyDetailsEntity) {
		this.allergyDetailsEntity = allergyDetailsEntity;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "PatientAllergyEntity [patientAllergyId=" + patientAllergyId + ", patientEntity=" + patientEntity
				+ ", allergyDetailsEntity=" + allergyDetailsEntity + ", dateCreated=" + dateCreated + "]";
	}

}
