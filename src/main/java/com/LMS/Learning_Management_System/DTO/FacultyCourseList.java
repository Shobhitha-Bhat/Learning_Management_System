package com.LMS.Learning_Management_System.DTO;

import java.util.List;


public class FacultyCourseList {
	private String fId;
	private String fName;
	private String dept;
	private List<CourseResponseEntity> courses;
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
	public List<CourseResponseEntity> getCourses() {
		return courses;
	}
	public void setCourses(List<CourseResponseEntity> courses) {
		this.courses = courses;
	}
	public FacultyCourseList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FacultyCourseList(String fId, String fName, String dept, List<CourseResponseEntity> courses) {
		super();
		this.fId = fId;
		this.fName = fName;
		this.dept = dept;
		this.courses = courses;
	}
	
	
	
	
	

}
