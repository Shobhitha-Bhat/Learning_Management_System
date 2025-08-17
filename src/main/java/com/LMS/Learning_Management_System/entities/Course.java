package com.LMS.Learning_Management_System.entities;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToMany;

import jakarta.persistence.OneToMany;


@Entity
public class Course {
	
	@Id
	private int cid;
	private String c_name;
	
	@OneToMany(mappedBy = "course")
	private List<Enrollments> enrollments;
	

    @ManyToMany(mappedBy = "courses")
    private List<Instructor> instructors;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public List<Enrollments> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollments> enrollments) {
		this.enrollments = enrollments;
	}


	public List<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(List<Instructor> instructors) {
		this.instructors = instructors;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Course [c_id=" + cid + ", c_name=" + c_name + "]";
	}

	public Course(int cid, String c_name, List<Enrollments> enrollments, List<Instructor> instructors) {
		super();
		this.cid = cid;
		this.c_name = c_name;
		this.enrollments = enrollments;
		this.instructors = instructors;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(c_name, other.c_name) && cid == other.cid
				&& Objects.equals(enrollments, other.enrollments) && Objects.equals(instructors, other.instructors);
	}

	
	

}
