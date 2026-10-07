package com.bean;

public class Address {
	private String landMark;
	private String city;
	private int pincode;

	public Address() {
		System.out.println("Address Default Constructor");
	}

	public Address(String landMark, String city, int pincode) {
		System.out.println("Address Parametersized Constructor");
		this.landMark = landMark;
		this.city = city;
		this.pincode = pincode;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		System.out.println("SET LANDMARK");
		this.landMark = landMark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		System.out.println("SET CITY");
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		System.out.println("SET PINCODE");
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [landMark=" + landMark + ", city=" + city + ", pincode=" + pincode + "]";
	}

}
