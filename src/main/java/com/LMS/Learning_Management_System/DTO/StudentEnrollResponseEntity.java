package com.LMS.Learning_Management_System.DTO;

public class StudentEnrollResponseEntity {
	private String usn;
	private String sName;
	private int courseMarks;
	public String getUsn() {
		return usn;
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getCourseMarks() {
		return courseMarks;
	}
	public void setCourseMarks(int courseMarks) {
		this.courseMarks = courseMarks;
	}
	public StudentEnrollResponseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentEnrollResponseEntity(String usn, String sName, int courseMarks) {
		super();
		this.usn = usn;
		this.sName = sName;
		this.courseMarks = courseMarks;
	}
	
	
}
