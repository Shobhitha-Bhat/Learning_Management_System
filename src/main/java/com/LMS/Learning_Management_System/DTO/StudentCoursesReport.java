package com.LMS.Learning_Management_System.DTO;

public class StudentCoursesReport {
	private int cid;
	private String cname;
	private int marks;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public StudentCoursesReport(int cid, String cname, int marks) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.marks = marks;
	}
	public StudentCoursesReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
