package com.gopal.ehr.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ContactInfoEntity {
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "HOME_PHONE")
	private Long homePhone;
	@Column(name = "CELL_PHONE")
	private Long cellPhone;
	@Column(name = "METHOD_OF_CONTACT")
	private String methodOfContact;

	public ContactInfoEntity() {

	}

	public ContactInfoEntity(String email, Long homePhone, Long cellPhone, String methodOfContact) {
		super();
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
