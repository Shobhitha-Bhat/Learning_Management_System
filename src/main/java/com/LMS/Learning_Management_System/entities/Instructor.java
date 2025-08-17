package com.LMS.Learning_Management_System.entities;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import jakarta.persistence.JoinColumn;

@Entity
public class Instructor {
	
	@Id
	private String fid;
	private String fname;
	private String dept;
	
	@ManyToMany
    @JoinTable(
        name = "instructor_course",
        joinColumns = @JoinColumn(name = "fid"),
        inverseJoinColumns = @JoinColumn(name = "cid")
    )
	private List<Course> courses;
	
	
	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
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
		return "Instructor [F_id=" + fid + ", F_name=" + fname + ", dept=" + dept + "]";
	}

	public Instructor() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(fid);
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
	    if(!(o instanceof Instructor)) return false;
	    Instructor other = (Instructor) o;
	    return Objects.equals(fid, other.fid);
	}
	
	
	

}
