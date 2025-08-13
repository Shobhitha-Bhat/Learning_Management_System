package com.LMS.Learning_Management_System.entities;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import jakarta.persistence.JoinColumn;

@Entity
public class Instructor {
	
	@Id
	private String F_id;
	private String F_name;
	private String dept;
	

	
	@ManyToMany
    @JoinTable(
        name = "instructor_course",
        joinColumns = @JoinColumn(name = "F_id"),
        inverseJoinColumns = @JoinColumn(name = "c_id")
    )
	private List<Course> courses;
	
	public String getF_id() {
		return F_id;
	}

	public void setF_id(String f_id) {
		F_id = f_id;
	}

	public String getF_name() {
		return F_name;
	}

	public void setF_name(String f_name) {
		F_name = f_name;
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
		return "Instructor [F_id=" + F_id + ", F_name=" + F_name + ", dept=" + dept + "]";
	}

	public Instructor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
