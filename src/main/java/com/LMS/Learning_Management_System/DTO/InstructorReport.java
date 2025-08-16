package com.LMS.Learning_Management_System.DTO;

import java.util.List;

public class InstructorReport {
	private String fid;
	private String fname;
	private String dept;
	private List<InstructorCourseReport> icreport;
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public List<InstructorCourseReport> getIcreport() {
		return icreport;
	}
	public void setIcreport(List<InstructorCourseReport> icreport) {
		this.icreport = icreport;
	}
	public InstructorReport(String fid, String fname, String dept, List<InstructorCourseReport> icreport) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.dept = dept;
		this.icreport = icreport;
	}
	public InstructorReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
