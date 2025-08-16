package com.LMS.Learning_Management_System.DTO;

public class UpdateStudent {
	private String sName;
	private int semester;
	private String dept;
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public UpdateStudent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UpdateStudent(String sName, int semester, String dept) {
		super();
		this.sName = sName;
		this.semester = semester;
		this.dept = dept;
	}
	
	
}
