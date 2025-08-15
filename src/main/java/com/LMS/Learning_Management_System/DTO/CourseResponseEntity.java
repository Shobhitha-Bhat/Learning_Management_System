package com.LMS.Learning_Management_System.DTO;

public class CourseResponseEntity {
	private int cId;
	private String cName;
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public CourseResponseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CourseResponseEntity(int cId, String cName) {
		super();
		this.cId = cId;
		this.cName = cName;
	}
	
}
