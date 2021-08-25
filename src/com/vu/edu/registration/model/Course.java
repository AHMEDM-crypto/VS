package com.vu.edu.registration.model;

public class Course {
	private String courseId;
	private String courseTitle;
	private String courseLevel;
	private String courseType;
	private String startDate;
	private String endDate;
	private String coursePrequisite;
	private int enrollmentLimit;
	private int currentEnrollement;
	private int openSeats;
	private String tuition;
	
	
	
	public int getEnrollmentLimit() {
		return enrollmentLimit;
	}
	public void setEnrollmentLimit(int enrollmentLimit) {
		this.enrollmentLimit = enrollmentLimit;
	}
	public int getCurrentEnrollement() {
		return currentEnrollement;
	}
	public void setCurrentEnrollement(int currentEnrollement) {
		this.currentEnrollement = currentEnrollement;
	}
	public int getOpenSeats() {
		return openSeats;
	}
	public void setOpenSeats(int openSeats) {
		this.openSeats = openSeats;
	}
	public String getTuition() {
		return tuition;
	}
	public void setTuition(String tuition) {
		this.tuition = tuition;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getCourseLevel() {
		return courseLevel;
	}
	public void setCourseLevel(String courseLevel) {
		this.courseLevel = courseLevel;
	}
	public String getCourseType() {
		return courseType;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getCoursePrequisite() {
		return coursePrequisite;
	}
	public void setCoursePrequisite(String coursePrequisite) {
		this.coursePrequisite = coursePrequisite;
	}
	
	
	
}
