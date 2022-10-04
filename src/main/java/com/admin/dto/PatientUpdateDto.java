package com.admin.dto;

public class PatientUpdateDto {

	private String patientName;
	private String address;
	private String dob;
	private String emailId;
	private String phoneNumber;
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public PatientUpdateDto(String patientName, String address, String dob, String emailId, String phoneNumber) {
		super();
		this.patientName = patientName;
		this.address = address;
		this.dob = dob;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
	}
	public PatientUpdateDto() {
		super();
	}

	
	
	
}
