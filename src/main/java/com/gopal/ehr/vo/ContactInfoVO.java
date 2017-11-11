package com.gopal.ehr.vo;

public class ContactInfoVO {

	private String email;
	private Long homePhone;
	private Long cellPhone;
	private String methodOfContact;

	public ContactInfoVO() {

	}

	public ContactInfoVO(String email, Long homePhone, Long cellPhone, String methodOfContact) {
		this.email = email;
		this.homePhone = homePhone;
		this.cellPhone = cellPhone;
		this.methodOfContact = methodOfContact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(Long homePhone) {
		this.homePhone = homePhone;
	}

	public Long getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(Long cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getMethodOfContact() {
		return methodOfContact;
	}

	public void setMethodOfContact(String methodOfContact) {
		this.methodOfContact = methodOfContact;
	}

	@Override
	public String toString() {
		return "ContactInfo [email=" + email + ", homePhone=" + homePhone + ", cellPhone=" + cellPhone
				+ ", methodOfContact=" + methodOfContact + "]";
	}

}
