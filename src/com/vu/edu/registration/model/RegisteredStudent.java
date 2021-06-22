package com.vu.edu.registration.model;

public class RegisteredStudent {
	private String studentId;
	private String firstName;
	private String lastName;
	private String dob; 
    private String parentFirst;
    private String parentLast;
    private String status;
    private int version;
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getParentFirst() {
		return parentFirst;
	}
	public void setParentFirst(String parent_first) {
		this.parentFirst = parent_first;
	}
	public String getParentLast() {
		return parentLast;
	}
	public void setParentLast(String parent_last) {
		this.parentLast = parent_last;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
    
    
}
