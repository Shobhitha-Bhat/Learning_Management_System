package com.LMS.Learning_Management_System.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;



@Entity
public class Student {
	@Id
	private String usn;
	private String sName;
	private int semester;
	private String dept;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Enrollments> enrollments;

	

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
				+ " [USN=" + usn + ", "
						+ "S_name=" + sName + ", "
								+ "semester=" + semester + ", "
										+ "dept=" + dept + "]";
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getUsn() {
		return usn;
	}

	public void setUsn(String usn) {
		this.usn = usn;
	}

	

	
}
