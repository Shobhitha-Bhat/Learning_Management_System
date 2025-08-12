package com.LMS.Learning_Management_System.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;


@Entity
public class Student {
	@Id
	private String USN;
	private String S_name;
	private String dept;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "student_courses",
			joinColumns = @JoinColumn(name="student_id"),
			inverseJoinColumns = @JoinColumn(name="course_id"))
	private List<Course> courses;

	public String getUSN() {
		return USN;
	}

	public void setUSN(String uSN) {
		USN = uSN;
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

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [USN=" + USN + ", S_name=" + S_name + ", dept=" + dept + "]";
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
