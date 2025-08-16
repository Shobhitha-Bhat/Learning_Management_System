package com.LMS.Learning_Management_System.DTO;

import java.util.List;

public class StudentReport {
//	usn,name, sem,dept,avg marks(GPA) courses enrolled into and their info with marks
	private String usn;
	private String sname;
	private String dept;
	private int semester;
	private double average;
	private List<StudentCoursesReport> screport;
	public String getUsn() {
		return usn;
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public List<StudentCoursesReport> getScreport() {
		return screport;
	}
	public void setScreport(List<StudentCoursesReport> screport) {
		this.screport = screport;
	}
	
	public StudentReport(String usn, String sname, String dept, int semester, double average,
			List<StudentCoursesReport> screport) {
		super();
		this.usn = usn;
		this.sname = sname;
		this.dept = dept;
		this.semester = semester;
		this.average = average;
		this.screport = screport;
	}
	public StudentReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
