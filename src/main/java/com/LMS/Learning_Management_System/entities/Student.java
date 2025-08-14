package com.LMS.Learning_Management_System.entities;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;



@Entity
public class Student {
	@Id
	private String USN;
	private String S_name;
	private int semester;
	private String dept;
	
	@OneToMany(mappedBy = "student")
	private List<Enrollments> enrollments;

	public String getUSN() {
		return USN;
	}

	public void setUSN(String uSN) {
		USN = uSN;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getS_name() {
		return S_name;
	}

	public void setS_name(String s_name) {
		S_name = s_name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public List<Enrollments> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollments> enrollments) {
		this.enrollments = enrollments;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student Details:\n"
				+ " [USN=" + USN + ", "
						+ "S_name=" + S_name + ", "
								+ "semester=" + semester + ", "
										+ "dept=" + dept + "]";
	}

	

	
}
