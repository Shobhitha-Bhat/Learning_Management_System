package com.LMS.Learning_Management_System.DTO;

public class InstructorCourseReport {
	private int cid;
	private String cname;
	private double avgMarks;
	private int studentcnt;
	public InstructorCourseReport(int cid, String cname, double avgMarks, int studentcnt) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.avgMarks = avgMarks;
		this.studentcnt = studentcnt;
	}
	public InstructorCourseReport() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public double getAvgMarks() {
		return avgMarks;
	}
	public void setAvgMarks(double avgMarks) {
		this.avgMarks = avgMarks;
	}
	public int getStudentcnt() {
		return studentcnt;
	}
	public void setStudentcnt(int studentcnt) {
		this.studentcnt = studentcnt;
	}
	
	
}
