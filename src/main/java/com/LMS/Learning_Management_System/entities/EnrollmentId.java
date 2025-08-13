package com.LMS.Learning_Management_System.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;


@Embeddable
public class EnrollmentId implements Serializable{
	
	private String USN;
	private int c_id;
	
	public EnrollmentId() {
		
	}

	public EnrollmentId(String uSN, int c_id) {
//		super();
		USN = uSN;
		this.c_id = c_id;
	}

	public String getUSN() {
		return USN;
	}

	public void setUSN(String uSN) {
		USN = uSN;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(USN, c_id);
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
		return Objects.equals(USN, other.USN) && c_id == other.c_id;
	}
	
	
	

}
