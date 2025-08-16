package com.LMS.Learning_Management_System.DTO;

import java.util.List;


public class CourseReport {
	private int cid;
	private String cname;
	private List<InstructorResponseEntity> instructors;
	private int stCount;
	private double averageMarks;
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
	
	public List<InstructorResponseEntity> getInstructors() {
		return instructors;
	}
	public void setInstructors(List<InstructorResponseEntity> instructors) {
		this.instructors = instructors;
	}
	public int getStCount() {
		return stCount;
	}
	public void setStCount(int stCount) {
		this.stCount = stCount;
	}
	public double getAverageMarks() {
		return averageMarks;
	}
	public void setAverageMarks(double averageMarks) {
		this.averageMarks = averageMarks;
	}
	public CourseReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CourseReport(int cid, String cname, List<InstructorResponseEntity> instructors, int stCount,
			double averageMarks) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.instructors = instructors;
		this.stCount = stCount;
		this.averageMarks = averageMarks;
	}
	
	
	

}
