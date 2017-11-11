package com.gopal.ehr.data;

public class AllergyDetailsData {

	private Long allergyCode;
	private String allergyDescription;
	private Long allergyId;

	public AllergyDetailsData() {

	}

	public AllergyDetailsData(Long allergyCode, String allergyDescription, Long allergyId) {
		super();
		this.allergyCode = allergyCode;
		this.allergyDescription = allergyDescription;
		this.allergyId = allergyId;
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
		return "AllergyDetails [allergyCode=" + allergyCode + ", allergyDescription=" + allergyDescription
				+ ", allergyId=" + allergyId + "]";
	}

}
