package com.LMS.Learning_Management_System.DTO;

import java.util.List;

public class EnrollmentList {
	private int cId;
	private List<StudentEnrollResponseEntity> stList;
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public List<StudentEnrollResponseEntity> getStList() {
		return stList;
	}
	public void setStList(List<StudentEnrollResponseEntity> stList) {
		this.stList = stList;
	}
	public EnrollmentList(int cId, List<StudentEnrollResponseEntity> stList) {
		super();
		this.cId = cId;
		this.stList = stList;
	}
	public EnrollmentList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
