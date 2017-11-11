package com.gopal.ehr.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ALLERGYDETAILS")
@NamedQuery(name = QueryConstants.QUERY_AllERY_SEARCH, query = "select c from AllergyDetailsEntity c where c.allergyCode=?1")
public class AllergyDetailsEntity {

	@Id
	@Column(name = "ALLERGY_ID")
	@SequenceGenerator(name = "allDetSeq", sequenceName = "JPA_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "allDetSeq")
	private Long allergyId;

	@Column(name = "ALLERGY_CODE")
	private Long allergyCode;

	@Column(name = "ALLERGY_DESCRIPTION")
	private String allergyDescription;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "patientEntity")
	private List<PatientAllergyEntity> allDetEntity;

	public AllergyDetailsEntity() {

	}

	public AllergyDetailsEntity(Long allergyCode, String allergyDescription, Long allergyId) {
		super();
		this.allergyCode = allergyCode;
		this.allergyDescription = allergyDescription;
		this.allergyId = allergyId;
	}

	public List<PatientAllergyEntity> getAllDetEntity() {
		return allDetEntity;
	}

	public void setAllDetEntity(List<PatientAllergyEntity> allDetEntity) {
		this.allDetEntity = allDetEntity;
	}

	public Long getAllergyCode() {
		return allergyCode;
	}

	public void setAllergyCode(Long allergyCode) {
		this.allergyCode = allergyCode;
	}

	public String getAllergyDescription() {
		return allergyDescription;
	}

	public void setAllergyDescription(String allergyDescription) {
		this.allergyDescription = allergyDescription;
	}

	public Long getAllergyId() {
		return allergyId;
	}

	public void setAllergyId(Long allergyId) {
		this.allergyId = allergyId;
	}

	@Override
	public String toString() {
		return "PatientAllergyEntity [allergyCode=" + allergyCode + ", allergyDescription=" + allergyDescription
				+ ", allergyId=" + allergyId + "]";
	}

}
