package com.LMS.Learning_Management_System.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class Enrollments {
	
	@EmbeddedId
	private EnrollmentId enr_id;
	
	@ManyToOne
	@MapsId("usn")
	@JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne
	@MapsId("c_id")
	@JoinColumn(name = "course_id")
	private Course course;

	private int marks;

	public Enrollments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Enrollments(EnrollmentId enr_id, Student student, Course course, int marks) {
		super();
		this.enr_id = enr_id;
		this.student = student;
		this.course = course;
		this.marks = marks;
	}

	public EnrollmentId getEnr_id() {
		return enr_id;
	}

	public void setEnr_id(EnrollmentId enr_id) {
		this.enr_id = enr_id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

//	@Override
//	public String toString() {
//		return "Enrollments [enr_id=" + enr_id + ", student=" + student + ", course=" + course + ", marks=" + marks
//				+ "]";
//	}
	
	


}
