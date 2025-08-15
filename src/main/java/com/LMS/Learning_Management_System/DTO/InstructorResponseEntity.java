package com.LMS.Learning_Management_System.DTO;

public class InstructorResponseEntity {
	private String fId;
	private String fName;
	private String dept;
	public String getfId() {
		return fId;
	}
	public void setfId(String fId) {
		this.fId = fId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public InstructorResponseEntity(String fId, String fName, String dept) {
		super();
		this.fId = fId;
		this.fName = fName;
		this.dept = dept;
	}
	public InstructorResponseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
