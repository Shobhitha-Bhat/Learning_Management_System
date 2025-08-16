package com.LMS.Learning_Management_System.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;


@Embeddable
public class EnrollmentId implements Serializable{
	
	private String usn;
	private int c_id;
	
	public EnrollmentId() {
		
	}

	

	public EnrollmentId(String usn, int c_id) {
		super();
		this.usn = usn;
		this.c_id = c_id;
	}



	

	public String getUsn() {
		return usn;
	}



	public void setUsn(String usn) {
		this.usn = usn;
	}



	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(usn, c_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnrollmentId other = (EnrollmentId) obj;
		return Objects.equals(usn, other.usn) && c_id == other.c_id;
	}
	
	
	

}
