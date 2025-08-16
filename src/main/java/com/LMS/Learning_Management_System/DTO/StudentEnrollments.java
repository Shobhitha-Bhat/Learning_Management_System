package com.LMS.Learning_Management_System.DTO;

import java.util.ArrayList;
import java.util.List;

public class StudentEnrollments {
	private String usn;
	private String sName;
	private int semester;
	private List<Integer> courseIds=new ArrayList<>();
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
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public List<Integer> getCourseIds() {
		return courseIds;
	}
	public void setCourseIds(List<Integer> courseIds) {
		this.courseIds = courseIds;
	}
	public StudentEnrollments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentEnrollments(String usn, String sName, int semester, List<Integer> courseIds) {
		super();
		this.usn = usn;
		this.sName = sName;
		this.semester = semester;
		this.courseIds = courseIds;
	}
	
	
}
