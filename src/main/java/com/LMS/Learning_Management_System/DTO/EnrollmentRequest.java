package com.LMS.Learning_Management_System.DTO;

import java.util.List;

public class EnrollmentRequest {
	private String stUSN;
	private List<Integer> courseIds;
	
	
	public String getStUSN() {
		return stUSN;
	}


	public void setStUSN(String stUSN) {
		this.stUSN = stUSN;
	}


	public List<Integer> getCourseIds() {
		return courseIds;
	}


	public void setCourseIds(List<Integer> courseIds) {
		this.courseIds = courseIds;
	}


	public EnrollmentRequest(String stUSN, List<Integer> courseIds) {
		super();
		this.stUSN = stUSN;
		this.courseIds = courseIds;
	}


	public EnrollmentRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
