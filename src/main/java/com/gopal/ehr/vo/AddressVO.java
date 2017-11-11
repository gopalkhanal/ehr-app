package com.gopal.ehr.vo;

public class AddressVO {

	private String Street;
	private String City;
	private String State;
	private Long Zip;

	public AddressVO() {

	}

	public AddressVO(String street, String city, String state, Long zip) {
		Street = street;
		City = city;
		State = state;
		Zip = zip;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public Long getZip() {
		return Zip;
	}

	public void setZip(Long zip) {
		Zip = zip;
	}

	@Override
	public String toString() {
		return "Address [Street=" + Street + ", City=" + City + ", State=" + State + ", Zip=" + Zip + "]";
	}

}
