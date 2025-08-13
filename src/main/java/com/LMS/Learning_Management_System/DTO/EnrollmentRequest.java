package com.LMS.Learning_Management_System.DTO;

import java.util.List;

public class EnrollmentRequest {
	private String St_USN;
	private List<Integer> course_ids;
	
	public String getSt_USN() {
		return St_USN;
	}
	public void setSt_USN(String st_USN) {
		St_USN = st_USN;
	}
	public List<Integer> getCourse_ids() {
		return course_ids;
	}
	public void setCourse_ids(List<Integer> course_ids) {
		this.course_ids = course_ids;
	}
	public EnrollmentRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
