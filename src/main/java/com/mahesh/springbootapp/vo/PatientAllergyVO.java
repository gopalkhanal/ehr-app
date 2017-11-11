package com.mahesh.springbootapp.vo;

public class PatientAllergyVO {

	private Long patientAllergyId;
	private Long allergyId;
	private Long patientId;
	private String dateCreated;

	public PatientAllergyVO() {

	}

	public PatientAllergyVO(Long patientAllergyId, Long allergyId, Long patientId, String dateCreated) {
		super();
		this.patientAllergyId = patientAllergyId;
		this.allergyId = allergyId;
		this.patientId = patientId;
		this.dateCreated = dateCreated;
	}

	public Long getPatientAllergyId() {
		return patientAllergyId;
	}

	public void setPatientAllergyId(Long patientAllergyId) {
		this.patientAllergyId = patientAllergyId;
	}

	public Long getAllergyId() {
		return allergyId;
	}

	public void setAllergyId(Long allergyId) {
		this.allergyId = allergyId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "PatientAllergy [patientAllergyId=" + patientAllergyId + ", allergyId=" + allergyId + ", patientId="
				+ patientId + ", dateCreated=" + dateCreated + "]";
	}

}
