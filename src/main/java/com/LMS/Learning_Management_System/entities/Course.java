package com.LMS.Learning_Management_System.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


@Entity
public class Course {
	
	@Id
	private int c_id;
	private String c_name;
	
	@ManyToMany(mappedBy = "courses")
	private List<Student> students;
	
	@ManyToOne
	@JoinColumn(name="course_faculty")
	private Instructor instructor;

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Course [c_id=" + c_id + ", c_name=" + c_name + ", students=" + students + "]";
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
